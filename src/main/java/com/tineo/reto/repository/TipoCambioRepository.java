package com.tineo.reto.repository;

import com.tineo.reto.entity.TipoCambioModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TipoCambioRepository extends ReactiveCrudRepository<TipoCambioModel, Long> {
    Mono<TipoCambioModel> findByMonedaOrigenIdAndMonedaDestinoId(Long monedaOrigenId, Long monedaDestinoId);
}
