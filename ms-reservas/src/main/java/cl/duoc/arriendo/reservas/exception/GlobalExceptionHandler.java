package cl.duoc.arriendo.reservas.exception;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Map<String, Object>> nf(ResourceNotFoundException e) {
    return b(HttpStatus.NOT_FOUND, e.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> val(MethodArgumentNotValidException e) {
    Map<String, Object> m = new HashMap<>();
    m.put("timestamp", LocalDateTime.now());
    m.put("status", 400);
    Map<String, String> errors = new HashMap<>();
    e.getBindingResult()
        .getFieldErrors()
        .forEach(x -> errors.put(x.getField(), x.getDefaultMessage()));
    m.put("errors", errors);
    return ResponseEntity.badRequest().body(m);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Map<String, Object>> bad(IllegalArgumentException e) {
    return b(HttpStatus.BAD_REQUEST, e.getMessage());
  }

  private ResponseEntity<Map<String, Object>> b(HttpStatus s, String msg) {
    Map<String, Object> m = new HashMap<>();
    m.put("timestamp", LocalDateTime.now());
    m.put("status", s.value());
    m.put("message", msg);
    return ResponseEntity.status(s).body(m);
  }
}
