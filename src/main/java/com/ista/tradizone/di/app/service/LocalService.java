package com.ista.tradizone.di.app.service;

import com.ista.tradizone.di.app.model.Local;
import com.ista.tradizone.di.app.repository.LocalRepository;
import com.ista.tradizone.di.app.repository.RestauranteRepository;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalService {
    
    @Autowired 
    private LocalRepository localRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    private String defaultLocalName = "Sucursal Principal";


    public Response<Local> crearLocal(Local local, String idRestaurante){
        boolean existeRestaurante = restauranteRepository.findById(idRestaurante).isPresent();
        if(existeRestaurante){
            local.setIdRestaurante(idRestaurante);
            if(local.getNombreIdentificador().equals("")) {
                local.setNombreIdentificador(defaultLocalName);
            }
            return new Response<>(HttpStatus.CREATED, "¡Recurso creado con exito!", localRepository.insert(local));
        }else
            return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡¡Esta intentando acceder a un recurso que no existe!", null);
    }


    public Response<Local> getLocalesPorRestaurante(String idRestaurante){
        if(restauranteRepository.findById(idRestaurante).isPresent()){
            return new Response<>(HttpStatus.Ok, "¡Ok!", localRepository.findByIdRestaurante(idRestaurante));
        }else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Esta intentando acceder a un recurso que no existe!", null);
    }


    public Response<Local> getLocalPorId(String idLocal){
        if(localRepository.findById(idLocal).isPresent()){
            return new Response<>(HttpStatus.Ok, "¡Ok!", localRepository.findById(idLocal).get());
        }else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Esta intentando acceder a un recurso que no existe!", null);
    }
}
