package com.ergo.ergonomic.usuario.app;

import com.ergo.ergonomic.usuario.GetByIdUsuarioUseCase;
import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class GetByIdUsuarioService implements GetByIdUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public GetByIdUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }
}
