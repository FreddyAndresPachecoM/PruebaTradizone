package com.ista.tradizone.di.app.repository;

import com.ista.tradizone.di.app.model.Categoria;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String>{
    
}
