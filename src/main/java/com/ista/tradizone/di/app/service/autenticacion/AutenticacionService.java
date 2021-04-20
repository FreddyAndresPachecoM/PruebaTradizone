package com.ista.tradizone.di.app.service.autenticacion;

import com.ista.tradizone.di.app.model.Usuario;
import com.ista.tradizone.di.app.model.autenticacion.Sesion;
import com.ista.tradizone.di.app.model.imagen.Avatar;
import com.ista.tradizone.di.app.repository.UsuarioRepository;
import com.ista.tradizone.di.app.repository.autenticacion_repository.AutenticacionRepository;
import com.ista.tradizone.di.app.repository.imagen_repository.AvatarRepository;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {
    
    @Autowired
    private AutenticacionRepository autenticacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    private String imagenPorDefecto = "Default";


    public Response<Sesion> registrarUsuario(Usuario usuario){
        if(usuarioRepository.findByCorreo(usuario.getCorreo()) == null){
            usuario = usuarioRepository.insert(usuario);

            Avatar avatar = new Avatar();
            avatar.setNombre("");
            avatar.setUrl("https://res.cloudinary.com/dvtvnjgle/image/upload/v1618590004/perfil_por_defecto_e4cdu1.png");
            avatar.setCloudinaryId(imagenPorDefecto);
            avatar.setIdUsuario(usuario.getId());
            avatarRepository.insert(avatar);

            Sesion sesion = new Sesion();
            sesion.setIdUsuario(usuario.getId());
            sesion.setToken(crearToken());
            sesion = autenticacionRepository.insert(sesion);
            return new Response<>(HttpStatus.CREATED, "¡Recurso creado con exito!", sesion);
        }else
        return new Response<>(HttpStatus.BAD_REQUEST, "¡Este correo ya es usado por otro usuario!", null);
    }


    public Response<Sesion> iniciarSesion(String correo, String contrasena){
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if(usuario != null){
            if(usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)){
                Sesion sesion = autenticacionRepository.findByIdUsuario(usuario.getId());
                if(sesion == null){
                    sesion = new Sesion();
                    sesion.setIdUsuario(usuario.getId());
                    sesion.setToken(crearToken());
                    sesion = autenticacionRepository.insert(sesion);
                    return new Response<>(HttpStatus.Ok, "¡Ok!", sesion);
                }else 
                return new Response<>(HttpStatus.Ok, "¡Ok!", sesion);
            }else
            return new Response<>(HttpStatus.UNAUTHORIZED, "¡Usuario no autorizado!", null);
        }else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Recurso no encontrado!", null);
    }


    public Response<Sesion> cerrarSesion(String idUsuario){
        if(usuarioRepository.findById(idUsuario).isPresent()){
            Sesion sesion = autenticacionRepository.findByIdUsuario(idUsuario);
            if(sesion != null){
                autenticacionRepository.deleteById(sesion.getId());
            }
            return new Response<>(HttpStatus.Ok, "¡Ok!");
        }else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Recurso no encontrado!");
    }
    

    public boolean validarSesion(String idUsuario, String token){
        if(usuarioRepository.findById(idUsuario).isPresent()){
            Sesion sesion = autenticacionRepository.findByIdUsuario(idUsuario);
            if(sesion != null){
                if(sesion.getToken().equals(token)){
                    return true;
                }
            }
        }
        return false;
    }


    private String crearToken(){
        String token = "";
        for(int i = 0; i < 20; i++){
            int random = (int)(Math. random()*10); 
            token = token + random;
        }
        return token;
    }


}
