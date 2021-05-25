package al.ikubinfo.healthometer.activity.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.activity.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.activity.entity.UnitSubcategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UnitSubcategoryMapper
    extends DtoToEntityBidirectionalMapper<UnitSubcategoryDto, UnitSubcategoryEntity> {

  @Override
  @InheritInverseConfiguration
  UnitSubcategoryEntity toEntity(UnitSubcategoryDto dto);

  @Override
  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "abbreviation", source = "abbreviation")
  @Mapping(target = "unitCategoryDto", source = "unitCategoryEntity")
  UnitSubcategoryDto toDto(UnitSubcategoryEntity entity);
}
