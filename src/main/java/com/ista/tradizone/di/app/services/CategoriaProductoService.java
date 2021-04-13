package com.ista.tradizone.di.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.tradizone.di.app.models.CategoriaProducto;
import com.ista.tradizone.di.app.repositories.CategoriaProductoRepository;
import com.ista.tradizone.di.app.utils.Response;

@Service
public class CategoriaProductoService {

	@Autowired
	private CategoriaProductoRepository categoriaProductoRepository;
	
	public Response <CategoriaProducto> crearCategoria(CategoriaProducto categoriaProducto){
		categoriaProductoRepository.insert(categoriaProducto);
		return new Response<>(200, "Recurso creado exitoamente!", null);
	}
	
	public Response<CategoriaProducto> getCategorias(){
        return new Response<>(200, "Ok!", categoriaProductoRepository.findAll());
    }
}
