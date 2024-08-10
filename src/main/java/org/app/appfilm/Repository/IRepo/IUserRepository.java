package org.app.appfilm.Repository.IRepo;

import java.sql.SQLException;
import java.util.List;
import org.app.appfilm.DTO.ResponseDTO;
import org.app.appfilm.Repository.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository {
  UserEntity findAllById(int id) throws SQLException;
}
