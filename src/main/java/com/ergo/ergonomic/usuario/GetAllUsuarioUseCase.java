package com.ergo.ergonomic.usuario;

import com.ergo.ergonomic.usuario.api.specification.UsuarioSpecifications;
import com.ergo.ergonomic.usuario.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllUsuarioUseCase {
    public Page<Usuario> getAll(UsuarioSpecifications specification, Pageable pageable);
}
