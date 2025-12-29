package com.onclass.reporte.infrastructure.adapters.persistence.repository;

import com.onclass.reporte.infrastructure.adapters.persistence.ReporteBootcampDocument;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Update;
import reactor.core.publisher.Mono;

public interface ReporteBootcampRepository extends ReactiveMongoRepository<ReporteBootcampDocument, String> {
    @Query("{ 'bootcampId': ?0 }")
    @Update("{ '$inc' : { 'cantidadPersonas': 1 } }")
    Mono<Void> incrementarPersonas(Long bootcampId);

    @Query(sort = "{ 'cantidadPersonas': -1 }")
    Mono<ReporteBootcampDocument> findTopByOrderByCantidadPersonasDesc();
}
