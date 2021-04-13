package com.ista.tradizone.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.tradizone.di.app.models.Local;
import com.ista.tradizone.di.app.services.LocalService;
import com.ista.tradizone.di.app.utils.Response;


@RestController
@RequestMapping("/locales")
public class LocalController {

	@Autowired
    private LocalService localService;


    @PostMapping("/crear")
    public Response<Local> crearLocal(@RequestBody Local local){
        return localService.crearLocal(local);
    }

    @GetMapping("/listar")
    public Response<Local> getLocales(){
        return localService.getLocales();
    }
}
