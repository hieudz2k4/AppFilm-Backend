package org.app.appfilm.Converter.Mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.app.appfilm.DTO.UserDTO.Req.UserLoginDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserRegisterDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserUpdateDTO;
import org.app.appfilm.DTO.UserDTO.Res.UserResDTO;
import org.app.appfilm.Repository.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
  public abstract UserResDTO entityToUserResDTO(UserEntity userEntity);
  public abstract UserEntity loginDtoToEntity(UserLoginDTO userLoginDTO);
  public abstract UserEntity registerDtoToEntity(UserRegisterDTO userRegisterDTO);
  public abstract UserEntity updateDtoToEntity(UserUpdateDTO userUpdateDTO);

  public List<UserResDTO> listEntityToListUserResDTO(List<UserEntity> userEntityList) {
    return userEntityList.stream()
        .map(this::entityToUserResDTO) // method reference
        .collect(Collectors.toList());
  }
}