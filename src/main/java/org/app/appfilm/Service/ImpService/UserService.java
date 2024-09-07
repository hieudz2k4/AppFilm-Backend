package org.app.appfilm.Service.ImpService;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.app.appfilm.Constant.MsgConstant;
import org.app.appfilm.Converter.Mapper.UserMapper;
import org.app.appfilm.DTO.ResponseDTO;
import org.app.appfilm.DTO.SuccessResDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserLoginDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserRegisterDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserUpdateDTO;
import org.app.appfilm.DTO.UserDTO.Res.UserResDTO;
import org.app.appfilm.Exception.CustomException;
import org.app.appfilm.Repository.Entity.UserEntity;
import org.app.appfilm.Repository.IRepo.IUserRepository;
import org.app.appfilm.Service.IService.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService implements IUserService {
  @Autowired
  private IUserRepository iUserRepository;

  @Autowired
  private UserMapper userMapper;

  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  /**
   * get User By Paging and Sorting(fields)
   * @param pageNo: Page number
   * @param pageSize: size
   * @param sortBy: sort
   * @return List<UserResDTO>
   */
  @Override
  public List<UserResDTO> getAllUserPagingAndSorting(Integer pageNo,
                                                     Integer pageSize,
                                                     String sortBy) {
    List<Order> sorts = new ArrayList<>();

    if (!sortBy.isEmpty()) {
      //sortField:sortType
      Pattern pattern = Pattern.compile("(\\w+?)(:)(.*)");
      Matcher matcher = pattern.matcher(sortBy);

      if (matcher.find()) {
        if ((matcher.group(3)
            .equalsIgnoreCase("asc"))) {
          sorts.add(new Order(Direction.ASC, matcher.group(1)));
        } else {
          sorts.add(new Order(Direction.DESC, matcher.group(1)));
        }
      }
    }

    Pageable pageable = PageRequest.of((pageNo >= 1 ? pageNo - 1 : 0),
                                       pageSize,Sort.by(sorts));

    List<UserEntity> res = iUserRepository.findAll(pageable).getContent();

    List<UserResDTO> rTR = new ArrayList<>();

    if (!res.isEmpty()) {
      res.forEach(userEntity -> rTR.add(userMapper.entityToUserResDTO(userEntity)));
      return rTR;
    } else {
      throw new CustomException("Null PageNo= " + pageNo);
    }

  }

  @Override
  public UserResDTO getUserById(Long id) {
    log.info("UserService-getUserById: " + id);
    return userMapper.entityToUserResDTO(iUserRepository.
                                        findByUserId(id).
                                        orElseThrow(() ->
                                          new CustomException("User Not Found: " + id)
                                        ));
  }

  @Override
  public List<UserResDTO> filterByParam(Map<String, Object> params) {
    Integer pageNo = (Integer) params.get("pageNo");
    Integer pageSize = (Integer) params.get("pageSize");

    String country = params.get("country").toString();

    List<UserEntity> res = iUserRepository.findByCountry(country, (pageNo != null && pageSize != null)?
                                           (PageRequest.of(pageNo, pageSize)):
                                           (PageRequest.of(0, 10)));
    return userMapper.listEntityToListUserResDTO(res);
  }

  @Override
  public ResponseDTO login(UserLoginDTO userDTO) {
    return null;
  }

  @Override
  public List<UserResDTO> getAllUserByPost(UserResDTO userDTO,
                                           int pageNo,
                                           int pageSize,
                                           String sortType) {
    return null;
  }

  @Override
  public ResponseDTO register(UserRegisterDTO userRegisterDTO) {
    UserEntity userEntity = userMapper.registerDtoToEntity(userRegisterDTO);
    return null;
  }

  @Override
  public ResponseDTO updateUser(Long id, UserUpdateDTO userUpdateDTO, HttpServletRequest request) {
    UserEntity userEntity = iUserRepository.findByUserId(id).get();
    if (userUpdateDTO.getPassword().
        equals(userEntity.getPassword())) {
      UserEntity newUser = userMapper.updateDtoToEntity(userUpdateDTO);

      newUser.setUserId(id);

      iUserRepository.save(newUser);

      return SuccessResDTO.builder()
          .statusCode(HttpStatus.OK.value())
          .path(request.getRequestURI())
          .msg(MsgConstant.SUCCESS_UPDATE_USER.toString())
          .msgDetail(null)
          .build();
    } else {
      throw new CustomException(MsgConstant.NOT_SUCCESS_UPDATE_USER.toString());
    }
  }

  @Override
  public ResponseDTO deleteUser(Long id, HttpServletRequest request) {
    iUserRepository.deleteById(id);
    return SuccessResDTO.builder()
        .statusCode(HttpStatus.OK.value())
        .path(request.getRequestURI())
        .msg(MsgConstant.SUCCESS_DELETE_USER.toString())
        .msgDetail(null)
        .build();
  }
}
