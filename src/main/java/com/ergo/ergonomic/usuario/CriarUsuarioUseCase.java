package com.ergo.ergonomic.usuario;

import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.domain.documento.Documento;
import com.ergo.ergonomic.usuario.domain.enums.StatusUsuario;
import lombok.Value;

public interface CriarUsuarioUseCase {
    Usuario execute(CriarUsuarioCommand command);

    @Value
    class CriarUsuarioCommand {
        String nome;
        String email;
        String senha;
        Documento documento;
        StatusUsuario status;

    }
}