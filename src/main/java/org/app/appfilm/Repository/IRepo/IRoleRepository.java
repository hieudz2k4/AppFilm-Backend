package org.app.appfilm.Repository.IRepo;

import org.app.appfilm.Repository.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

}
