package com.onclass.reporte.domain.usecase;

import com.onclass.reporte.domain.model.ReporteBootcamp;
import com.onclass.reporte.domain.spi.ReportePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

class ReporteUseCaseTest {

    private ReportePersistencePort persistencePort;
    private ReporteUseCase useCase;

    @BeforeEach
    void setUp() {
        persistencePort = Mockito.mock(ReportePersistencePort.class);

        useCase = new ReporteUseCase(persistencePort);
    }

    @Test
    void deberiaRetornarBootcampMasExitoso() {
        ReporteBootcamp r1 = new ReporteBootcamp("a", 1L, "Boot A", "Desc", LocalDate.now(), 4, 3, 6, 10);
        when(persistencePort.obtenerBootcampMasExitoso()).thenReturn(Mono.just(r1));

        StepVerifier.create(useCase.obtenerBootcampMasExitoso())
                .expectNextMatches(r -> r.bootcampId().equals(1L))
                .verifyComplete();
    }
}
