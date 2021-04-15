package com.ista.tradizone.di.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Cuentas")
public class Cuenta {

	@Id
	private String id;
	
	private String nombres;
	private String apellidos;
	private String correo;
	
	private String userName;
	private String password;
	private boolean estado;
	private Imagen imagen;
}
