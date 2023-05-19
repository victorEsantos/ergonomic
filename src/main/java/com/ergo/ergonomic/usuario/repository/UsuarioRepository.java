package com.ergo.ergonomic.usuario.repository;

import com.ergo.ergonomic.usuario.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;
import java.util.UUID;

public interface UsuarioRepository extends CrudRepository<Usuario, UUID> {
    Set<Usuario> findAll();
}
