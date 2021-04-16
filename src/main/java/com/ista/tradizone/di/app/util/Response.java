package com.ista.tradizone.di.app.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response <T>{

    private int codigoHttp;
    private String descripcion;
    private List<T> cuerpo;
}
