package com.vpnbeast.emailservice.exception;

import com.vpnbeast.emailservice.model.enums.HttpFields;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GenericControllerAdvice extends ResponseEntityExceptionHandler {

    @NonNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  @NonNull WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(HttpFields.TIMESTAMP.getField(), LocalDateTime.now());
        body.put(HttpFields.HTTP_CODE.getField(), status.value());
        body.put(HttpFields.STATUS.getField(), false);
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        body.put(HttpFields.ERROR_MESSAGE.getField(), errors);
        return new ResponseEntity<>(body, headers, status);
    }

    @NonNull
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         @NonNull HttpHeaders headers,
                                                                         @NonNull HttpStatus status,
                                                                         @NonNull WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");
        Objects.requireNonNull(ex.getSupportedHttpMethods()).forEach(t -> builder.append(t).append(" "));
        body.put(HttpFields.ERRORS.getField(), builder.toString());
        body.put(HttpFields.MESSAGE.getField(), ex.getLocalizedMessage());
        body.put(HttpFields.TIMESTAMP.getField(), LocalDateTime.now());
        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getLocalizedMessage());
        body.put("error", "unknown error occured at the backend");
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}