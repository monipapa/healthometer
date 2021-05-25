package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.AbstractService;
import al.ikubinfo.healthometer.activity.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.activity.entity.UnitCategoryEntity;
import al.ikubinfo.healthometer.activity.mappers.UnitCategoryMapper;
import al.ikubinfo.healthometer.activity.repository.UnitCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitCategoryService
        extends AbstractService<
        UnitCategoryEntity, UnitCategoryDto, UnitCategoryMapper, UnitCategoryRepository> {
    public UnitCategoryService(UnitCategoryRepository repository, UnitCategoryMapper mapper) {
        super(repository, mapper);
    }
}
  /* private final UnitCategoryRepository unitCategoryRepository;
  private final UnitCategoryMapper unitCategoryMapper;

  public List<UnitCategoryDto> getList() {
      return unitCategoryRepository.findAll()
              .stream()
              .map(unitCategoryMapper::toDto)
              .collect(Collectors.toList());
  }


  public UnitCategoryDto getSingle(Long id) {
      return unitCategoryMapper.toDto(getEntity(id));
  }

  public UnitCategoryEntity getEntity(Long id) {
      if(id==null){
        throw new RuntimeException("Unit category id value is null!");
      }
      return unitCategoryRepository.findById(id)
              .orElseThrow(() -> {
                  throw new EntityNotFoundException("Entity for id - " + id + " not found");
              });
  }

  public UnitCategoryEntity save(UnitCategoryDto unitCategoryDto) {
      UnitCategoryEntity entity = unitCategoryMapper.toEntity(unitCategoryDto);
      entity.setDateCreated(LocalDateTime.now());
      entity.setUserCreated(SecurityUtils.getCurrentUsername().orElseThrow(() -> {
          throw new SecurityException(" You are not allowed to add this element!");
      }));
      return unitCategoryRepository.save(entity);
  }

  public UnitCategoryEntity update(Long id, UnitCategoryDto unitCategoryDto) {
      UnitCategoryEntity entity = getEntity(id);
      entity.setUserUpdated(SecurityUtils.getCurrentUsername().orElseThrow(() -> {
          throw new SecurityException("You are not allowed to update this unit category!");
      }));
      entity.setDateUpdated(LocalDateTime.now());
      entity.setName(unitCategoryDto.getName());
      entity.setDescription(unitCategoryDto.getDescription());
      entity.setDefaultUnit(unitCategoryDto.getDefaultUnit());
      unitCategoryRepository.save(entity);
      return entity;
  }

  public void delete(Long id) {
      unitCategoryRepository.deleteById(id);
  }*/
