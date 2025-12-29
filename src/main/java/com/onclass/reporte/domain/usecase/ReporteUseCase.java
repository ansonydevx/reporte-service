package com.onclass.reporte.domain.usecase;

import com.onclass.reporte.domain.api.ReporteServicePort;
import com.onclass.reporte.domain.model.ReporteBootcamp;
import com.onclass.reporte.domain.spi.ReportePersistencePort;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.*;

@Slf4j
public class ReporteUseCase implements ReporteServicePort {

    private final ReportePersistencePort persistencePort;

    public ReporteUseCase(ReportePersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }


    @Override
    public Mono<Void> registrar(ReporteBootcamp reporte) {
        return persistencePort.save(reporte);
    }

    @Override
    public Mono<Void> incrementarPersonas(Long bootcampId) {
        return persistencePort.incrementarPersonas(bootcampId);
    }

    @Override
    public Mono<ReporteBootcamp> obtenerBootcampMasExitoso() {
        return persistencePort.obtenerBootcampMasExitoso();
    }
}
