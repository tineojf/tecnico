package com.tineo.reto.service;

import com.tineo.reto.dto.transaccion.TransaccionRequestDTO;
import com.tineo.reto.dto.transaccion.TransaccionResponseDTO;
import com.tineo.reto.entity.MonedaModel;
import com.tineo.reto.entity.TransaccionModel;
import com.tineo.reto.mapper.TransaccionMapper;
import com.tineo.reto.repository.TransaccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final Monedaservice monedaService;
    private final TipoCambioService tipoCambioService;
    private final TransaccionMapper transaccionMapper;

    public Flux<TransaccionModel> findAll() {
        return transaccionRepository.findAll();
    }

    public Mono<TransaccionModel> findById(Long id) {
        return transaccionRepository.findById(id);
    }

    public Mono<TransaccionResponseDTO> save(TransaccionRequestDTO transaccion) {
        Mono<MonedaModel> monedaOrigen = monedaService.findByCodigo(transaccion.getMonedaOrigen());
        Mono<MonedaModel> monedaDestino = monedaService.findByCodigo(transaccion.getMonedaDestino());

        return monedaOrigen.zipWith(monedaDestino)
                .flatMap(tuple -> {
                    MonedaModel origen = tuple.getT1();
                    MonedaModel destino = tuple.getT2();
                    String monedaDestinoCodigo = destino.getCodigo();

                    return tipoCambioService.findMoneda(origen, destino, String.valueOf(transaccion.getTipoTransaccion()))
                            .flatMap(tipoCambio -> {
                                BigDecimal montoOrigenBD = BigDecimal.valueOf(transaccion.getMontoOrigen());
                                BigDecimal montoDestino = montoOrigenBD.multiply(tipoCambio);

                                Double montoDestinoDouble = montoDestino.doubleValue();


                                TransaccionModel transaccionModel = TransaccionModel.builder()
                                        .tipoTransaccion(transaccion.getTipoTransaccion())
                                        .montoOrigen(transaccion.getMontoOrigen())
                                        .monedaOrigenId(origen.getMonedaId())
                                        .monedaDestinoId(destino.getMonedaId())
                                        .montoDestino(montoDestinoDouble)
                                        .tipoCambio(tipoCambio)
                                        .build();

                                return transaccionRepository.save(transaccionModel)
                                        .map(savedTransaccion -> TransaccionResponseDTO.builder()
                                                .montoDestino(savedTransaccion.getMontoDestino())
                                                .monedaDestino(monedaDestinoCodigo)
                                                .tipoTransaccion(savedTransaccion.getTipoTransaccion())
                                                .build());
                            });
                });
    }

}
