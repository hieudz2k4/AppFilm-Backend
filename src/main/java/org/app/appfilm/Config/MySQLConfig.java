package org.app.appfilm.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "application.properties")
public class MySQLConfig {
  @Value("${spring.datasource.url}")
  static String URL;

  @Value("${spring.datasource.username}")
  static String USERNAME;

  @Value("${spring.datasource.password}")
  static String PASSWORD;

  @Value("${spring.datasource.driver-class-name}")
  static String DRIVER;

  @Value("${spring.jpa.properties.hibernate.dialectl}")
  static String HIBERNATEIALECT;
}
