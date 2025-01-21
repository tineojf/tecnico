package com.tineo.reto.service;

import com.tineo.reto.entity.TransaccionModel;
import com.tineo.reto.repository.TransaccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;

    public Flux<TransaccionModel> findAll() {
        return transaccionRepository.findAll();
    }

    public Mono<TransaccionModel> findById(Long id) {
        return transaccionRepository.findById(id);
    }
}
