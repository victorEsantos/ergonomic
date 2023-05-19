package com.ergo.ergonomic.usuario.app;

import com.ergo.ergonomic.usuario.GetAllUsuarioUseCase;
import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.domain.enums.StatusUsuario;
import com.ergo.ergonomic.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllUsuarioService implements GetAllUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> getAll(String nome, String email, StatusUsuario status, Pageable pageable) {
        Specification<Usuario> spec = Specification.where(null);

        if (nome != null && !nome.isEmpty()) {
            spec = spec.and(GetAllUsuarioUseCase.UsuarioSpecifications.porNome(nome));
        }

        if (email != null && !email.isEmpty()) {
            spec = spec.and(GetAllUsuarioUseCase.UsuarioSpecifications.porEmail(email));
        }

        if(status != null){
            spec = spec.and(GetAllUsuarioUseCase.UsuarioSpecifications.porStatus(status));
        }

        return usuarioRepository.findAll(spec, pageable);
    }



}
