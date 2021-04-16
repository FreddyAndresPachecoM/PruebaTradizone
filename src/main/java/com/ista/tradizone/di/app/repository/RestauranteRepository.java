package com.ista.tradizone.di.app.repository;

import com.ista.tradizone.di.app.model.Restaurante;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends MongoRepository<Restaurante, String>{
    
    public Restaurante findByIdUsuario(String idUsuario);
}
