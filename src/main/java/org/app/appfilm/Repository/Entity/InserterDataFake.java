package org.app.appfilm.Repository.Entity;

import org.app.appfilm.Config.HibernateConfig;
import org.app.appfilm.Constant.RoleConstant;
import org.app.appfilm.Repository.IRepo.IRoleRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InserterDataFake {
  @Autowired
  private static IRoleRepository iRoleRepository;
  private static RoleEntity createRoleEntity(Long id, RoleConstant roleConstant) {
    return RoleEntity
        .builder()
        .id(id)
        .roleName(roleConstant)
        .build();
  }
  public static void saveRoleEntity() {
    for (RoleConstant roleConstant : RoleConstant.values()) {
      RoleEntity roleEntity = createRoleEntity(Long.valueOf(roleConstant.getValue()), roleConstant);
      iRoleRepository.save(roleEntity);
    }
  }
}
