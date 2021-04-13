package com.ista.tradizone.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.tradizone.di.app.models.CategoriaProducto;
import com.ista.tradizone.di.app.services.CategoriaProductoService;
import com.ista.tradizone.di.app.utils.Response;

@RestController
@RequestMapping("/categorias")
public class CategoriaProductoController {

	@Autowired
    private CategoriaProductoService categoriaService;


    @PostMapping("/crear")
    public Response<CategoriaProducto> crearCategoria(@RequestBody CategoriaProducto categoria){
        return categoriaService.crearCategoria(categoria);
    }

    @GetMapping("/listar")
    public Response<CategoriaProducto> getCategorias(){
        return categoriaService.getCategorias();
    }
}
