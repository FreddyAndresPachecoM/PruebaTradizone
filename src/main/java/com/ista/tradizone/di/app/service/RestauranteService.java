package com.ista.tradizone.di.app.service;

import java.io.IOException;
import java.util.Map;

import com.ista.tradizone.di.app.model.Restaurante;
import com.ista.tradizone.di.app.model.imagen.Logo;
import com.ista.tradizone.di.app.repository.RestauranteRepository;
import com.ista.tradizone.di.app.repository.imagen_repository.LogoRepository;
import com.ista.tradizone.di.app.service.cloudinary.CloudinaryService;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RestauranteService {
    
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private LogoRepository logoRepository;
    
    @Autowired
    private CloudinaryService cloudinaryService;


    public Response<Restaurante> crearRestaurante(Restaurante restaurante, String idUsuario) {
        boolean existeRestaurante = restauranteRepository.findByIdUsuario(idUsuario) != null;
        if(!existeRestaurante){
            restaurante.setIdUsuario(idUsuario);
            return new Response<>(HttpStatus.CREATED, "¡Recurso creado con exito!", restauranteRepository.insert(restaurante));
        }else
        return new Response<>(HttpStatus.BAD_REQUEST, "¡Ya existe un restaurante para este usuario!", null);
    }


    public Response<Logo> crearLogo(MultipartFile logoRestaurante, String idRestaurante) throws IOException{
        if(restauranteRepository.findById(idRestaurante).isPresent()){
            boolean existeLogo = logoRepository.findByIdRestaurante(idRestaurante) != null;
            if(!existeLogo){
                if(cloudinaryService.esImagen(logoRestaurante)){
                    Map<?,?> imagenData = cloudinaryService.subirImagen(logoRestaurante);
        
                    Logo logo = new Logo();
                    logo.setIdRestaurante(idRestaurante);
                    logo.setNombre((String)imagenData.get("original_filename"));
                    logo.setUrl((String)imagenData.get("url"));
                    logo.setCloudinaryId((String)imagenData.get("public_id"));
        
                    return new Response<>(HttpStatus.CREATED, "¡Recurso creado con exito!", logoRepository.insert(logo));
                }else
                return new Response<>(HttpStatus.FILE_FORMAT_ERROR, "¡Este formato de archivo no esta permitido!", null);
            }else
            return new Response<>(HttpStatus.BAD_REQUEST, "¡Ya existe un logo para este restaurante!", null);
        }else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Recurso no encontrado!", null);
    }


    public Response<Restaurante> getAllRestaurantes(){
        return new Response<>(HttpStatus.Ok, "Ok!", restauranteRepository.findAll());
    }


    public Response<Restaurante> getRestaurantePorUsuario(String idUsuario){
        boolean existeRestaurante = restauranteRepository.findByIdUsuario(idUsuario) != null;
        if(existeRestaurante)
            return new Response<>(HttpStatus.Ok, "Ok!", restauranteRepository.findByIdUsuario(idUsuario));
        else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡El recurso solicitado no existe!", null);
    }


    public Response<Logo> getLogoRestaurante(String idRestaurante){
        boolean existeLogo = logoRepository.findByIdRestaurante(idRestaurante) != null;
        if(existeLogo)
            return new Response<>(HttpStatus.Ok, "Ok!", logoRepository.findByIdRestaurante(idRestaurante));
        else
        return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡El recurso solicitado no existe!", null);
    }

}
