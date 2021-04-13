package com.ista.tradizone.di.app.utils;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Response <T>{
	
	private int codigo;
    private String descripcion;
    private List<T> cuerpo;
    
	/*public Response(int codigo, String descripcion, List<T> cuerpo) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cuerpo = cuerpo;
	}*/
    
    
}
