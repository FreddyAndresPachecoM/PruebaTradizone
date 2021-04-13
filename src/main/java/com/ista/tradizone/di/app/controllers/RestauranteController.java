package com.ista.tradizone.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.tradizone.di.app.models.Restaurante;
import com.ista.tradizone.di.app.services.RestauranteService;
import com.ista.tradizone.di.app.utils.Response;

@RestController
@RequestMapping("/restaurantes")

public class RestauranteController {

	@Autowired
    private RestauranteService restauranteService;


    @PostMapping("/crear")
    public Response<Restaurante> crearRestaurante(@RequestBody Restaurante restaurante){
        return restauranteService.crearRestaurante(restaurante);
    }

    @GetMapping("/listar")
    public Response<Restaurante> getRestaurantes(){
        return restauranteService.getRestaurantes();
    }
}
