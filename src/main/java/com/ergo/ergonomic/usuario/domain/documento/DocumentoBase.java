package com.ergo.ergonomic.usuario.domain.documento;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class DocumentoBase implements Serializable {
    @Serial
    private static final long serialVersionUID = 1526922768449817567L;

    @NonNull
    protected String numeroDocumento;

    public DocumentoBase(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
        validarNumero();
    }

    private void validarNumero() {
        if(numeroDocumento.length() != 11 && numeroDocumento.length() != 14) {
            throw new IllegalArgumentException("Documento inválido");
        }
    }
}
