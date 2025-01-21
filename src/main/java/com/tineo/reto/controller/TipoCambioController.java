package com.tineo.reto.controller;

import com.tineo.reto.config.Constant;
import com.tineo.reto.dto.global.GlobalResponse;
import com.tineo.reto.service.TipoCambioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping(Constant.TIPO_CAMBIO)
@RequiredArgsConstructor
public class TipoCambioController {
    private final TipoCambioService tipoCambioService;

    @GetMapping
    public Mono<ResponseEntity<GlobalResponse>> findAll() {
        return tipoCambioService.findAll()
                .collectList()
                .map(tipoCambios -> {
                    GlobalResponse response = GlobalResponse.builder()
                            .ok(true)
                            .message(Constant.TIPO_CAMBIO_FOUND)
                            .data(tipoCambios)
                            .timestamp(LocalDateTime.now())
                            .build();
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                });
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<GlobalResponse>> findById(@PathVariable Long id) {
        return tipoCambioService.findById(id)
                .map(tipoCambio -> {
                    GlobalResponse response = GlobalResponse.builder()
                            .ok(true)
                            .message(Constant.TIPO_CAMBIO_FOUND)
                            .data(tipoCambio)
                            .timestamp(LocalDateTime.now())
                            .build();
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                });
    }
}
