package al.ikubinfo.healthometer.activity.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.activity.dto.UserTargetCategoryDto;
import al.ikubinfo.healthometer.activity.entity.UserTargetCategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface UserTargetCategoryMapper
        extends DtoToEntityBidirectionalMapper<UserTargetCategoryDto, UserTargetCategoryEntity> {

    @Override
    @InheritInverseConfiguration
    UserTargetCategoryEntity toEntity(UserTargetCategoryDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userDto", source = "userEntity")
    @Mapping(target = "targetCategoryDto", source = "targetCategoryEntity")
    @Mapping(target = "unitSubcategoryDto", source = "unitSubcategoryEntity")
    @Mapping(target = "targetValue", source = "targetValue")
    UserTargetCategoryDto toDto(UserTargetCategoryEntity entity);
}