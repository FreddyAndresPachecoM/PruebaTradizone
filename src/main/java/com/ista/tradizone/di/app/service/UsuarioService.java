package com.ista.tradizone.di.app.service;

import java.io.IOException;
import java.util.Map;

import com.ista.tradizone.di.app.model.Usuario;
import com.ista.tradizone.di.app.model.imagen.Avatar;
import com.ista.tradizone.di.app.repository.UsuarioRepository;
import com.ista.tradizone.di.app.repository.imagen_repository.AvatarRepository;
import com.ista.tradizone.di.app.service.cloudinary.CloudinaryService;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private CloudinaryService cloudinaryService;


    public Response<Usuario> crearUsuario(Usuario usuario, MultipartFile avatarUsuario){
        try {
            if(usuarioRepository.findByCorreo(usuario.getCorreo()) == null){
                if(cloudinaryService.esImagen(avatarUsuario)){
                    usuarioRepository.insert(usuario);
                    Map<?,?> imagenData = cloudinaryService.subirImagen(avatarUsuario);
                    usuario = usuarioRepository.findByCorreo(usuario.getCorreo());
                    Avatar avatar = new Avatar();
                    avatar.setNombre((String)imagenData.get("original_filename"));
                    avatar.setUrl((String)imagenData.get("url"));
                    avatar.setCloudinaryId((String)imagenData.get("public_id"));
                    avatar.setIdUsuario(usuario.getId());
                    avatarRepository.insert(avatar);
                    return new Response<>(HttpStatus.CREATED, "¡Recurso creado con exito!", null);
                }else 
                    return new Response<>(HttpStatus.FILE_FORMAT_ERROR, "¡Formato de imagen no valido!", null);
            }else
                return new Response<>(HttpStatus.BAD_REQUEST, "¡Este correo ya es usado por otro usuario!", null);
        } catch (IOException e) {
            return new Response<>(HttpStatus.FILE_FORMAT_ERROR, "¡Formato de imagen no valido!", null);
        }
    }


}
