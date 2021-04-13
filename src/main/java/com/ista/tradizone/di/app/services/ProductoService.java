package com.ista.tradizone.di.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.tradizone.di.app.models.Producto;
import com.ista.tradizone.di.app.repositories.ProductoRepository;
import com.ista.tradizone.di.app.utils.Response;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public Response<Producto> crearProducto(Producto producto){
        productoRepository.insert(producto);
        return new Response<>(201, "recurso creado con exito!", null);
    }


    public Response<Producto> getProductos(){
        return new Response<>(200, "Ok", productoRepository.findAll());
    }
}
