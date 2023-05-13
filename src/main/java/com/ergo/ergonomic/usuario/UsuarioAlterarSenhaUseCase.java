package com.ergo.ergonomic.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

public interface UsuarioAlterarSenhaUseCase {
    void alterarSenha(UsuarioAlterarSenhaCommand command);


    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    class UsuarioAlterarSenhaCommand {
        UUID id;
        String senhaAntiga;
        String novaSenha;
    }

}
