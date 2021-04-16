package com.ista.tradizone.di.app.repository;

import com.ista.tradizone.di.app.model.Reaccion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaccionRepository extends MongoRepository<Reaccion, String>{
    
}
