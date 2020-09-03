package al.ikubinfo.healthometer.users.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.users.dto.StatusDto;
import al.ikubinfo.healthometer.users.entity.StatusEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StatusBidirectionalMapper
    extends DtoToEntityBidirectionalMapper<StatusDto, StatusEntity> {

  @Override
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "description", target = "description")
  })
  StatusDto toDto(StatusEntity entity);

  @Override
  @InheritInverseConfiguration
  StatusEntity toEntity(StatusDto dto);
}
