package com.ista.tradizone.di.app.repository;

import java.util.List;

import com.ista.tradizone.di.app.model.Local;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends MongoRepository<Local, String>{
    
    public Local findByNombreIdentificador(String nombreIdentificador);
    public List<Local> findByIdRestaurante(String idRestaurante);
}
