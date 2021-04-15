package com.ista.tradizone.di.app.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "Locales")
public class Local {
	@Id
	private String id;

	private String avPrincipal;
	private String avSecundaria;
	private boolean estado;
	private int capacidad;
	private String diasLaborables;
	private String horarioJornada;
	private Imagen imagen;
}
