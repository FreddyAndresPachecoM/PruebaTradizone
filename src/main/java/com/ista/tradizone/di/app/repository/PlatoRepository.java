package com.ista.tradizone.di.app.repository;

import com.ista.tradizone.di.app.model.Plato;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends MongoRepository<Plato, String>{

	public Plato findByIdRestaurante(String idPlato);
}
