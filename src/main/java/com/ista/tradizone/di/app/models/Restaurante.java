package com.ista.tradizone.di.app.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Restaurantes")
public class Restaurante {

	@Id
	private String id;
    
	private String nombreRestaurante;
	private Imagen logo;
     
	@Indexed(direction = IndexDirection.ASCENDING)
	private boolean estado;
	private String telefono;
	private Cuenta cuenta;
	private List<Local> locales;
}
