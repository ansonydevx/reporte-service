package com.onclass.reporte.infrastructure.entrypoints.handler;

import com.onclass.reporte.domain.api.ReporteServicePort;
import com.onclass.reporte.domain.model.ReporteBootcamp;
import com.onclass.reporte.infrastructure.entrypoints.dto.ReporteBootcampRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReporteHandler {

    private final ReporteServicePort reporteServicePort;

    public Mono<ServerResponse> registrar(ServerRequest request) {
        return request.bodyToMono(ReporteBootcampRequest.class)
                .map(dto -> new ReporteBootcamp(
                        null,
                        dto.bootcampId(),
                        dto.nombre(),
                        dto.descripcion(),
                        dto.fechaLanzamiento(),
                        dto.duracion(),
                        dto.cantidadCapacidades(),
                        dto.cantidadTecnologias(),
                        dto.cantidadPersonas()
                ))
                .flatMap(reporteServicePort::registrar)
                .then(ServerResponse.status(HttpStatus.CREATED).build());
    }

    public Mono<ServerResponse> incrementarPersonas(ServerRequest request) {
        Long bootcampId = Long.parseLong(request.pathVariable("id"));

        return reporteServicePort
                .incrementarPersonas(bootcampId)
                .then(ServerResponse.ok().build());
    }

    public Mono<ServerResponse> obtenerBootcampMasExitoso(ServerRequest request) {
        return reporteServicePort.obtenerBootcampMasExitoso()
                .flatMap(reporte ->
                        ServerResponse.ok().bodyValue(reporte)
                )
                .switchIfEmpty(ServerResponse.noContent().build());
    }
}
