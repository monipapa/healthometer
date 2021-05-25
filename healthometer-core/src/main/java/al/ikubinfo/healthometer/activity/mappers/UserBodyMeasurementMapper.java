package al.ikubinfo.healthometer.activity.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.activity.dto.UserBodyMeasurementDto;
import al.ikubinfo.healthometer.activity.entity.UserBodyMeasurementEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserBodyMeasurementMapper
        extends DtoToEntityBidirectionalMapper<UserBodyMeasurementDto, UserBodyMeasurementEntity> {

    @Override
    @InheritInverseConfiguration
    UserBodyMeasurementEntity toEntity(UserBodyMeasurementDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userDto", source = "userEntity")
    @Mapping(target = "bodyMeasurementCategoryDto", source = "bodyMeasurementCategoryEntity")
    @Mapping(target = "unitSubcategoryDto", source = "unitSubcategoryEntity")
    @Mapping(target = "value", source = "value")
    UserBodyMeasurementDto toDto(UserBodyMeasurementEntity entity);
}