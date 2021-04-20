package com.ista.tradizone.di.app.repository.autenticacion_repository;

import com.ista.tradizone.di.app.model.autenticacion.Sesion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutenticacionRepository extends MongoRepository<Sesion, String>{
    public Sesion findByIdUsuario(String idUsuario);
}
