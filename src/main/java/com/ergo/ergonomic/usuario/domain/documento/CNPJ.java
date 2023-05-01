package com.ergo.ergonomic.usuario.domain.documento;

import com.ergo.ergonomic.usuario.domain.documento.Documento;

public class CNPJ extends Documento {
    public CNPJ(String numero) {
        super(numero);
    }

    @Override
    public boolean isValid() {
        return super.numero != null && super.numero.length() == 14;
    }


}