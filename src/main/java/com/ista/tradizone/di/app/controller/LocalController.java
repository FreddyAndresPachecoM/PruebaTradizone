package com.ista.tradizone.di.app.controller;

import com.ista.tradizone.di.app.model.Local;
import com.ista.tradizone.di.app.service.LocalService;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@CrossOrigin("*")
public class LocalController {
    
    @Autowired
    private LocalService localService;


    @PostMapping("/sucursales/{idRestaurante}")
    public Response<Local> crearSucursal(@RequestBody Local local, @PathVariable String idRestaurante){
        return localService.crearLocal(local, idRestaurante);
    }

    @GetMapping("/sucursales/{idRestaurante}")
    public Response<Local> getLocalesPorRestaurante(@PathVariable String idRestaurante){
        return localService.getLocalesPorRestaurante(idRestaurante);
    }


    @GetMapping("/sucursal/{idRestaurante}")
    public Response<Local> getLocalPorId(@PathVariable String idLocal){
        return localService.getLocalPorId(idLocal);
    }
}
