package com.ista.tradizone.di.app.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ista.tradizone.di.app.model.Plato;
import com.ista.tradizone.di.app.model.imagen.ImagenPlato;
import com.ista.tradizone.di.app.repository.PlatoRepository;
import com.ista.tradizone.di.app.repository.RestauranteRepository;
import com.ista.tradizone.di.app.repository.imagen_repository.ImagenPlatoRepository;
import com.ista.tradizone.di.app.service.cloudinary.CloudinaryService;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;


@Service
public class PlatoService {
    
	@Autowired
	private PlatoRepository platoRepository;
	
	@Autowired
	private ImagenPlatoRepository imagenPlatoRepository;
	
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public Response<Plato> crearPlato(Plato plato, String idRestaurante){
		if(restauranteRepository.findById(idRestaurante).isPresent()) {
			boolean existePlato = platoRepository.findByIdRestaurante(idRestaurante) != null;
			if(!existePlato) {
				plato.setIdRestaurante(idRestaurante);
				return new Response<>(HttpStatus.CREATED, "!Recurso plato creado exitosamente!", platoRepository.insert(plato));
			}else
				return new Response<>(HttpStatus.BAD_REQUEST, "¡Ya existe un plato para este restaurante!", null);
		}else
			return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Recurso no encontrado!", null);
	}
	
	public Response<ImagenPlato> crearImagenPlato(MultipartFile imagenPlato, String idPlato)throws IOException{{
	 if (platoRepository.findById(idPlato).isPresent()){
		 boolean existeImagen = imagenPlatoRepository.findByIdPlato(idPlato) != null;
		 if(!existeImagen) {
			 if(cloudinaryService.esImagen(imagenPlato)) {
				 Map<?, ?> imagenData = cloudinaryService.subirImagen(imagenPlato);
				 
				 ImagenPlato imgPlato = new ImagenPlato();
				 imgPlato.setIdPlato(idPlato);
				 imgPlato.setNombre((String)imagenData.get("original_filename"));
				 imgPlato.setUrl((String)imagenData.get("url"));
				 imgPlato.setCloudinaryId((String)imagenData.get("public_id"));
				 
				 return new Response<>(HttpStatus.CREATED, "¡Recurso creado con exito!", imagenPlatoRepository.insert(imgPlato));
			 }else
				 return new Response<>(HttpStatus.FILE_FORMAT_ERROR, "¡Este formato de archivo no esta permitido!", null);
		 }else
			 return new Response<>(HttpStatus.BAD_REQUEST, "¡Ya existe una imagen para este plato!", null);
			
	 	}else
		 return new Response<>(HttpStatus.RESOURCE_NOT_FOUND, "¡Recurso no encontrado!", null);
		}
	}
	
	public Response<Plato> getAllPlatos(){
		return new Response<>(HttpStatus.Ok,"OK!", platoRepository.findAll());
	}
}
	
