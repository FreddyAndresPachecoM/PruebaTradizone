package com.ista.tradizone.di.app.controller;

import com.ista.tradizone.di.app.model.Usuario;
import com.ista.tradizone.di.app.service.UsuarioService;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/app")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/usuarios")
    public Response<Usuario> crearUsuario(@RequestBody Usuario usuario, @PathVariable MultipartFile avatarUsuario){
        return usuarioService.crearUsuario(usuario, avatarUsuario);
    }
}
