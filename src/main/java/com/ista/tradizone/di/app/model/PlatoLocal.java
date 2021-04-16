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
@Document(collection = "platos_local")
public class PlatoLocal {
    
    @Id
    private String id;

    /** Relaciones: ------------------------------------------ */
    private String idLocal;
    private String idPlato;
}
