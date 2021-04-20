package com.ista.tradizone.di.app.service;

import com.ista.tradizone.di.app.model.Usuario;
import com.ista.tradizone.di.app.repository.UsuarioRepository;
import com.ista.tradizone.di.app.service.autenticacion.AutenticacionService;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AutenticacionService autenticacionService;

    
    public Response<Usuario> getAllUsuarios(){
        return new Response<>(HttpStatus.Ok, "Ok!", this.usuarioRepository.findAll());
    }
    
    public Response<Usuario> getUsuarioPorId(String idUsuario, String token){
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        if(usuario != null) {
            if(autenticacionService.validarSesion(idUsuario, token)){
                usuario.setContrasena("");
                return new Response<>(HttpStatus.UNAUTHORIZED, "¡Usuario no autorizado!", usuario);
            }else
            return new Response<>(HttpStatus.UNAUTHORIZED, "¡Usuario no autorizado!", null);
        }else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Recurso no encontrado!", null);
    }
}
