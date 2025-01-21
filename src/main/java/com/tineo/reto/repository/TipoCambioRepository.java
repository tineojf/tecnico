package com.tineo.reto.repository;

import com.tineo.reto.entity.TipoCambioModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends ReactiveCrudRepository<TipoCambioModel, Long> {
}
