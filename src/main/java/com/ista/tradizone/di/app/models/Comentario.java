package com.ista.tradizone.di.app.models;

import java.time.LocalDate;

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
@Document(collection = "comentarios")
public class Comentario {
    
    @Id
    private String id;
    
    private String cuerpo;
    private LocalDate fechaPublicacion;


    /** Relaciones: ---------------------------- */
    private String idUsuario;
    private String idPlato;
}
