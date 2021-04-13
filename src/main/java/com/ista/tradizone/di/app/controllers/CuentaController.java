package com.ista.tradizone.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ista.tradizone.di.app.models.Cuenta;
import com.ista.tradizone.di.app.services.CuentaService;
import com.ista.tradizone.di.app.utils.Response;


@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	@Autowired
    private CuentaService cuentaService;

    
    @PostMapping("/crear")
    public Response<Cuenta> crearCuenta(@RequestBody Cuenta cuenta){
        return cuentaService.crearCuenta(cuenta);
    }


    @GetMapping("/listar")
    public Response<Cuenta> getCuentas(){
        return cuentaService.getCuentas();
    }
}
