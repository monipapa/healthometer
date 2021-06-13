package al.ikubinfo.healthometer.activity.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.activity.dto.TargetDto;
import al.ikubinfo.healthometer.activity.entity.TargetEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface TargetMapper extends DtoToEntityBidirectionalMapper<TargetDto, TargetEntity> {

  @Override
  @InheritInverseConfiguration
  TargetEntity toEntity(TargetDto dto);

  @Override
  @Mapping(target = "id", source = "id")
  @Mapping(target = "userDto", source = "userEntity")
  @Mapping(target = "targetCategoryDto", source = "targetCategoryEntity")
  @Mapping(target = "unitSubcategoryDto", source = "unitSubcategoryEntity")
  @Mapping(target = "targetValue", source = "targetValue")
  TargetDto toDto(TargetEntity entity);
}
