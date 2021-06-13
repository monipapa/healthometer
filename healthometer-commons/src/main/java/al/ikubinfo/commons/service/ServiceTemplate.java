package al.ikubinfo.commons.service;

import al.ikubinfo.commons.dto.BaseCriteria;
import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.commons.entity.BaseEntity;
import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.commons.repository.BaseRepository;
import al.ikubinfo.commons.security.SecurityUtils;
import al.ikubinfo.commons.specification.SpecificationBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class ServiceTemplate<
        ENTITY extends BaseEntity,
        DTO extends BaseDto,
        MAPPER extends DtoToEntityBidirectionalMapper<DTO, ENTITY>,
        REPOSITORY extends BaseRepository<ENTITY>,
        CRITERIA extends BaseCriteria,
        SPECIFICATION extends SpecificationBuilder<ENTITY, CRITERIA>> {
  protected final REPOSITORY repository;
  protected final MAPPER mapper;
  protected final SPECIFICATION specificationBuilder;

  @Transactional(readOnly = true)
  public List<DTO> getList() {
    doGetList();
    return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
  }

  @Transactional()
  public DTO getSingle(Long id) {
    ENTITY entity = getEntity(id);
    return mapper.toDto(entity);
  }

  @Transactional(readOnly = true)
  public ENTITY getEntity(Long id) {
    if (id == null) {
      throw new RuntimeException("Id value is null!");
    }
    return repository
            .findById(id)
            .orElseThrow(
                    () -> {
                      throw new EntityNotFoundException("Entity for id - " + id + " not found");
                    });
  }

  @Transactional()
  public DTO save(DTO dto) {

    ENTITY entity = mapper.toEntity(dto);
    entity.setDateCreated(LocalDateTime.now());
    entity.setUserCreated(
            SecurityUtils.getCurrentUsername()
                    .orElseThrow(
                            () -> {
                              throw new SecurityException(" You are not allowed to add this element!");
                            }));
    doSave(entity);
    entity = repository.save(entity);
    return mapper.toDto(entity);

  }

  @Transactional
  public DTO update(Long id, DTO dto) {
    ENTITY entity = mapper.toEntity(dto);
    doUpdate(entity);
    entity.setUserUpdated(
            SecurityUtils.getCurrentUsername()
                    .orElseThrow(
                            () -> {
                              throw new SecurityException("You are not allowed to update this unit category!");
                            }));
    entity.setDateUpdated(LocalDateTime.now());
    entity.setId(id);
    entity = repository.save(entity);
    return mapper.toDto(entity);
  }

  @Transactional
  public void delete(Long id) {
    ENTITY entity = getEntity(id);
    doDelete(entity);
    repository.delete(entity);
  }

  @Transactional(readOnly = true)
  public Page<?> filter(@Nullable CRITERIA criteria) {
    return getEntities(criteria).map(mapper::toDto);
  }

  protected Page<ENTITY> getEntities(@Nullable CRITERIA criteria) {
    Pageable pageable =
            PageRequest.of(
                    criteria.getPageNumber(),
                    criteria.getPageSize(),
                    Sort.Direction.valueOf(criteria.getSortDirection()),
                    criteria.getOrderBy());

    return (criteria != null)
            ? repository.findAll(specificationBuilder.filter(criteria), pageable)
            : repository.findAll(pageable);
  }

  public void doGetList() {
  }

  public void doGetSingle(ENTITY entity) {
  }

  public void doSave(ENTITY entity) {
  }

  public void doUpdate(ENTITY entity) {
  }

  public void doDelete(ENTITY entity) {
  }
}
