package com.onclass.reporte.infrastructure.adapters.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "reportes_bootcamp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteBootcampDocument {

    @Id
    private String id;

    private Long bootcampId;
    private String nombre;
    private String descripcion;
    private LocalDate fechaLanzamiento;
    private Integer duracion;
    private Integer cantidadCapacidades;
    private Integer cantidadTecnologias;
    private Integer cantidadPersonas;
}
