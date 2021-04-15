package com.ista.tradizone.di.app.repositories;

import com.ista.tradizone.di.app.models.Imagen;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends MongoRepository<Imagen, String>{
    
}
