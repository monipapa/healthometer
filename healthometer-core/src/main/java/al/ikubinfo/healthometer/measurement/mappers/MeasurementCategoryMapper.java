package al.ikubinfo.healthometer.measurement.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.measurement.entity.MeasurementCategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface MeasurementCategoryMapper
        extends DtoToEntityBidirectionalMapper<
        MeasurementCategoryDto, MeasurementCategoryEntity> {

    @Override
    @InheritInverseConfiguration
    MeasurementCategoryEntity toEntity(MeasurementCategoryDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "unitCategoryDto", source = "unitCategoryEntity")
    MeasurementCategoryDto toDto(MeasurementCategoryEntity unitCategoryEntity);
}
