package com.onclass.reporte.infrastructure.entrypoints.dto;

import java.util.List;

public record InscripcionRequest(
        List<Long> bootcampIds
) {}
