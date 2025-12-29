package com.onclass.reporte.infrastructure.entrypoints.dto;

import java.time.LocalDate;

public record ReporteBootcampRequest(
        Long bootcampId,
        String nombre,
        String descripcion,
        LocalDate fechaLanzamiento,
        Integer duracion,
        Integer cantidadCapacidades,
        Integer cantidadTecnologias,
        Integer cantidadPersonas
) {}
