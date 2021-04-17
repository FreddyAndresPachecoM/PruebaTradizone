package com.ista.tradizone.di.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "locales")
public class Local {
    
    @Id
    private String id;

    private String nombreIdentificador;
    private String direccion;
    private String telefono;
    private String celular;
    private String horaInicio;
    private String horaFin;

    /** Relaciones: ------------------------------ */
    private String idRestaurante;
}
