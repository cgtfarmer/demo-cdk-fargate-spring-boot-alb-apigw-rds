package com.cgtfarmer.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DbSecret {

  private String password;

  private String dbname;

  private String engine;

  private String port;

  private String dbInstanceIdentifier;

  private String host;

  private String username;
}
