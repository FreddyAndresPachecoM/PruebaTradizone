package com.ista.tradizone.di.app.controller;

import java.io.IOException;

import com.ista.tradizone.di.app.model.Local;
import com.ista.tradizone.di.app.model.Restaurante;
import com.ista.tradizone.di.app.model.imagen.Logo;
import com.ista.tradizone.di.app.service.RestauranteService;
import com.ista.tradizone.di.app.util.HttpStatus;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/app")
@CrossOrigin("*")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;


    @PostMapping("/restaurantes/{idUsuario}")
    public Response<Restaurante> crearRestaurante(
        @RequestBody Restaurante restaurante, 
        @RequestBody Local local, 
        @RequestParam MultipartFile logoRestaurante, 
        @PathVariable String idUsuario
    ){
        try {
            return restauranteService.crearRestaurante(restaurante, local, logoRestaurante, idUsuario);
        } catch (IOException e) {
            return new Response<>(HttpStatus.FILE_FORMAT_ERROR, "¡Este formato de archivo no esta permitido!", null);
        }
    }


    @GetMapping("/restaurantes")
    public Response<Restaurante> getAllRestaurantes(){
        return restauranteService.getAllRestaurantes();
    }


    @GetMapping("restaurantes/{idUsuario}")
    public Response<Restaurante> getRestaurantePorUsuario(@PathVariable String idUsuario){
        return restauranteService.getRestaurantePorUsuario(idUsuario);
    }


    @GetMapping("/restaurantes/logo/{idRestaurante}")
    public Response<Logo> getLogoRestaurante(@PathVariable String idRestaurante){
        return restauranteService.getLogoRestaurante(idRestaurante);
    }
}
