package com.ista.tradizone.di.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.tradizone.di.app.models.Usuario;
import com.ista.tradizone.di.app.repositories.UsuarioRepository;
import com.ista.tradizone.di.app.utils.Response;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Response<Usuario> crearUsuario(Usuario usuario){
        usuarioRepository.insert(usuario);
        return new Response<>(201, "recurso creado con exito!", null);
    }


    public Response<Usuario> getUsuarios(){
        return new Response<>(200, "Ok", usuarioRepository.findAll());
    }

}
