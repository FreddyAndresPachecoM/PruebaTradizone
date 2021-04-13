package com.ista.tradizone.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.tradizone.di.app.models.Plato;
import com.ista.tradizone.di.app.services.PlatoService;
import com.ista.tradizone.di.app.utils.Response;

@RestController
@RequestMapping("/platos")
public class PlatoController {


    @Autowired
    private PlatoService platoService;


    @PostMapping("/crear")
    public Response<Plato> crearPlato(@RequestBody Plato plato){
        return platoService.crearPlato(plato);
    }

    @GetMapping("/listar")
    public Response<Plato> getPlatos(){
        return platoService.getPlatos();
    }
}
