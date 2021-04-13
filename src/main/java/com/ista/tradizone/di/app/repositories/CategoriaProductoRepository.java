package com.ista.tradizone.di.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ista.tradizone.di.app.models.CategoriaProducto;

@Repository
public interface CategoriaProductoRepository extends MongoRepository<CategoriaProducto, String>{

}
