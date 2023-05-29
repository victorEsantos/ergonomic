package com.ergo.ergonomic.usuario.api.dto;

import com.ergo.ergonomic.usuario.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {
    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private String cnpj;

    public static UsuarioDto from(Usuario usuario) {
        return new UsuarioDto(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getCnpj());
    }
}
