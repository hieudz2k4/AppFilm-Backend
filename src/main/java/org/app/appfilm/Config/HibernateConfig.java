package org.app.appfilm.Config;

import java.util.Properties;
import org.app.appfilm.Repository.Entity.RoleEntity;
import org.app.appfilm.Repository.Entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


@EnableTransactionManagement
public class HibernateConfig {
  private static final SessionFactory sessionFactory;
  static {
    try {
      Configuration configuration = new Configuration();

        // Cấu hình các thuộc tính của Hibernate
      Properties settings = new Properties();
      settings.put(Environment.DRIVER, MySQLConfig.DRIVER);
      settings.put(Environment.URL, MySQLConfig.URL);
      settings.put(Environment.USER, MySQLConfig.USERNAME);
      settings.put(Environment.PASS, MySQLConfig.PASSWORD);
      settings.put(Environment.DIALECT, MySQLConfig.HIBERNATEIALECT);
      settings.put(Environment.SHOW_SQL, "true");
      settings.put(Environment.HBM2DDL_AUTO, "update");

      configuration.setProperties(settings);

        // Cấu hình entity classes
      configuration.addAnnotatedClass(UserEntity.class);
      configuration.addAnnotatedClass(RoleEntity.class);

      sessionFactory = configuration.buildSessionFactory();
    } catch (Throwable ex) {
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

}
