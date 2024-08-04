package com.cgtfarmer.demo.config;

import com.cgtfarmer.demo.dto.DbSecret;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

  private final ObjectMapper objectMapper;

  @Autowired
  public DataSourceConfig(ObjectMapper objectMapper) {
    this.objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.registerModule(new JavaTimeModule());
  }

  @Bean
  public DataSource devDataSource(
      @Value("${spring.datasource.url}") final String dataSourceUrl,
      @Value("${spring.datasource.driverclassname}") final String driverClassName,
      @Value("${db.secret}") final String dbSecretString
  ) throws JsonMappingException, JsonProcessingException {
    HikariDataSource dataSource = new HikariDataSource();

    dataSource.setJdbcUrl(dataSourceUrl);

    dataSource.setDriverClassName(driverClassName);

    DbSecret dbSecret = this.objectMapper.readValue(
        dbSecretString,
        DbSecret.class
    );

    dataSource.setUsername(dbSecret.getUsername());

    dataSource.setPassword(dbSecret.getPassword());

    return dataSource;
  }
}
