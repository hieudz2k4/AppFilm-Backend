package org.app.appfilm.Service.IService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.app.appfilm.DTO.ResponseDTO;
import org.app.appfilm.DTO.UserDTO;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public interface IUserService {
  List<UserDTO> getAllUser(@Nullable Integer page);
  UserDTO getUserById(int id);
  List<UserDTO> filterByParam(Map<String, Object> params);
  ResponseDTO login(UserDTO userDTO);
  ResponseDTO register(UserDTO userDTO);
  List<UserDTO> getAllUserByPost(UserDTO userDTO, int page, String sortType);
  ResponseDTO updateUser(UserDTO userDTO);
  ResponseDTO deleteUser(int id);
}
