package al.ikubinfo.healthometer.activity.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface MeasurementMapper
        extends DtoToEntityBidirectionalMapper<MeasurementDto, MeasurementEntity> {

    @Override
    @InheritInverseConfiguration
    MeasurementEntity toEntity(MeasurementDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userDto", source = "userEntity")
    @Mapping(target = "bodyMeasurementCategoryDto", source = "bodyMeasurementCategoryEntity")
    @Mapping(target = "unitSubcategoryDto", source = "unitSubcategoryEntity")
    @Mapping(target = "value", source = "value")
    MeasurementDto toDto(MeasurementEntity entity);
}