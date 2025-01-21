package com.tineo.reto.repository;

import com.tineo.reto.entity.TransaccionModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends ReactiveCrudRepository<TransaccionModel, Long> {
}
