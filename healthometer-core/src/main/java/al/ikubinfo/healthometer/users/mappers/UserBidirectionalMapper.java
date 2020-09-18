package al.ikubinfo.healthometer.users.mappers;

import al.ikubinfo.commons.mapper.DtoToEntityBidirectionalMapper;
import al.ikubinfo.healthometer.users.dto.UserDto;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    uses = {RoleBidirectionalMapper.class, StatusBidirectionalMapper.class},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserBidirectionalMapper
    extends DtoToEntityBidirectionalMapper<UserDto, UserEntity> {

  @Override
  @Mappings({
    @Mapping(source = "role", target = "roleDto"),
    @Mapping(source = "status", target = "statusDto")
  })
  UserDto toDto(UserEntity entity);

  @Override
  @InheritInverseConfiguration
  UserEntity toEntity(UserDto dto);
}
