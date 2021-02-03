package net.luvina.registration.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class RestExceptionHandler {

  public ResponseEntity<ApiError> handlerServiceRuntimeException(ServiceRuntimeException ex) {
    ApiError apiError = new ApiError(ex.getErrorCode(), ex.getMessage());
    return new ResponseEntity<>(apiError, ex.getHttpStatus());
  }

}
