package com.ista.tradizone.di.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.tradizone.di.app.models.Cuenta;
import com.ista.tradizone.di.app.repositories.CuentaRepository;
import com.ista.tradizone.di.app.utils.Response;

@Service
public class CuentaService {

	@Autowired
    private CuentaRepository cuentaRepository;


    public Response<Cuenta> crearCuenta(Cuenta cuenta){
        cuentaRepository.insert(cuenta);
        return new Response<>(201, "Recurso creado exitosamente!", null);
    }

    public Response<Cuenta> getCuentas(){
        return new Response<>(200, "Ok!", cuentaRepository.findAll());
    }
}
