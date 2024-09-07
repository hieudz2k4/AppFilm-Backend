package org.app.appfilm.Service.IService;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import org.app.appfilm.DTO.ResponseDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserLoginDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserRegisterDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserUpdateDTO;
import org.app.appfilm.DTO.UserDTO.Res.UserResDTO;
import org.springframework.stereotype.Component;

@Component
public interface IUserService {
  List<UserResDTO> getAllUserPagingAndSorting(Integer pageNo, Integer pageSize, String sortBy);
  UserResDTO getUserById(Long id);
  List<UserResDTO> filterByParam(Map<String, Object> params);
  List<UserResDTO> getAllUserByPost(UserResDTO userDTO, int pageNo, int pageSize, String sortType);

  ResponseDTO login(UserLoginDTO userLoginDTO);
  ResponseDTO register(UserRegisterDTO userRegisterDTO);
  ResponseDTO updateUser(Long id, UserUpdateDTO userUpdateDTO, HttpServletRequest request);
  ResponseDTO deleteUser(Long id, HttpServletRequest request);
}
