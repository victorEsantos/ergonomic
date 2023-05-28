package com.ergo.ergonomic.usuario.repository;

import com.ergo.ergonomic.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UsuarioRepository extends CrudRepository<Usuario, UUID>, JpaSpecificationExecutor<Usuario> {
    Set<Usuario> findAll();

    Optional<Usuario> findByEmail(String email);
}
