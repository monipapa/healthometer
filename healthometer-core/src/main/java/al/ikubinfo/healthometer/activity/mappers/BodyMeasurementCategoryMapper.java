package al.ikubinfo.healthometer.activity.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.activity.dto.BodyMeasurementCategoryDto;
import al.ikubinfo.healthometer.activity.entity.BodyMeasurementCategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface BodyMeasurementCategoryMapper
        extends DtoToEntityBidirectionalMapper<
        BodyMeasurementCategoryDto, BodyMeasurementCategoryEntity> {

    @Override
    @InheritInverseConfiguration
    BodyMeasurementCategoryEntity toEntity(BodyMeasurementCategoryDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "unitCategoryDto", source = "unitCategoryEntity")
    BodyMeasurementCategoryDto toDto(BodyMeasurementCategoryEntity unitCategoryEntity);
}
