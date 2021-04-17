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


    public Response<Local> crearSucursal(Local sucursal, String idRestaurante){
        boolean existeRestaurante = restauranteRepository.findById(idRestaurante).isPresent();
        boolean existeSucursal = localRepository.findByNombreIdentificador(sucursal.getNombreIdentificador()) != null;
        if(existeRestaurante && !existeSucursal){
            sucursal.setIdRestaurante(idRestaurante);
            localRepository.insert(sucursal); 
            return new Response<>(HttpStatus.CREATED, "¡Recurso creado con exito!", null);
        }else
            return new Response<>(HttpStatus.BAD_REQUEST, "¡No se pudo completar la solicitud debido a que intenta duplicar la sucursal o el restaurante no existe!", null);
    }

}
