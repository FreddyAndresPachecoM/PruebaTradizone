package com.ista.tradizone.di.app.controller;

import com.ista.tradizone.di.app.model.Usuario;
import com.ista.tradizone.di.app.service.UsuarioService;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/usuarios")
    public Response<Usuario> crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.crearUsuario(usuario);
    }

    /* Esta ruta es solo para fines de pruebas */
    @GetMapping("/usuarios")
    public Response<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
}
