package org.app.appfilm.Converter;

import org.app.appfilm.DTO.UserDTO.Res.UserResDTO;
import org.app.appfilm.Repository.Entity.UserEntity;

public class UserConverter {
  public static UserResDTO entityToDTO(UserEntity userEntity) {
    UserResDTO res = UserResDTO.builder()
        .userName(userEntity.getUserName())
        .emailAddress(userEntity.getEmailAddress())
        .urlAvatarImage(userEntity.getUrlAvatarImage())
        .dateOfBirth(userEntity.getDateOfBirth())
        .country(userEntity.getCountry())
        .build();

    return res;
  }

  public static UserEntity dtoToEntity(UserResDTO userDTO) {
    UserEntity res = new UserEntity();
    res.setUserName(userDTO.getUserName());
    res.setUrlAvatarImage(userDTO.getUrlAvatarImage());
    res.setDateOfBirth(userDTO.getDateOfBirth());
    res.setCountry(userDTO.getCountry());

    return res;
  }
}
