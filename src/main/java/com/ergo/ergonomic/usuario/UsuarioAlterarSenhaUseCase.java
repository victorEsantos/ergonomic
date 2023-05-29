package com.ergo.ergonomic.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface UsuarioAlterarSenhaUseCase {
    void alterarSenha(UsuarioAlterarSenhaCommand command);


    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    class UsuarioAlterarSenhaCommand {
        @JsonIgnore
        Integer id;
        String senhaAntiga;
        String novaSenha;
    }

}
