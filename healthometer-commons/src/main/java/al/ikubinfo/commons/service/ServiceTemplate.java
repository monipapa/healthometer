package al.ikubinfo.commons.service;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.commons.entity.BaseEntity;
import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.commons.security.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
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
        REPOSITORY extends JpaRepository<ENTITY, Long>> {
    protected final REPOSITORY repository;
    protected final MAPPER mapper;

    //TODO protected
    @Transactional(readOnly = true)
    public List<DTO> getList() {
        doGetList();
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public DTO getSingle(Long id) {
        ENTITY entity = getEntity(id);
        //doGetSingle(entity);
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
        if (/*isValid()*/true) {

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
        } else {
            return dto;
        }
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
        entity=repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        ENTITY entity = getEntity(id);
        doDelete(entity);
        repository.delete(entity);
    }

    //public abstract Boolean isValid();

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
