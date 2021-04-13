package com.ista.tradizone.di.app.models;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Platos")
public class Plato extends Producto{

	private String ingredientes;
	private String preparacion;
	private String historia;
	
}
