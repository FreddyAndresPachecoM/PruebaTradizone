package com.ista.tradizone.di.app.repository.imagen_repository;

import com.ista.tradizone.di.app.model.imagen.ImagenPlato;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenPlatoRepository extends MongoRepository<ImagenPlato, String>{
    
	public ImagenPlato findByIdPlato(String idPlato);
}
