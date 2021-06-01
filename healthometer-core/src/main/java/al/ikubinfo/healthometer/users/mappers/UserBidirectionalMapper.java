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
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "username", target = "username"),
          @Mapping(source = "firstname", target = "firstname"),
          @Mapping(source = "lastname", target = "lastname"),
          @Mapping(source = "email", target = "email"),
          @Mapping(source = "role", target = "roleDto"),
          @Mapping(source = "status", target = "statusDto"),
          @Mapping(source = "bmiMeasurements", target = "bmiMeasurements")
          /*,
    @Mapping(source = "dateCreated", target = "dateCreated"),
    @Mapping(source = "dateUpdated", target = "dateUpdated"),
    @Mapping(source = "userCreated", target = "userCreated"),
    @Mapping(source = "userUpdated", target = "userUpdated")*/
  })
  UserDto toDto(UserEntity entity);

  @Override
  @InheritInverseConfiguration
  UserEntity toEntity(UserDto dto);
}
