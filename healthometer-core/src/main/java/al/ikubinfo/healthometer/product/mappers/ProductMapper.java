package al.ikubinfo.healthometer.product.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.product.dto.ProductDto;
import al.ikubinfo.healthometer.product.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface ProductMapper
        extends DtoToEntityBidirectionalMapper<ProductDto, ProductEntity> {

    @Override
    @InheritInverseConfiguration
    ProductEntity toEntity(ProductDto dto);

    @Override
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "targetCategoryDto", source = "targetCategoryEntity")
    @Mapping(target = "unitSubcategoryDto", source = "unitSubcategoryEntity")
    @Mapping(target = "amountValue", source = "amountValue")
    ProductDto toDto(ProductEntity entity);
}
