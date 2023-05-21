package com.ergo.ergonomic.usuario.api.specification;

import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.domain.enums.StatusUsuario;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioSpecifications {

    @Schema(description = "Nome do usuário")
    private String nome;

    @Schema(description = "Email do usuário")
    private String email;

    @Schema(description = "Status do usuário")
    private StatusUsuario status;


    public Specification<Usuario> execute() {
        Specification<Usuario> spec = Specification.where(null);

        if (nome != null && !nome.isEmpty()) {
            spec = spec.and(UsuarioSpecifications.porNome(nome));
        }

        if (email != null && !email.isEmpty()) {
            spec = spec.and(UsuarioSpecifications.porEmail(email));
        }

        if (status != null) {
            spec = spec.and(UsuarioSpecifications.porStatus(status));
        }

        return spec;
    }


    private static Specification<Usuario> porNome(String nome) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    private static Specification<Usuario> porEmail(String email) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }

    private static Specification<Usuario> porStatus(StatusUsuario status) {
        return (root, query, builder) -> builder.equal(root.get("status"), status);
    }
}