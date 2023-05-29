package com.ergo.ergonomic.usuario.app;

import com.ergo.ergonomic.usuario.UsuarioAlterarSenhaUseCase;
import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioAlterarSenhaService implements UsuarioAlterarSenhaUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void alterarSenha(UsuarioAlterarSenhaCommand command) {
        Usuario usuarioExistente = usuarioRepository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if(!passwordEncoder.matches(command.getSenhaAntiga(), usuarioExistente.getPassword()))
            throw new IllegalArgumentException("Senha atual inválida");

        usuarioExistente.alterarSenha(command.getNovaSenha());

        usuarioRepository.save(usuarioExistente);
    }
}
