//package org.app.appfilm.Repository.ImpRepo;
//
//import jakarta.persistence.Query;
//import java.util.List;
//import org.app.appfilm.Config.HibernateConfig;
//import org.app.appfilm.Repository.Entity.UserEntity;
//import org.app.appfilm.Repository.IRepo.IUserRepository;
//import org.app.appfilm.Utils.InfoObject;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.stereotype.Component;
//
//@Component(value = "impUserRepoHibernate")
//public class ImpUserRepoHibernate implements IUserRepository {
//
//  @Override
//  public List<UserEntity> findAll() {
//    return List.of();
//  }
//
//  @Override
//  public List<UserEntity> findAll(Integer page, Integer pageSize) {
//    SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
//    Session session = sessionFactory.openSession();
//    Query query = session.createQuery("FROM UserEntity");
//    List userEntities = query.getResultList();
//    session.close();
//    return userEntities;
//  }
//
//  @Override
//  public UserEntity findAllById(Integer id) {
//    return null;
//  }
//
//  @Override
//  public boolean register(UserEntity userEntity) {
//    boolean res = false;
//    SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
//    Session session = sessionFactory.openSession();
//    Transaction transaction = null;
//    try {
//      transaction = session.beginTransaction();
//      session.save(userEntity);
//      transaction.commit();
//      res = true;
//    } catch (Exception e) {
//      if (transaction != null) {
//        transaction.rollback();
//      }
//    }
//    session.close();
//    return res;
//  }
//}
