package org.app.appfilm.DTO.UserDTO.Req;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDTO implements Serializable {
  private String userName;
  private String password;
  private String emailAddress;
}
