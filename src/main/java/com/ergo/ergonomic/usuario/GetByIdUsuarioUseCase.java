package com.ergo.ergonomic.usuario;

import com.ergo.ergonomic.usuario.domain.Usuario;

public interface GetByIdUsuarioUseCase {
    Usuario getById(Integer id);
}
