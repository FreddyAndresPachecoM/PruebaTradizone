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
@Document(collection = "platos")
public class Plato {
    
    @Id
    private String id;

    private String nombre;
    private String descripcion;
    private String ingredientes;
    private double precio;

    /** Relaciones: --------------------------------------- */
    private String idCategoria;
}
