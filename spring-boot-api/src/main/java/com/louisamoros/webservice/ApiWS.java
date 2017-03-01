package com.louisamoros.webservice;

import com.louisamoros.model.User;
import com.louisamoros.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by louis on 01/03/17.
 */
@RestController
public class ApiWS {

  @Autowired
  private ApiService apiService;

  @RequestMapping(method = RequestMethod.GET, path = "/", produces = {"application/json"})
  public ResponseEntity<User> getUser() {
    return ResponseEntity.ok(apiService.getUser());
  }

}
