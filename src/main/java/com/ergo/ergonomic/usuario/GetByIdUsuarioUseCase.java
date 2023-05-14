package com.ergo.ergonomic.usuario;

import com.ergo.ergonomic.usuario.domain.Usuario;

import java.util.UUID;

public interface GetByIdUsuarioUseCase {
    Usuario getById(UUID id);
}
