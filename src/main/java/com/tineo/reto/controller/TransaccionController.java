package com.tineo.reto.controller;

import com.tineo.reto.config.Constant;
import com.tineo.reto.dto.global.GlobalResponse;
import com.tineo.reto.dto.transaccion.TransaccionRequestDTO;
import com.tineo.reto.service.TransaccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Obtener todas las transacciones", description = "Este endpoint devuelve todas las transacciones almacenadas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transacciones encontradas"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public Mono<ResponseEntity<GlobalResponse>> findAll() {
        return transaccionService.findAll()
                .collectList()
                .map(transacciones -> {
                    GlobalResponse response = GlobalResponse.builder()
                            .ok(true)
                            .message(Constant.TRANSACCION_FOUND)
                            .data(transacciones)
                            .timestamp(LocalDateTime.now())
                            .build();
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                });
    }

    @Operation(
            summary = "Obtener una transacción por ID",
            description = "Este endpoint devuelve una transacción específica por su ID.",
            parameters = {
                    @Parameter(name = "id", description = "ID de la transacción a buscar", example = "1")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transacción encontrada"),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public Mono<ResponseEntity<GlobalResponse>> findById(
            @Parameter(description = "ID de la transacción a buscar", example = "1")
            @PathVariable Long id) {
        return transaccionService.findById(id)
                .map(transaccion -> {
                    GlobalResponse response = GlobalResponse.builder()
                            .ok(true)
                            .message(Constant.TRANSACCION_FOUND)
                            .data(transaccion)
                            .timestamp(LocalDateTime.now())
                            .build();
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                });
    }

    @Operation(
            summary = "Crear una nueva transacción",
            description = "Este endpoint permite crear una nueva transacción.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Cuerpo de la solicitud con los datos de la transacción",
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            mediaType = "application/json",
                            examples = @io.swagger.v3.oas.annotations.media.ExampleObject(
                                    name = "Ejemplo de transacción",
                                    value = "{ \"monedaOrigen\": \"USD\", \"monedaDestino\": \"PEN\", \"montoOrigen\": 100.0, \"tipoTransaccion\": \"COMPRA\" }"
                            )
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transacción creada"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
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
                    return ResponseEntity.status(HttpStatus.CREATED).body(response);
                });
    }
}
