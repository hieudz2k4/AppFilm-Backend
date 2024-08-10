package org.app.appfilm.Controller;

import java.util.List;
import java.util.Map;
import org.app.appfilm.DTO.ResponseDTO;
import org.app.appfilm.DTO.UserDTO;
import org.app.appfilm.Service.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
  @Autowired
  @Qualifier(value = "userService")
  private IUserService iUserService;

  @GetMapping(path = "")
  public ResponseEntity<List<UserDTO>> getAll(@RequestParam(value = "page", required = false) Integer page) {
    return null;
  }

  @GetMapping(path = "/{id}")
  public UserDTO getUserById(@PathVariable(value = "id") int id) {
    return iUserService.getUserById(id);
  }

//  @RequestParam(value = "userName", required = false) String userName,
//  @RequestParam(value = "email", required = false) String email,
//  @RequestParam(value = "dateOfBirth", required = false) Date dateOfBirth,
//  @RequestParam(value = "country", required = false) String country,
//  @RequestParam(value = "page", required = false) Integer page,
//  @RequestParam(value = "sort", required = false) String sort

  @GetMapping(path = "/filter")
  public ResponseEntity<List<UserDTO>> filterByParam(@RequestParam(required = false) Map<String, Object> params) {
    return null;
  }

  @PostMapping(path = "/login")
  public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO userDTO) {
    System.out.println(userDTO.getUserName().getClass().getName());
    System.out.println(userDTO.getPassword().getClass().getName());
    return null;
  }

  @PostMapping(path = "/register")
  public ResponseEntity<ResponseDTO> register(@RequestBody UserDTO userDTO) {
    return null;
  }

  @PostMapping(path = "")
  public ResponseEntity<List<UserDTO>> getAll(@RequestParam UserDTO userDTO,
                                              @RequestParam Map<String, Object> params) {
    return null;
  }

  @PatchMapping(path = "/update")
  public ResponseEntity<ResponseDTO> update(@RequestBody UserDTO userDTO) {
    return null;
  }

  @DeleteMapping(path = "/delete")
  public ResponseEntity<ResponseDTO> deleteUser(@PathVariable(value = "id") int id) {
    System.out.println("delete userId: " + id);
    return null;
  }
}


