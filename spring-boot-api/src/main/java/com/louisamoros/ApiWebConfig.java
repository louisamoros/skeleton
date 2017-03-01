package com.louisamoros;

import com.louisamoros.webservice.security.CorsInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by louis on 01/03/17.
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.louisamoros")
@Import(ApiConfig.class)
public class ApiWebConfig extends WebMvcConfigurerAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApiWebConfig.class);

  /**
   * Constructor.
   */
  public ApiWebConfig() {
    LOGGER.trace("Configuration: ApiWebConfig");
  }

  /**
   * CORS Interceptor.
   *
   * @return the cors interceptor
   */
  @Bean
  public CorsInterceptor corsInterceptor() {
    return new CorsInterceptor();
  }

  /**
   * Add interceptor.
   *
   * @param registry the interceptor registry
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(corsInterceptor());
  }

}
