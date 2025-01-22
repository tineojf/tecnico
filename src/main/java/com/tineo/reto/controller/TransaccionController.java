package com.tineo.reto.controller;

import com.tineo.reto.config.Constant;
import com.tineo.reto.dto.global.GlobalResponse;
import com.tineo.reto.dto.transaccion.TransaccionRequestDTO;
import com.tineo.reto.service.TransaccionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping(Constant.TRANSACCION)
@RequiredArgsConstructor
public class TransaccionController {

    private final TransaccionService transaccionService;

    @PostMapping
    public Mono<ResponseEntity<GlobalResponse>> save(@RequestBody @Valid TransaccionRequestDTO transaccionRequestDTO) {
        return transaccionService.save(transaccionRequestDTO)
                .map(transaccion -> {
                    GlobalResponse response = GlobalResponse.builder()
                            .ok(true)
                            .message(Constant.TRANSACCION_CREATED)
                            .data(transaccion)
                            .timestamp(LocalDateTime.now())
                            .build();
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                });
    }
}
