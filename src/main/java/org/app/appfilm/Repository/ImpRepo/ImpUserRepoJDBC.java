/**
package org.app.appfilm.Repository.ImpRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.app.appfilm.Repository.Entity.UserEntity;
import org.app.appfilm.Repository.IRepo.IUserRepository;
import org.springframework.stereotype.Component;

@Component(value = "impUserRepoJDBC")
public class ImpUserRepoJDBC implements IUserRepository {
  private final String url = "jdbc:mysql://localhost:3306/AppFilm";
  private final String userName = "root";
  private final String password = "Khongco2004@";

  @Override
  public UserEntity findAllById(int id) throws SQLException {
    UserEntity userEntity = new UserEntity();
    Connection connection = DriverManager.getConnection(url, userName, password);
    Statement statement = connection.createStatement();
    String sql = "select * from user \n"
        + "where userId = " + id;
    ResultSet res = statement.executeQuery(sql);
    while (res.next()) {
      userEntity.setUserId(id);
      userEntity.setUserName(res.getString("userName"));
      userEntity.setPassword(res.getString("password"));
      userEntity.setEmailAddress(res.getString("emailAddress"));
      userEntity.setUrlAvatarImage(res.getString("urlAvatarImage"));
      userEntity.setDateOfBirth(res.getDate("dateOfBirth"));
      userEntity.setCountry(res.getString("country"));

    }
    return userEntity;
  }

  public static void main(String[] args) {

  }
}
*/