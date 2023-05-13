package com.ergo.ergonomic.usuario.api;

import com.ergo.ergonomic.usuario.AlterarUsuarioUsecase;
import com.ergo.ergonomic.usuario.AlterarUsuarioUsecase.AlterarUsuarioCommand;
import com.ergo.ergonomic.usuario.CriarUsuarioUseCase;
import com.ergo.ergonomic.usuario.UsuarioAlterarSenhaUseCase;
import com.ergo.ergonomic.usuario.UsuarioAlterarSenhaUseCase.UsuarioAlterarSenhaCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CriarUsuarioUseCase usuarioService;
    private final AlterarUsuarioUsecase alterarUsuario;
    private final UsuarioAlterarSenhaUseCase usuarioAlterarSenha;


    @PostMapping()
    public ResponseEntity<String> criarUsuario(@RequestBody CriarUsuarioUseCase.CriarUsuarioCommand criarUsuarioCommand) {
        var usuario = usuarioService.execute(criarUsuarioCommand);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterarUsuario(@PathVariable UUID id, @RequestBody AlterarUsuarioCommand command) {

        command.setId(id);

        alterarUsuario.alterarUsuario(command);

        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}/alterarSenha")
    public ResponseEntity<Void> alterarSenha(@PathVariable UUID id, @RequestBody UsuarioAlterarSenhaCommand command) {

        command.setId(id);

        usuarioAlterarSenha.alterarSenha(command);

        return ResponseEntity.ok().build();
    }

}
