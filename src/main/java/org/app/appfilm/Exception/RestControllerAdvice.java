package org.app.appfilm.Exception;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import org.app.appfilm.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorDTO> handleCustomException(CustomException e, HttpServletRequest httpServletRequest) {
    int statusCode = HttpStatus.NOT_FOUND.value();
    String path = httpServletRequest.getRequestURI();
    String errMsg = e.getMessage();
    List<String> errDetail = null;
    ErrorDTO errorDTO = new ErrorDTO(statusCode, path, errMsg, errDetail);
    return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
  }
}
