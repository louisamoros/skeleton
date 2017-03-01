package com.louisamoros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by louis on 01/03/17.
 */
@SpringBootApplication
public class ApiConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApiConfig.class);

  /**
   * Constructor.
   */
  public ApiConfig() {
    LOGGER.trace("Configuration: ApiConfig");
  }

  /**
   * Where magic happens.
   *
   * @param args the main args
   */
  public static void main(String... args) {
    SpringApplication.run(ApiConfig.class, args);
  }

}
