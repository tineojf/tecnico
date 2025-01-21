package com.tineo.reto.dto.global;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class GlobalResponse {
    private Boolean ok;
    private String message;
    private Object data;
    private LocalDateTime timestamp;
    private String details;
}
