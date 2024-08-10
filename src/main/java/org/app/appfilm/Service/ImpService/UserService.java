package org.app.appfilm.Service.ImpService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.app.appfilm.Config.AppConfig;
import org.app.appfilm.DTO.ResponseDTO;
import org.app.appfilm.DTO.UserDTO;
import org.app.appfilm.Exception.CustomException;
import org.app.appfilm.Repository.Entity.UserEntity;
import org.app.appfilm.Repository.IRepo.IUserRepository;
import org.app.appfilm.Service.IService.IUserService;
import org.app.appfilm.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService implements IUserService {
  @Autowired
  @Qualifier(value = "impUserRepo")
  private IUserRepository iUserRepository;

  @Override
  public List<UserDTO> getAllUser(Integer page) {
    return null;
  }

  @Override
  public UserDTO getUserById(int id) {
    try {
      UserEntity userEntity = iUserRepository.findAllById(id);
      if (userEntity.getUserId() != null) {
        return UserConverter.entityToDTO(userEntity);
      } else {
        throw new CustomException("Không tìm thấy User");
      }
    } catch (SQLException e) {
      throw new CustomException("Lỗi User Repo");
    }
  }

  @Override
  public List<UserDTO> filterByParam(Map<String, Object> params) {
    return List.of();
  }

  @Override
  public ResponseDTO login(UserDTO userDTO) {
    return null;
  }

  @Override
  public List<UserDTO> getAllUserByPost(UserDTO userDTO, int page, String sortType) {
    return List.of();
  }

  @Override
  public ResponseDTO register(UserDTO userDTO) {
    return null;
  }

  @Override
  public ResponseDTO updateUser(UserDTO userDTO) {
    return null;
  }

  @Override
  public ResponseDTO deleteUser(int id) {
    return null;
  }

  public static void main(String[] args) {
  }
}
