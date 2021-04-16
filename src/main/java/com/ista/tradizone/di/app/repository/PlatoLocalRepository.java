package com.ista.tradizone.di.app.repository;

import com.ista.tradizone.di.app.model.PlatoLocal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoLocalRepository extends MongoRepository<PlatoLocal, String>{
    
}
