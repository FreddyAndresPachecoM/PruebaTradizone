package com.ista.tradizone.di.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "CategoriaProductos")
public class CategoriaProducto {
	
	@Id
	private String id;
    
	private String nombre;
	private String descripcion;

}
