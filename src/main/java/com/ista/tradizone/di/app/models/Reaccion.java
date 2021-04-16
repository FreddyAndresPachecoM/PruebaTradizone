package com.ista.tradizone.di.app.models;

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
@Document(collection = "reacciones")
public class Reaccion {
    
    @Id
    private String id;

    private boolean meGusta;
    

    /** Relaciones: un megusta por usuario en cada plato: ----------------------------------- */
    private String idUsuario;
    private String idPlato;
}
