package al.ikubinfo.healthometer.activity.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.activity.dto.TargetTrackerDto;
import al.ikubinfo.healthometer.activity.entity.TargetTrackerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface TargetTrackerMapper
    extends DtoToEntityBidirectionalMapper<TargetTrackerDto, TargetTrackerEntity> {

  @Override
  @InheritInverseConfiguration
  TargetTrackerEntity toEntity(TargetTrackerDto dto);

  @Override
  @Mapping(target = "id", source = "id")
  @Mapping(target = "userTargetCategoryDto", source = "userTargetCategoryEntity")
  @Mapping(target = "productDto", source = "productEntity")
  @Mapping(target = "unitSubcategoryDto", source = "unitSubcategoryEntity")
  @Mapping(target = "unit", source = "unit")
  @Mapping(target = "unitValue", source = "unitValue")
  TargetTrackerDto toDto(TargetTrackerEntity entity);
}
