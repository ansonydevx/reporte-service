package com.onclass.reporte.domain.spi;

import com.onclass.reporte.domain.model.ReporteBootcamp;
import reactor.core.publisher.Mono;

public interface ReportePersistencePort {
    Mono<Void> save(ReporteBootcamp reporte);
    Mono<Void> incrementarPersonas(Long bootcampId);

    Mono<ReporteBootcamp> obtenerBootcampMasExitoso();
}
