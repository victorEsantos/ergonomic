package com.ergo.ergonomic.usuario.api.dto;

import com.ergo.ergonomic.usuario.domain.enums.StatusUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {
    private UUID id;
    private String nome;
    private String email;
    private StatusUsuario status;
    private String documento;
}
