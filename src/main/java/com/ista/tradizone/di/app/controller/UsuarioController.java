package com.ista.tradizone.di.app.controller;

import com.ista.tradizone.di.app.model.Usuario;
import com.ista.tradizone.di.app.service.UsuarioService;
import com.ista.tradizone.di.app.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    /* Esta ruta es solo para fines de pruebas */
    @GetMapping("/usuarios")
    public Response<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }


    @GetMapping("/usuarios/{idUsuario}/{token}")
    public Response<Usuario> getUsuarioPorId(@PathVariable String idUsuario,@PathVariable String token){
        return usuarioService.getUsuarioPorId(idUsuario, token);
    }
}
