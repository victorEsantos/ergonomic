package com.ergo.ergonomic.usuario.domain;

import com.ergo.ergonomic.usuario.domain.documento.DocumentoBase;
import com.ergo.ergonomic.usuario.domain.enums.StatusUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
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

}
