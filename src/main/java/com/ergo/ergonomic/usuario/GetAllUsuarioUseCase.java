package com.ergo.ergonomic.usuario;

import com.ergo.ergonomic.usuario.domain.Usuario;

import java.util.Set;

public interface GetAllUsuarioUseCase {
    Set<Usuario> getAll();

}
