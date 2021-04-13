package com.ista.tradizone.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.tradizone.di.app.models.Recomendacion;
import com.ista.tradizone.di.app.services.RecomendacionService;
import com.ista.tradizone.di.app.utils.Response;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {

	
    @Autowired
    private RecomendacionService recomendacionService;


    @PostMapping("/crear")
    public Response<Recomendacion> crearRecomendacion(@RequestBody Recomendacion recomendacion){
        return recomendacionService.crearRecomendacion(recomendacion);
    }

    @GetMapping("/listar")
    public Response<Recomendacion> getRecomendaciones(){
        return recomendacionService.getRecomendaciones();
    }
}
