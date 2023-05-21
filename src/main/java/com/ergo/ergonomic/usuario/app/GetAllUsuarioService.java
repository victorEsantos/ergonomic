package com.ergo.ergonomic.usuario.app;

import com.ergo.ergonomic.usuario.GetAllUsuarioUseCase;
import com.ergo.ergonomic.usuario.api.specification.UsuarioSpecifications;
import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllUsuarioService implements GetAllUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> getAll(UsuarioSpecifications specification, Pageable pageable) {
        return usuarioRepository.findAll(specification.execute(), pageable);
    }



}
