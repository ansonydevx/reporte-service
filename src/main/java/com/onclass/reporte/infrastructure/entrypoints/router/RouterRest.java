package com.onclass.reporte.infrastructure.entrypoints.router;

import com.onclass.reporte.infrastructure.entrypoints.handler.ReporteHandler;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterRest {

    @Bean
//    @RouterOperations({
//            @RouterOperation(
//                    path = "/bootcamps",
//                    method = RequestMethod.POST,
//                    beanClass = BootcampHandler.class,
//                    beanMethod = "registrar"
//            ),
//            @RouterOperation(
//                    path = "/bootcamps",
//                    method = RequestMethod.GET,
//                    beanClass = BootcampHandler.class,
//                    beanMethod = "listar"
//            ),
//            @RouterOperation(
//                    path = "/bootcamps/{id}",
//                    method = RequestMethod.DELETE,
//                    beanClass = BootcampHandler.class,
//                    beanMethod = "eliminar"
//            )
//    })
    public RouterFunction<ServerResponse> routerFunction(ReporteHandler handler) {
        return RouterFunctions.route()
                .POST("/reportes/bootcamps", handler::registrar)
                .POST("/reportes/bootcamps/{id}/incrementar-personas", handler::incrementarPersonas)
                .build();
    }
}
