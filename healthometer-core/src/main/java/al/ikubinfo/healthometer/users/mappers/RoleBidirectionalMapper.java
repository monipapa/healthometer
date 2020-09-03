package al.ikubinfo.healthometer.users.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.users.dto.RoleDto;
import al.ikubinfo.healthometer.users.entity.RoleEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RoleBidirectionalMapper
    extends DtoToEntityBidirectionalMapper<RoleDto, RoleEntity> {

  @Override
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "description", target = "description")
  })
  RoleDto toDto(RoleEntity entity);

  @Override
  @InheritInverseConfiguration
  RoleEntity toEntity(RoleDto dto);
}
