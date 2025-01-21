package com.tineo.reto.service;

import com.tineo.reto.config.Constant;
import com.tineo.reto.dto.tipocambio.TipoCambioResponseDTO;
import com.tineo.reto.entity.MonedaModel;
import com.tineo.reto.exception.ResourceNotFoundException;
import com.tineo.reto.mapper.TipoCambioMapper;
import com.tineo.reto.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TipoCambioService {

    private final TipoCambioRepository tipoCambioRepository;
    private final TipoCambioMapper tipoCambioMapper;
    private final Monedaservice monedaservice;

    public Flux<TipoCambioResponseDTO> findAll() {
        return tipoCambioRepository.findAll()
                .flatMap(tipoCambio -> {
                    Mono<MonedaModel> monedaOrigen = monedaservice.findById(tipoCambio.getMonedaOrigenId());
                    Mono<MonedaModel> monedaDestino = monedaservice.findById(tipoCambio.getMonedaDestinoId());

                    return monedaOrigen.zipWith(monedaDestino, (origen, destino) ->
                            tipoCambioMapper.toDTO(tipoCambio, origen, destino)
                    );
                });
    }

    public Mono<TipoCambioResponseDTO> findById(Long id) {
        return tipoCambioRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(Constant.TIPO_CAMBIO_NOT_FOUND + id)))
                .flatMap(tipoCambio -> {
                    Mono<MonedaModel> monedaOrigen = monedaservice.findById(tipoCambio.getMonedaOrigenId());
                    Mono<MonedaModel> monedaDestino = monedaservice.findById(tipoCambio.getMonedaDestinoId());

                    return monedaOrigen.zipWith(monedaDestino, (origen, destino) ->
                            tipoCambioMapper.toDTO(tipoCambio, origen, destino)
                    );
                });
    }
}
