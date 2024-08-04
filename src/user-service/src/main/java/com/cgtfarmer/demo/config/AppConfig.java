package com.cgtfarmer.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@Slf4j
public class AppConfig {

  private final String activeProfile;

  @Autowired
  public AppConfig(@Value("${spring.profiles.active}") String activeProfile) {
    this.activeProfile = activeProfile;

    log.info("Creating application config for active profile {}", this.activeProfile);
  }
}
