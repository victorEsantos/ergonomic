package com.ergo.ergonomic.usuario.domain.documento;

public abstract class Documento {
    protected String numero;

    public Documento(String numero) {
        this.numero = numero;
    }

    public abstract boolean isValid();
}
