package com.ista.tradizone.di.app.service;

import com.ista.tradizone.di.app.model.Categoria;
import com.ista.tradizone.di.app.repository.CategoriaRepository;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    

    public Response<Categoria> crearCategoria(Categoria categoria){
        return new Response<>(HttpStatus.CREATED, "recurso creado exitosamente!", categoriaRepository.insert(categoria));
    }


    public Response<Categoria> getAllCategorias(){
        return new Response<>(HttpStatus.Ok, "Ok!", categoriaRepository.findAll());
    }
}
