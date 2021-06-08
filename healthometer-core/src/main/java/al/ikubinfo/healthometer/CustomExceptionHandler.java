package al.ikubinfo.healthometer;

import al.ikubinfo.commons.entity.ErrorFormat;
import java.util.HashMap;
import java.util.Map;

import al.ikubinfo.commons.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Component
@RestControllerAdvice
public class CustomExceptionHandler {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            (error) -> {
              String fieldName = ((FieldError) error).getField();
              String errorMessage = error.getDefaultMessage();
              errors.put(fieldName, errorMessage);
              errors.put("error", "Validation Error");
            });
    return errors;
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(
      value = {
        WarningEx.class,
        BadRequestEx.class,
        NotFoundEx.class,
        DatabaseEx.class,
        NotAuthorizedEx.class,
        NotImplementedEx.class,
        Exception.class
      })
  protected ResponseEntity<Object> handleCustomExceptions(RuntimeException ex, WebRequest request) {
    ErrorFormat errorBody = new ErrorFormat();
    errorBody.setMessage(ex.getMessage());
    errorBody.setException(ex.getClass().getSimpleName());
    return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
  }
}
