package com.ista.tradizone.di.app.controller;

import com.ista.tradizone.di.app.model.Usuario;
import com.ista.tradizone.di.app.model.autenticacion.Sesion;
import com.ista.tradizone.di.app.service.autenticacion.AutenticacionService;
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
public class AutenticacionController {
    
    @Autowired
    private AutenticacionService autenticacionService;

    @PostMapping("/sesion/registro")
    public Response<Sesion> registrarUsuario(@RequestBody Usuario usuario){
        return autenticacionService.registrarUsuario(usuario);
    }


    @GetMapping("/sesion/login/{correo}/{contrasena}")
    public Response<Sesion> iniciarSesion(@PathVariable String correo, @PathVariable String contrasena){
        return autenticacionService.iniciarSesion(correo, contrasena);
    }

    @GetMapping("/sesion/logout/{idUsuario}")
    public Response<Sesion> cerrarSesion(@PathVariable String idUsuario){
        return autenticacionService.cerrarSesion(idUsuario);
    }
}
