package com.ista.tradizone.di.app.repository.imagen_repository;

import com.ista.tradizone.di.app.model.imagen.Logo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogoRepository extends MongoRepository<Logo, String>{
    
    public Logo findByIdRestaurante(String idRestaurante);
}
