package com.ista.tradizone.di.app.repository;

import com.ista.tradizone.di.app.model.Comentario;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String>{
    
}
