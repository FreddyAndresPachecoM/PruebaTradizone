package com.ista.tradizone.di.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ista.tradizone.di.app.model.Plato;
import com.ista.tradizone.di.app.model.imagen.ImagenPlato;
import com.ista.tradizone.di.app.service.PlatoService;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;

@RestController
@RequestMapping("/app")
@CrossOrigin("*")
public class PlatoController {

	@Autowired
	private PlatoService platoService;
	
	@PostMapping("/platos/{idRestaurante}")
	public Response<Plato> crearPlato(@RequestBody Plato plato, @PathVariable String idRestaurante){
		return platoService.crearPlato(plato, idRestaurante);
	}
	
	@PostMapping("/platos/imagenPlato/{idPlato}")
	public Response<ImagenPlato> crearImagenPlato(@RequestBody MultipartFile imagenPlato, @PathVariable String idPlato){
		try {
			return platoService.crearImagenPlato(imagenPlato, idPlato);
		}catch (IOException e) {
			return new Response<>(HttpStatus.FILE_FORMAT_ERROR, "Este formato de archivo no esta permitido!", null);
		}
	}
	
	@GetMapping("/platos")
	public Response<Plato> getAllPlatos(){
		return platoService.getAllPlatos();
	}
}
