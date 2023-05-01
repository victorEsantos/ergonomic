package com.ergo.ergonomic.usuario.api;

import com.ergo.ergonomic.usuario.CriarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CriarUsuarioUseCase usuarioService;

    @PostMapping()
    public ResponseEntity<String> criarUsuario(@RequestBody CriarUsuarioUseCase.CriarUsuarioCommand criarUsuarioCommand) {
        var usuario = usuarioService.execute(criarUsuarioCommand);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // outros métodos do controlador aqui
}
