package com.onclass.reporte.domain.api;

import com.onclass.reporte.domain.model.ReporteBootcamp;
import reactor.core.publisher.Mono;

public interface ReporteServicePort {
    Mono<Void> registrar(ReporteBootcamp reporte);
    Mono<Void> incrementarPersonas(Long bootcampId);

    Mono<ReporteBootcamp> obtenerBootcampMasExitoso();
}
