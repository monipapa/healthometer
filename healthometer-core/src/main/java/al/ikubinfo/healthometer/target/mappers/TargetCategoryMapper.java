package al.ikubinfo.healthometer.target.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.target.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.target.entity.TargetCategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface TargetCategoryMapper
    extends DtoToEntityBidirectionalMapper<TargetCategoryDto, TargetCategoryEntity> {

  @Override
  @InheritInverseConfiguration
  TargetCategoryEntity toEntity(TargetCategoryDto dto);

  @Override
  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "description", source = "description")
  @Mapping(target = "unitCategoryDto", source = "unitCategoryEntity")
  TargetCategoryDto toDto(TargetCategoryEntity entity);
}
