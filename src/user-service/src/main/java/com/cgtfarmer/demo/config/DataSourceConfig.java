package com.cgtfarmer.demo.config;

import com.cgtfarmer.demo.dto.DbSecret;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({ "deployed" })
public class DataSourceConfig {

  @Autowired
  public DataSourceConfig() {
  }

  @Bean
  public DataSource devDataSource(
      @Value("${spring.datasource.url}") final String dataSourceUrl,
      @Value("${spring.datasource.driverclassname}") final String driverClassName,
      @Value("${db.secret}") final DbSecret dbSecret
  ) {
    HikariDataSource dataSource = new HikariDataSource();

    dataSource.setJdbcUrl(dataSourceUrl);

    dataSource.setDriverClassName(driverClassName);

    dataSource.setUsername(dbSecret.getUsername());

    dataSource.setPassword(dbSecret.getPassword());

    return dataSource;
  }
}
