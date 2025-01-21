package com.tineo.reto.repository;

import com.tineo.reto.entity.MonedaModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends ReactiveCrudRepository<MonedaModel, Long> {
}
