package org.app.appfilm.Repository.ImpRepo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.app.appfilm.Config.HibernateConfig;
import org.app.appfilm.Constant.MySQLConstant;
import org.app.appfilm.DTO.ResponseDTO;
import org.app.appfilm.Repository.Entity.UserEntity;
import org.app.appfilm.Repository.IRepo.IUserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "impUserRepo")
public class ImpUserRepo implements IUserRepository {
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
    }
    return userEntity;
  }

  public static void main(String[] args) {

  }
}
