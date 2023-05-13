package com.ergo.ergonomic.usuario.domain.documento;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DocumentoBase {

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
