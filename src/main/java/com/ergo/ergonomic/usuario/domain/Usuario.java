package com.ergo.ergonomic.usuario.domain;

import com.ergo.ergonomic.sk.domainentity.DomainEntity;
import com.ergo.ergonomic.usuario.domain.documento.DocumentoBase;
import com.ergo.ergonomic.usuario.domain.enums.StatusUsuario;
import com.ergo.ergonomic.utils.Crypto;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Usuario extends DomainEntity {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Embedded
    private DocumentoBase documento;

    @Enumerated(EnumType.STRING)
    private StatusUsuario status = StatusUsuario.INATIVO;

    public Usuario(UUID id, String nome, String email, String senha, DocumentoBase documento, StatusUsuario status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = Crypto.encrypt(senha);
        this.documento = documento;
        this.status = status;
    }

    public void alterar(String nome, String email, String documento) {
        this.nome = nome;
        this.email = email;
        this.documento = new DocumentoBase(documento);
    }

    public void alterarSenha(String senhaAntiga, String novaSenha) {
        if (!Crypto.checkPassword(senhaAntiga, this.senha)) {
            throw new IllegalArgumentException("Senha antiga inválida");
        }

        this.senha = Crypto.encrypt(novaSenha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Usuario usuario = (Usuario) o;

        if (!Objects.equals(id, usuario.id)) return false;
        if (!Objects.equals(nome, usuario.nome)) return false;
        if (!Objects.equals(email, usuario.email)) return false;
        if (!Objects.equals(senha, usuario.senha)) return false;
        if (!Objects.equals(documento, usuario.documento)) return false;
        return status == usuario.status;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (documento != null ? documento.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
