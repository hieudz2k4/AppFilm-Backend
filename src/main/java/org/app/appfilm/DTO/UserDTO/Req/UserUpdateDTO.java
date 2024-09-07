package org.app.appfilm.DTO.UserDTO.Req;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.appfilm.DTO.UserDTO.UserResAndUpdateDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO extends UserResAndUpdateDTO implements Serializable {
  private String password;

  @Builder
  public UserUpdateDTO(String userName, String emailAddress, String urlAvatarImage,
                       Date dateOfBirth, String country, String password) {
    super(userName, emailAddress, urlAvatarImage, dateOfBirth, country);
    this.password = password;
  }
}
