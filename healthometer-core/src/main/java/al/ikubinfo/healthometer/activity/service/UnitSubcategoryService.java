package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.security.SecurityUtils;
import al.ikubinfo.healthometer.activity.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.activity.entity.UnitSubcategoryEntity;
import al.ikubinfo.healthometer.activity.mappers.UnitCategoryMapper;
import al.ikubinfo.healthometer.activity.mappers.UnitSubcategoryMapper;
import al.ikubinfo.healthometer.activity.repository.UnitSubcategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UnitSubcategoryService {
    private final UnitSubcategoryRepository unitSubcategoryRepository;
    private final UnitSubcategoryMapper unitSubcategoryMapper;
    private final UnitCategoryMapper unitCategoryMapper;
    private final UnitCategoryService unitCategoryService;

    public List<UnitSubcategoryDto> getList() {
        return unitSubcategoryRepository.findAll()
                .stream()
                .map(unitSubcategoryMapper::toDto)
                .collect(Collectors.toList());
    }


    public UnitSubcategoryDto getSingle(Long id) {
        return unitSubcategoryMapper.toDto(getEntity(id));
    }

    public UnitSubcategoryEntity getEntity(Long id) {
        if(id==null){
            throw new RuntimeException("Unit category id value is null!");
        }
        return unitSubcategoryRepository.findById(id)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Entity with id - " + id + " not found");
                });
    }

    public UnitSubcategoryEntity save(UnitSubcategoryDto unitSubcategoryDto) {
        UnitSubcategoryEntity entity = unitSubcategoryMapper.toEntity(unitSubcategoryDto);
        entity.setDateCreated(LocalDateTime.now());
        entity.setUserCreated(SecurityUtils.getCurrentUsername().orElseThrow(() -> {
            throw new SecurityException(" You are not allowed to add this element!");
        }));
        return unitSubcategoryRepository.save(entity);
    }

    public UnitSubcategoryEntity update(Long id, UnitSubcategoryDto unitSubcategoryDto) {
        UnitSubcategoryEntity entity = getEntity(id);
        entity.setUserUpdated(SecurityUtils.getCurrentUsername().orElseThrow(() -> {
            throw new SecurityException("You are not allowed to update this unit category!");
        }));
        entity.setDateUpdated(LocalDateTime.now());
        entity.setName(unitSubcategoryDto.getName());
        entity.setAbbreviation(unitSubcategoryDto.getAbbreviation());
        entity.setUnitCategoryEntity(unitCategoryMapper.toEntity(unitSubcategoryDto.getUnitCategoryDto()));
        unitSubcategoryRepository.save(entity);
        return entity;
    }

    public void delete(Long id) {
        unitSubcategoryRepository.deleteById(id);
    }
}
