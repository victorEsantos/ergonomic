package com.ergo.ergonomic.usuario.domain;

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

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Usuario {
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
}
