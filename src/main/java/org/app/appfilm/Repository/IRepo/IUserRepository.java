package org.app.appfilm.Repository.IRepo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.app.appfilm.DTO.ResponseDTO;
import org.app.appfilm.Repository.Entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
  Page<UserEntity> findAll(Pageable pageable);
  Optional<UserEntity> findByUserId(Long Id);
  List<UserEntity> findByCountry(String country, Pageable pageable);
}
