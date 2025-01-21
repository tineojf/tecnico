package com.tineo.reto.service;

import com.tineo.reto.config.Constant;
import com.tineo.reto.entity.MonedaModel;
import com.tineo.reto.exception.ResourceNotFoundException;
import com.tineo.reto.repository.MonedaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class Monedaservice {
    private final MonedaRepository monedaRepository;

    public Mono<MonedaModel> findById(Long id) {
        return monedaRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(Constant.MONEDA_NOT_FOUND + id)));
    }
}
