package com.ista.tradizone.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.tradizone.di.app.models.Producto;
import com.ista.tradizone.di.app.services.ProductoService;
import com.ista.tradizone.di.app.utils.Response;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    
    @Autowired
    private ProductoService productoService;


    @PostMapping("/crear")
    public Response<Producto> crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @GetMapping("/listar")
    public Response<Producto> getProductos(){
        return productoService.getProductos();
    }
	
}
