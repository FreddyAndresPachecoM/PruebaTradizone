package com.ista.tradizone.di.app.util;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Response <T>{

    private int codigoHttp;
    private String descripcion;
    private List<T> listResponse;
    private T objectResponse;

    public Response(int codigoHttp, String descripcion, List<T> listResponse){
        this.codigoHttp = codigoHttp;
        this.descripcion = descripcion;
        this.listResponse = listResponse;
    }

    public Response(int codigoHttp, String descripcion, T objectResponse){
        this.codigoHttp = codigoHttp;
        this.descripcion = descripcion;
        this.objectResponse = objectResponse;
    }
}
