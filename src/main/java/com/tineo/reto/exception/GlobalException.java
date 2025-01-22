package com.tineo.reto.exception;

import com.tineo.reto.config.Constant;
import com.tineo.reto.dto.global.GlobalResponse;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<GlobalResponse> handleTypeMismatchException(MethodArgumentTypeMismatchException ex, ServerWebExchange exchange) {
        String parameterName = ex.getName();
        String expectedType = ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "desconocido";
        String message = String.format(Constant.GLOBAL_EXCEPTION_ERROR_PARAMETER_TYPE, parameterName, expectedType);

        GlobalResponse response = createErrorResponse(ex, exchange);
        response.setMessage(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<GlobalResponse> handleValidationException(WebExchangeBindException ex, ServerWebExchange exchange) {
        String message = ex.getFieldErrors().stream()
                .map(error -> String.format("Campo '%s': %s", error.getField(), error.getDefaultMessage()))
                .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                .orElse("Error de validación");

        GlobalResponse response = createErrorResponse(ex, exchange);
        response.setMessage(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DecodingException.class)
    public ResponseEntity<GlobalResponse> handleDecodingException(DecodingException ex, ServerWebExchange exchange) {
        String message = "Error de formato en los datos enviados. Por favor, verifica los valores proporcionados.";

        GlobalResponse response = createErrorResponse(ex, exchange);
        response.setMessage(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
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
