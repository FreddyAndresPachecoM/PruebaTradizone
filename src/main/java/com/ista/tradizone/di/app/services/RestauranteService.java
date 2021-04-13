package com.ista.tradizone.di.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.tradizone.di.app.models.Restaurante;
import com.ista.tradizone.di.app.repositories.RestauranteRepository;
import com.ista.tradizone.di.app.utils.Response;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;


    public Response<Restaurante> crearRestaurante(Restaurante restaurante){
        restauranteRepository.insert(restaurante);
        return new Response<>(201, "recurso creado con exito!", null);
    }


    public Response<Restaurante> getRestaurantes(){
        return new Response<>(200, "Ok", restauranteRepository.findAll());
    }

}
