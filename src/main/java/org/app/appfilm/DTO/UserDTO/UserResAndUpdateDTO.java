package org.app.appfilm.DTO.UserDTO;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public abstract class UserResAndUpdateDTO implements Serializable {
  private String userName;
  private String emailAddress;
  private String urlAvatarImage;
  private Date dateOfBirth;
  private String country;
}
