package com.ergo.ergonomic.usuario.app;

import com.ergo.ergonomic.usuario.GetAllUsuarioUseCase;
import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class GetAllUsuarioService implements GetAllUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Set<Usuario> getAll() {
        return usuarioRepository.findAll();
    }
}
