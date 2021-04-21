package com.ista.tradizone.di.app.repository.imagen_repository;

import com.ista.tradizone.di.app.model.imagen.Avatar;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends MongoRepository<Avatar, String>{
    
    public Avatar findByIdUsuario(String idUsuario);
}
