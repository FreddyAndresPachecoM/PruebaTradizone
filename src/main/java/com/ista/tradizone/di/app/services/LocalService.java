package com.ista.tradizone.di.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.tradizone.di.app.models.Local;
import com.ista.tradizone.di.app.repositories.LocalRepository;
import com.ista.tradizone.di.app.utils.Response;


@Service
public class LocalService {

	@Autowired
    private LocalRepository localRepository;

    public Response<Local> crearLocal(Local local){
        localRepository.insert(local);
        return new Response<>(201, "Recurso creado exitosamente!", null);
    }

    public Response<Local> getLocales(){
        return new Response<>(200, "Ok!", localRepository.findAll());
    }
}
