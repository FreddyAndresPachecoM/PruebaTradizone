package com.ista.tradizone.di.app.service;

import com.ista.tradizone.di.app.model.Usuario;
import com.ista.tradizone.di.app.model.imagen.Avatar;
import com.ista.tradizone.di.app.repository.UsuarioRepository;
import com.ista.tradizone.di.app.repository.imagen_repository.AvatarRepository;
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
    private AvatarRepository avatarRepository;

    @Autowired
    private AutenticacionService autenticacionService;

    
    public Response<Usuario> getAllUsuarios(){
        return new Response<>(HttpStatus.Ok, "Ok!", this.usuarioRepository.findAll());
    }
    
    public Response<Usuario> getUsuarioPorId(String idUsuario, String token){
        if(usuarioRepository.findById(idUsuario).isPresent()) {
            if(autenticacionService.validarSesion(idUsuario, token)){
                Usuario usuario = usuarioRepository.findById(idUsuario).get();
                usuario.setContrasena("");
                return new Response<>(HttpStatus.Ok, "¡oK!", usuario);
            }else
            return new Response<>(HttpStatus.UNAUTHORIZED, "¡Usuario no autorizado!", null);
        }else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Recurso no encontrado!", null);
    }


    public Response<Avatar> getAvatarUsuario(String idUsuario){
        if(usuarioRepository.findById(idUsuario).isPresent()){
            Avatar avatar = avatarRepository.findByIdUsuario(idUsuario);
            return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Recurso no encontrado!", avatar);
        }else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Recurso no encontrado!", null);
    }
}
