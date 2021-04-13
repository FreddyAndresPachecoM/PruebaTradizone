package com.ista.tradizone.di.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.tradizone.di.app.models.Plato;
import com.ista.tradizone.di.app.repositories.PlatoRepository;
import com.ista.tradizone.di.app.utils.Response;

@Service
public class PlatoService {

	@Autowired
    private PlatoRepository platoRepository;

    public Response<Plato> crearPlato(Plato plato){
        platoRepository.insert(plato);
        return new Response<>(201, "Recurso creado exitosamente!", null);
    }

    public Response<Plato> getPlatos(){
        return new Response<>(200, "Ok!", platoRepository.findAll());
    }
}
