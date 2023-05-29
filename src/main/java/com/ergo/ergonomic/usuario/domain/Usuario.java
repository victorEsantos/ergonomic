package com.ergo.ergonomic.usuario.domain;

import com.ergo.ergonomic.usuario.token.Token;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario implements UserDetails {

  @Id
  @GeneratedValue
  private Integer id;
  private String nome;
  private String email;
  private String password;
  private String cnpj;
  private String cpf;

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "usuario")
  @ToString.Exclude
  private List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public void alterar(String nome, String email, String cnpj, String cpf) {
    this.nome = nome;
    this.email = email;
    this.cnpj = cnpj;
    this.cpf = cpf;
  }

  public void alterarSenha(String novaSenha) {
    this.password = novaSenha;
  }
}
