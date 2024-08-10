package org.app.appfilm.Repository.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userId")
  private Integer userId;

  @Column(name = "userName")
  private String userName;

  @Column(name = "password")
  private String password;

  @Column(name = "emailAddress")
  private String emailAddress;

  @Column(name = "urlImageEmail")
  private String urlImageEmail;

  @Column(name = "managerUserId")
  private int manageUserId;

  @Column(name = "urlAvatarImage")
  private String urlAvatarImage;

  @Column(name = "dateOfBirth")
  private Date dateOfBirth;

  @Column(name = "country")
  private String country;
}
