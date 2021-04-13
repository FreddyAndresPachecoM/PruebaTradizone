package com.ista.tradizone.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.tradizone.di.app.models.Usuario;
import com.ista.tradizone.di.app.services.UsuarioService;
import com.ista.tradizone.di.app.utils.Response;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/crear")
    public Response<Usuario> crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/listar")
    public Response<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }
}
