package com.ista.tradizone.di.app.controllers;

import com.ista.tradizone.di.app.models.Imagen;
import com.ista.tradizone.di.app.services.ImagenService;
import com.ista.tradizone.di.app.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/app")
@CrossOrigin("*")
public class ImagenController {
    
    @Autowired
    private ImagenService imagenService;


    @PostMapping("/imagenes/subir")
    public Response<Imagen> guardarImagen(@RequestParam MultipartFile archivo){
        return imagenService.guardarImagen(archivo);
    }
    
    @GetMapping("/imagenes")
    public Response<Imagen> getImagenes(){
        return imagenService.getImagenes();
    }
}
