package com.tineo.reto.controller;

import com.tineo.reto.config.Constant;
import com.tineo.reto.dto.global.GlobalResponse;
import com.tineo.reto.service.TipoCambioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    /**
     * Obtiene todos los tipos de cambio.
     *
     * @return Lista de tipos de cambio.
     */
    @Operation(
            summary = "Obtener todos los tipos de cambio",
            description = "Este endpoint devuelve todos los tipos de cambio disponibles en el sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipos de cambio encontrados"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
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

    /**
     * Obtiene un tipo de cambio por su ID.
     *
     * @param id El ID del tipo de cambio a buscar.
     * @return El tipo de cambio encontrado.
     */
    @Operation(
            summary = "Obtener tipo de cambio por ID",
            description = "Este endpoint devuelve un tipo de cambio específico, basado en el ID proporcionado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de cambio encontrado"),
            @ApiResponse(responseCode = "404", description = "Tipo de cambio no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public Mono<ResponseEntity<GlobalResponse>> findById(
            @Parameter(description = "ID del tipo de cambio a buscar", example = "1")
            @PathVariable Long id) {
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
