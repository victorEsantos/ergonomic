package com.ergo.ergonomic.usuario.domain;

import com.ergo.ergonomic.usuario.domain.enums.Papel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Papeis {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Papel papel;
}
