package com.ista.tradizone.di.app.controller;

import com.ista.tradizone.di.app.model.Categoria;
import com.ista.tradizone.di.app.service.CategoriaService;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@CrossOrigin("*")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;


    @PostMapping("/categorias")
    public Response<Categoria> crearCategoria(@RequestBody Categoria categoria){
       return categoriaService.crearCategoria(categoria);
    }


    @GetMapping("/categorias")
    public Response<Categoria> getAllCategorias(){
        return categoriaService.getAllCategorias();
    }


    @GetMapping("/categorias/{idCategoria}")
    public Response<Categoria> getCategoriaPorId(@PathVariable String idCategoria){
        return categoriaService.getCategoriaPorId(idCategoria);
    }
}
