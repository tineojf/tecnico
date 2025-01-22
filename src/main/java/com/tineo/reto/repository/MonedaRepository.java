package com.tineo.reto.repository;

import com.tineo.reto.entity.MonedaModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MonedaRepository extends ReactiveCrudRepository<MonedaModel, Long> {
    Mono<MonedaModel> findByCodigo(String codigo);
}
