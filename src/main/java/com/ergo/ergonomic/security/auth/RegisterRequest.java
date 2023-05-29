package com.ergo.ergonomic.security.auth;

import com.ergo.ergonomic.usuario.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private Role role;
    private String cnpj;
    private String cpf;
}
