package com.onclass.reporte.domain.model;

import java.time.LocalDate;

public record ReporteBootcamp(
        String id,
        Long bootcampId,
        String nombre,
        String descripcion,
        LocalDate fechaLanzamiento,
        Integer duracion,
        Integer cantidadCapacidades,
        Integer cantidadTecnologias,
        Integer cantidadPersonas
) {}