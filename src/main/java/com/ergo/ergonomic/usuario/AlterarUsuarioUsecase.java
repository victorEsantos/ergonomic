package com.ergo.ergonomic.usuario;

import com.ergo.ergonomic.usuario.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface AlterarUsuarioUsecase {
    Usuario alterarUsuario(AlterarUsuarioCommand command);

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    class AlterarUsuarioCommand {

        @JsonIgnore
        private Integer id;
        private String nome;
        private String email;
        private String cnpj;
        private String cpf;

    }

}
