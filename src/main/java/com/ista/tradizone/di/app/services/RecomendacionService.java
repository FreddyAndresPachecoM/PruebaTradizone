package com.ista.tradizone.di.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.tradizone.di.app.models.Recomendacion;
import com.ista.tradizone.di.app.repositories.RecomendacionRepository;
import com.ista.tradizone.di.app.utils.Response;

@Service
public class RecomendacionService {

	
    @Autowired
    private RecomendacionRepository recomendacionRepository;


    public Response<Recomendacion> crearRecomendacion(Recomendacion recomendacion){
        recomendacionRepository.insert(recomendacion);
        return new Response<>(201, "recurso creado con exito!", null);
    }


    public Response<Recomendacion> getRecomendaciones(){
        return new Response<>(200, "Ok", recomendacionRepository.findAll());
    }
}
