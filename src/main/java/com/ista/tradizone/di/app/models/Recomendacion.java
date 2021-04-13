package com.ista.tradizone.di.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Recomendaciones")
public class Recomendacion {
	
    @Id
	private String id;
    
	private int rating;
	private boolean aprovacion;
	private String nombreUsuario;
}
