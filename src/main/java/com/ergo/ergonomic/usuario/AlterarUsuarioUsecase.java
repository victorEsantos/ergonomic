package com.ergo.ergonomic.usuario;

import com.ergo.ergonomic.usuario.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

public interface AlterarUsuarioUsecase {
    Usuario alterarUsuario(AlterarUsuarioCommand command);

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    class AlterarUsuarioCommand {
        private UUID id;
        private String nome;
        private String email;
        private String documento;

    }

}
