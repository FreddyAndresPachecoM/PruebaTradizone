package com.ista.tradizone.di.app.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ista.tradizone.di.app.utils.Imagen;

import lombok.Data;

@Data
@Document(collection = "Productos")
public class Producto {

	@Id
	private String id;
    private String nombre;

    @Indexed(direction = IndexDirection.ASCENDING)
    private String descripcion;
    private boolean estado;
	private double precio;
	private Imagen imagen;
	private Restaurante restaurante;
	private List<CategoriaProducto> categorias;
	private List<Recomendacion> recomendaciones;
}
