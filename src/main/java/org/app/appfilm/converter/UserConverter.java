package org.app.appfilm.converter;

import org.app.appfilm.DTO.UserDTO;
import org.app.appfilm.Repository.Entity.UserEntity;

public class UserConverter {
  public static UserDTO entityToDTO(UserEntity userEntity) {
    UserDTO res = new UserDTO.BuilderUserDTO()
        .setUserName(userEntity.getUserName())
        .setPassword(userEntity.getPassword())
        .setEmail(userEntity.getEmailAddress())
        .setUrlAvatarImage(userEntity.getUrlAvatarImage())
        .setDateOfBirth(userEntity.getDateOfBirth())
        .setCountry(userEntity.getCountry())
        .build();

    return res;
  }

  public static UserEntity dtoToEntity(UserDTO userDTO) {
    UserEntity res = new UserEntity();
    res.setUserName(userDTO.getUserName());
    res.setPassword(userDTO.getPassword());
    res.setUrlAvatarImage(userDTO.getUrlAvatarImage());
    res.setDateOfBirth(userDTO.getDateOfBirth());
    res.setCountry(userDTO.getCountry());

    return res;
  }
}
