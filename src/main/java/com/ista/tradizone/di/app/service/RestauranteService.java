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


    public Response<Restaurante> crearRestaurante(Restaurante restaurante, MultipartFile logoRestaurante, String idUsuario) {
        try {
            if(restauranteRepository.findByIdUsuario(idUsuario) == null){

                if(cloudinaryService.esImagen(logoRestaurante)){

                    restaurante.setIdUsuario(idUsuario);
                    restauranteRepository.insert(restaurante);

                    String idRestaurante = restauranteRepository.findByIdUsuario(idUsuario).getId();

                    Map<?,?> imagenData = cloudinaryService.subirImagen(logoRestaurante);
                    
                    Logo logo = new Logo();
                    logo.setIdRestaurante(idRestaurante);
                    logo.setNombre((String)imagenData.get("original_filename"));
                    logo.setUrl((String)imagenData.get("url"));
                    logo.setCloudinaryId((String)imagenData.get("public_id"));

                    logoRepository.insert(logo);

                    return new Response<>(HttpStatus.CREATED, "¡Recurso creado con exito!", null);

                }else
                    return new Response<>(HttpStatus.FILE_FORMAT_ERROR, "¡Este formato de archivo no esta permitido!", null);
            }else
                return new Response<>(HttpStatus.BAD_REQUEST, "¡Ya existe un restaurante para este usuario!", null);
            
        } catch (IOException e) {
            return new Response<>(HttpStatus.FILE_FORMAT_ERROR, "¡Este formato de archivo no esta permitido!", null);
        }
    }
}
