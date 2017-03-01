package com.louisamoros.webservice.handler;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by louis on 01/03/17.
 */
@ControllerAdvice
public class ApiExceptionHandler {

  /**
   * Generates a Response entity with HTTP error infos.
   *
   * @param status       the HTTP progress
   * @param errorMessage detail of handled exception
   * @return ResponseEntity
   */
  private static ResponseEntity generateError(HttpStatus status, String errorMessage) {
    HttpHeaders headers = new HttpHeaders();
    ResponseMessage resp = new ResponseMessage(status.value(), errorMessage);
    return new ResponseEntity<>(resp, headers, status);
  }

  /**
   * Handle illegal state exception.
   *
   * @param ex the exception
   * @return the response entity
   */
  @ResponseBody
  @ExceptionHandler(IllegalStateException.class)
  public ResponseEntity handleIllegalState(IllegalStateException ex) {
    return generateError(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  /**
   * Handle illegal argument exception.
   *
   * @param ex the exception
   * @return the response entity
   */
  @ResponseBody
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity handleInvalidArgument(IllegalArgumentException ex) {
    return generateError(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  /**
   * Handle resource not found exception.
   *
   * @param ex the exception
   * @return the response entity
   */
  @ResponseBody
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity handleResourceNotFound(ResourceNotFoundException ex) {
    return generateError(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  private static class ResponseMessage {

    private int statusCode;
    private String message;
    private Object result;

    public int getStatusCode() {
      return statusCode;
    }

    public void setStatusCode(int statusCode) {
      this.statusCode = statusCode;
    }

    public Object getResult() {
      return result;
    }

    public void setResult(Object result) {
      this.result = result;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    /**
     * Constructs a response message without payload.
     *
     * @param statusCode the progress code of the message (HttpStatus)
     * @param message    the message
     */
    ResponseMessage(int statusCode, String message) {
      this.statusCode = statusCode;
      this.message = message;
    }

    /**
     * Constructs a response message with payload.
     *
     * @param statusCode the progress code of the message (HttpStatus)
     * @param message    the message
     * @param result     the payload object (should be Serializable somehow)
     */
    ResponseMessage(int statusCode, String message, Object result) {
      this.statusCode = statusCode;
      this.message = message;
      this.result = result;
    }

  }

}