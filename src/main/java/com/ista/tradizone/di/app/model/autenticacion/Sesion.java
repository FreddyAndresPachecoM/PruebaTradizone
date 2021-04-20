package com.ista.tradizone.di.app.model.autenticacion;

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
@Document(collection = "sesiones")
public class Sesion {
    
    @Id
    public String id;
    public String token;
    public String idUsuario;
}
