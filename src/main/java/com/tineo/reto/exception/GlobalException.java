package com.tineo.reto.exception;

import com.tineo.reto.config.Constant;
import com.tineo.reto.dto.global.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GlobalResponse> handleBadRequestException(BadRequestException ex, ServerWebExchange exchange) {
        GlobalResponse response = createErrorResponse(ex, exchange);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(EntityAlreadeExistsException.class)
    public ResponseEntity<GlobalResponse> handleEntityAlreadeExistsException(EntityAlreadeExistsException ex, ServerWebExchange exchange) {
        GlobalResponse response = createErrorResponse(ex, exchange);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GlobalResponse> handleResourceNotFoundException(ResourceNotFoundException ex, ServerWebExchange exchange) {
        GlobalResponse response = createErrorResponse(ex, exchange);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalResponse> handleException(Exception ex, ServerWebExchange exchange) {
        GlobalResponse response = createErrorResponse(ex, exchange);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    // private methods
    private GlobalResponse createErrorResponse(Exception ex, ServerWebExchange exchange) {
        return GlobalResponse.builder()
                .ok(false)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .details(String.format(Constant.GLOBAL_EXCEPTION_ERROR_DETAILS, exchange.getRequest().getMethod(), exchange.getRequest().getURI()))
                .build();
    }
}
