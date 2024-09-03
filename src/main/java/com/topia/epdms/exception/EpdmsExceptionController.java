package com.topia.epdms.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@Slf4j
public class EpdmsExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException ex, WebRequest webRequest) {
        log.error("Processing request (NotFoundException)", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorResponse
                        .builder()
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .description(webRequest.getDescription(false))
                        .timestamp(new Date())
                        .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> badRequestException(BadRequestException ex, WebRequest webRequest) {
        log.error("Processing request (BadRequestException)", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorResponse
                        .builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage())
                        .description(webRequest.getDescription(false))
                        .timestamp(new Date())
                        .build());
    }

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<ErrorResponse> timeoutException(TimeoutException ex, WebRequest webRequest) {
        log.error("Processing request (TimeoutException)", ex);
        return ResponseEntity
                .status(HttpStatus.REQUEST_TIMEOUT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ErrorResponse
                        .builder()
                        .statusCode(HttpStatus.REQUEST_TIMEOUT.value())
                        .message(ex.getMessage())
                        .description(webRequest.getDescription(false))
                        .timestamp(new Date())
                        .build());
    }
}
