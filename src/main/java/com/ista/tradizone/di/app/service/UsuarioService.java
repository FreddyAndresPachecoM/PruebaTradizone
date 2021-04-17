package com.ista.tradizone.di.app.service;

import com.ista.tradizone.di.app.model.Usuario;
import com.ista.tradizone.di.app.model.imagen.Avatar;
import com.ista.tradizone.di.app.repository.UsuarioRepository;
import com.ista.tradizone.di.app.repository.imagen_repository.AvatarRepository;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private String imagenPorDefecto = "Default";
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    /*@Autowired
    private CloudinaryService cloudinaryService;*/


    public Response<Usuario> crearUsuario(Usuario usuario){
        if(usuarioRepository.findByCorreo(usuario.getCorreo()) == null){
            usuario = usuarioRepository.insert(usuario);
            Avatar avatar = new Avatar();
            avatar.setNombre("");
            avatar.setUrl("https://res.cloudinary.com/dvtvnjgle/image/upload/v1618590004/perfil_por_defecto_e4cdu1.png");
            avatar.setCloudinaryId(imagenPorDefecto);
            avatar.setIdUsuario(usuario.getId());
            avatarRepository.insert(avatar);
            return new Response<>(HttpStatus.CREATED, "¡Recurso creado con exito!", usuario);
        }else
            return new Response<>(HttpStatus.BAD_REQUEST, "¡Este correo ya es usado por otro usuario!", null);
    }


}
