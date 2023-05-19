package com.ergo.ergonomic.usuario;

import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.domain.enums.StatusUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface GetAllUsuarioUseCase {
    Page<Usuario> getAll(String nome, String email, StatusUsuario status, Pageable pageable);


    class UsuarioSpecifications {

        public static Specification<Usuario> porNome(String nome) {
            return (root, query, builder) -> builder.like(builder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        }

        public static Specification<Usuario> porEmail(String email) {
            return (root, query, builder) -> builder.like(builder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
        }

        public static Specification<Usuario> porStatus(StatusUsuario status) {
            return (root, query, builder) -> builder.equal(root.get("status"), status);
        }
    }


}
