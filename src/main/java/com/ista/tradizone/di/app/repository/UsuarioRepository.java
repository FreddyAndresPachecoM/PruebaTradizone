package com.ista.tradizone.di.app.repository;

import com.ista.tradizone.di.app.model.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    
}
