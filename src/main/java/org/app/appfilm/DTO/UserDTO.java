package org.app.appfilm.DTO;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  private String userName;
  private String password;
  private String email;
  private String urlAvatarImage;
  private Date dateOfBirth;
  private String country;

  private UserDTO(BuilderUserDTO builder) {
    userName = builder.userName;
    password = builder.password;
    email = builder.email;
    urlAvatarImage = builder.urlAvatarImage;
    dateOfBirth = builder.dateOfBirth;
    country = builder.country;
  }

  public static class BuilderUserDTO {
    private String userName;
    private String password;
    private String email;
    private String urlAvatarImage;
    private Date dateOfBirth;
    private String country;

    public BuilderUserDTO setUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public BuilderUserDTO setPassword(String password) {
      this.password = password;
      return this;
    }

    public BuilderUserDTO setEmail(String email) {
      this.email = email;
      return this;
    }

    public BuilderUserDTO setUrlAvatarImage(String urlAvatarImage) {
      this.urlAvatarImage = urlAvatarImage;
      return this;
    }

    public BuilderUserDTO setDateOfBirth(Date dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public BuilderUserDTO setCountry(String country) {
      this.country = country;
      return this;
    }

    public UserDTO build() {
      return new UserDTO(this);
    }
  }

  public static void main(String[] args) {

  }
}

