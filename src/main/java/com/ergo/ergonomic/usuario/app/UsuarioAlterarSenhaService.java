package com.ergo.ergonomic.usuario.app;

import com.ergo.ergonomic.usuario.UsuarioAlterarSenhaUseCase;
import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAlterarSenhaService implements UsuarioAlterarSenhaUseCase {

    private final UsuarioRepository usuarioRepository;

    public UsuarioAlterarSenhaService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void alterarSenha(UsuarioAlterarSenhaCommand command) {
        Usuario usuarioExistente = usuarioRepository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuarioExistente.alterarSenha(command.getSenhaAntiga(), command.getNovaSenha());

        usuarioRepository.save(usuarioExistente);
    }
}
