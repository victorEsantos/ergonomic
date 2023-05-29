package com.ergo.ergonomic.usuario.app;

import com.ergo.ergonomic.usuario.AlterarUsuarioUsecase;
import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AlterarUsuarioService implements AlterarUsuarioUsecase {

    private final UsuarioRepository usuarioRepository;

    public AlterarUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario alterarUsuario(AlterarUsuarioCommand cmd) {
        Usuario usuarioExistente = usuarioRepository.findById(cmd.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuarioExistente.alterar(cmd.getNome(), cmd.getEmail(), cmd.getCnpj(), cmd.getCpf());

        return usuarioRepository.save(usuarioExistente);
    }
}
