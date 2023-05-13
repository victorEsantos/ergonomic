package com.ergo.ergonomic.usuario.app;

import com.ergo.ergonomic.usuario.CriarUsuarioUseCase;
import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.domain.UsuarioDomainRepository;
import com.ergo.ergonomic.usuario.domain.documento.DocumentoBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CriarUsuarioAppServiceCase implements CriarUsuarioUseCase {
    private final UsuarioDomainRepository usuarioRepository;

    @Override
    public Usuario execute(CriarUsuarioCommand command) {
        Usuario usuario = new Usuario(
                UUID.randomUUID(),
                command.getNome(),
                command.getEmail(),
                command.getSenha(),
                getDocumento(command.getDocumento()),
                command.getStatus()
        );

        return usuarioRepository.save(usuario);
    }

    private DocumentoBase getDocumento(String documento) {
        return new DocumentoBase(documento);
    }

}