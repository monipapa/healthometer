package al.ikubinfo.healthometer.activity.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.activity.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.activity.entity.UnitCategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UnitCategoryMapper
    extends DtoToEntityBidirectionalMapper<UnitCategoryDto, UnitCategoryEntity> {

  @Override
  @InheritInverseConfiguration
  UnitCategoryEntity toEntity(UnitCategoryDto dto);

  @Override
  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "description", source = "description")
  @Mapping(target = "defaultUnit", source = "defaultUnit")
  @Mapping(target = "subcategoryDtoList", source = "subcategoryEntityList")
  UnitCategoryDto toDto(UnitCategoryEntity unitCategoryEntity);
}
