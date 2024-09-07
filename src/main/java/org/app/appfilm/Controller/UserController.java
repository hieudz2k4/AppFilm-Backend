package org.app.appfilm.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import org.app.appfilm.DTO.ResponseDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserLoginDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserRegisterDTO;
import org.app.appfilm.DTO.UserDTO.Req.UserUpdateDTO;
import org.app.appfilm.DTO.UserDTO.Res.UserResDTO;
import org.app.appfilm.Service.IService.IUserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
@RequestMapping(value = "/api/v1/users")
@Tag(name = "User API")
public class UserController {
  private final IUserService iUserService;
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  public UserController(@Qualifier(value = "userService") IUserService iUserService) {
    this.iUserService = iUserService;
  }

  /**
   * Api endpoint get all user paging.
   * @param pageNo The page number
   * @return ResponseEntity<List<UserDTO>>
   */
  @Operation(summary = "Get Users By Page", description = "")
  @GetMapping(path = "")
  public ResponseEntity<List<UserResDTO>> getAllUserPaging(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                           @RequestParam(value = "sortBy", required = false) String sortBy) {
    logger.info("getAllUserPaging run");
    return ResponseEntity.ok(iUserService.getAllUserPagingAndSorting(pageNo, pageSize, sortBy));
  }

  /**
   *
   * @param id: Long
   * @return UserDTO
   */
  @GetMapping(path = "/{id}")
  public UserResDTO getUserById(@PathVariable(value = "id") Long id) {
    logger.info("getUserById: {}", id);
    return iUserService.getUserById(id);
  }

//  @RequestParam(value = "userName", required = false) String userName,
//  @RequestParam(value = "email", required = false) String email,
//  @RequestParam(value = "dateOfBirth", required = false) Date dateOfBirth,
//  @RequestParam(value = "country", required = false) String country,
//  @RequestParam(value = "page", required = false) Integer page,
//  @RequestParam(value = "sort", required = false) String sort

  /**
   *
   * @param params: Map
   * @return List<UserDTO>
   */
  @GetMapping(path = "/filter")
  public ResponseEntity<List<UserResDTO>> filterByParam(@RequestParam(required = false) Map<String, Object> params) {
    return ResponseEntity.ok(iUserService.filterByParam(params));
  }


  @PostMapping(path = "/login")
  public ResponseEntity<ResponseDTO> login(@RequestBody UserLoginDTO userLoginDTO) {
    logger.info("User login");
    System.out.println(userLoginDTO.getUserName());
    System.out.println(userLoginDTO.getPassword());
    iUserService.login(userLoginDTO);
    return null;
  }

  @PostMapping(path = "/register")
  public ResponseEntity<ResponseDTO> register(@RequestBody UserRegisterDTO userRegisterDTO) {
    iUserService.register(userRegisterDTO);
    return null;
  }

  @PostMapping(path = "")
  public ResponseEntity<List<UserResDTO>> getAll(@RequestParam UserResDTO userDTO) {
    return null;
  }

  @PatchMapping(path = "/update/{id}")
  public ResponseEntity<ResponseDTO> update(@PathVariable(name = "id") Long id,
                                            @RequestBody UserUpdateDTO userUpdateDTO,
                                            HttpServletRequest request) {
    logger.info("updateUser: {}", id);
    return ResponseEntity.ok(iUserService.updateUser(id, userUpdateDTO, request));
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<ResponseDTO> deleteUser(@PathVariable(value = "id") Long id,
                                                HttpServletRequest request) {
    logger.info("deleteUser: {}", id);
    return ResponseEntity.ok(iUserService.deleteUser(id, request));
  }
}


