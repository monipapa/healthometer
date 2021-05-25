package al.ikubinfo.commons.service;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.commons.entity.BaseEntity;
import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.commons.security.SecurityUtils;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AllArgsConstructor
public abstract class AbstractService<
    ENTITY extends BaseEntity,
    DTO extends BaseDto,
    MAPPER extends DtoToEntityBidirectionalMapper<DTO, ENTITY>,
    REPOSITORY extends JpaRepository<ENTITY, Long>> {
  protected final REPOSITORY repository;
  protected final MAPPER mapper;

  public List<DTO> getList() {
    return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
  }

  public DTO getSingle(Long id) {
    return mapper.toDto(getEntity(id));
  }

  public ENTITY getEntity(Long id) {
    if (id == null) {
      throw new RuntimeException("Unit category id value is null!");
    }
    return repository
        .findById(id)
        .orElseThrow(
            () -> {
              throw new EntityNotFoundException("Entity for id - " + id + " not found");
            });
  }

  public ENTITY save(DTO unitCategoryDto) {
    ENTITY entity = mapper.toEntity(unitCategoryDto);
    entity.setDateCreated(LocalDateTime.now());
    entity.setUserCreated(
        SecurityUtils.getCurrentUsername()
            .orElseThrow(
                () -> {
                  throw new SecurityException(" You are not allowed to add this element!");
                }));
    return repository.save(entity);
  }

  public ENTITY update(Long id, DTO unitCategoryDto) {
    ENTITY entity = mapper.toEntity(unitCategoryDto);
    entity.setUserUpdated(
        SecurityUtils.getCurrentUsername()
            .orElseThrow(
                () -> {
                  throw new SecurityException("You are not allowed to update this unit category!");
                }));
    entity.setDateUpdated(LocalDateTime.now());
    entity.setId(id);
    repository.save(entity);
    return entity;
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
