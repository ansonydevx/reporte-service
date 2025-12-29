package com.onclass.reporte.application.config;

import com.onclass.reporte.domain.api.ReporteServicePort;
import com.onclass.reporte.domain.spi.ReportePersistencePort;
import com.onclass.reporte.domain.usecase.ReporteUseCase;
import com.onclass.reporte.infrastructure.adapters.persistence.ReportePersistenceAdapter;
import com.onclass.reporte.infrastructure.adapters.persistence.repository.ReporteBootcampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UseCasesConfig {

    private final ReporteBootcampRepository reporteBootcampRepository;

    @Bean
    public ReportePersistencePort reportePersistencePort() {
        return new ReportePersistenceAdapter(reporteBootcampRepository);
    }

    @Bean
    public ReporteServicePort reporteServicePort(
            ReportePersistencePort reportePersistencePort) {
        return new ReporteUseCase(reportePersistencePort);
    }
}
