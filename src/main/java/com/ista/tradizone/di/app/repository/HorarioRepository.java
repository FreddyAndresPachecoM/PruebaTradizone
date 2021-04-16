package com.ista.tradizone.di.app.repository;

import com.ista.tradizone.di.app.model.Horario;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends MongoRepository<Horario, String>{
    
}
