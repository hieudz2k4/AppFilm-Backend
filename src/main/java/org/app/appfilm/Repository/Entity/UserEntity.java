package org.app.appfilm.Repository.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long userId;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "password")
  private String password;

  @Column(name = "email_address")
  private String emailAddress;

  @Column(name = "url_email_image")
  private String urlImageEmail;

  @Column(name = "manager_user_id")
  private Integer manageUserId;

  @Column(name = "url_avatar_image")
  private String urlAvatarImage;

  @Column(name = "date_of_birth")
  @Temporal(value = TemporalType.DATE)// chỉ nhận ngày tháng năm
  private Date dateOfBirth;

  @Column(name = "country")
  private String country;

  // auditing

}
