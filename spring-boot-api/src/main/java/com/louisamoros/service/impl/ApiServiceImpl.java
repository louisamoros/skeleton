package com.louisamoros.service.impl;

import com.louisamoros.model.User;
import com.louisamoros.service.ApiService;
import org.springframework.stereotype.Service;

/**
 * Created by louis on 01/03/17.
 */
@Service
public class ApiServiceImpl implements ApiService {

  private static final String FIRST_NAME = "hello";
  private static final String LAST_NAME = "world";

  @Override
  public User getUser() {
    return User.builder()
        .firstName(FIRST_NAME)
        .lastName(LAST_NAME)
        .build();
  }

}
