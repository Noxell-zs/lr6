package ru.sfu.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/** Non-web infrastructure configuration */
@Configuration
@ComponentScan("ru.sfu.controller")
@PropertySource("classpath:application.properties")
public class AppConfig {
  @Autowired
  private Environment env;

  /** @return Object to connect to the data source */
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(env.getProperty("dataSource.url"));
    return dataSource;
  }
}
