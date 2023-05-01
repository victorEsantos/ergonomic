package com.ergo.ergonomic.usuario.domain.documento;

import com.ergo.ergonomic.usuario.domain.documento.Documento;

public class CPF extends Documento {
    public CPF(String numero) {
        super(numero);
    }

    @Override
    public boolean isValid() {
        // implemente a validação de CPF aqui
        return super.numero != null && super.numero.length() == 11;
    }
}
