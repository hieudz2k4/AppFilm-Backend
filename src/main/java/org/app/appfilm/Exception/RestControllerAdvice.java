package org.app.appfilm.Exception;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.app.appfilm.DTO.ErrResDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrResDTO> handleCustomException(CustomException e, HttpServletRequest httpServletRequest) {
    int statusCode = HttpStatus.NOT_FOUND.value();
    String path = httpServletRequest.getRequestURI();
    String errMsg = e.getMessage();
    List<String> errDetail = null;
    ErrResDTO errResDTO = new ErrResDTO();
    return new ResponseEntity<>(errResDTO, HttpStatus.NOT_FOUND);
  }
}
