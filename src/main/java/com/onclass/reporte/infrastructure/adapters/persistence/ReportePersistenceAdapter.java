package com.onclass.reporte.infrastructure.adapters.persistence;

import com.onclass.reporte.domain.model.ReporteBootcamp;
import com.onclass.reporte.domain.spi.ReportePersistencePort;
import com.onclass.reporte.infrastructure.adapters.persistence.repository.ReporteBootcampRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class ReportePersistenceAdapter implements ReportePersistencePort {

    private final ReporteBootcampRepository repository;

    @Override
    public Mono<Void> save(ReporteBootcamp reporte) {
        return repository.save(
                new ReporteBootcampDocument(
                        null,
                        reporte.bootcampId(),
                        reporte.nombre(),
                        reporte.descripcion(),
                        reporte.fechaLanzamiento(),
                        reporte.duracion(),
                        reporte.cantidadCapacidades(),
                        reporte.cantidadTecnologias(),
                        reporte.cantidadPersonas()
                ))
                .then();
    }

    @Override
    public Mono<Void> incrementarPersonas(Long bootcampId) {
        return repository.incrementarPersonas(bootcampId);
    }

    @Override
    public Mono<ReporteBootcamp> obtenerBootcampMasExitoso() {
        return repository.findTopByOrderByCantidadPersonasDesc()
                .map(doc -> new ReporteBootcamp(
                        doc.getId(),
                        doc.getBootcampId(),
                        doc.getNombre(),
                        doc.getDescripcion(),
                        doc.getFechaLanzamiento(),
                        doc.getDuracion(),
                        doc.getCantidadCapacidades(),
                        doc.getCantidadTecnologias(),
                        doc.getCantidadPersonas()
                ));
    }
}
