package com.ergo.ergonomic.usuario.api;

import com.ergo.ergonomic.usuario.AlterarUsuarioUsecase;
import com.ergo.ergonomic.usuario.AlterarUsuarioUsecase.AlterarUsuarioCommand;
import com.ergo.ergonomic.usuario.CriarUsuarioUseCase;
import com.ergo.ergonomic.usuario.GetAllUsuarioUseCase;
import com.ergo.ergonomic.usuario.GetByIdUsuarioUseCase;
import com.ergo.ergonomic.usuario.UsuarioAlterarSenhaUseCase;
import com.ergo.ergonomic.usuario.UsuarioAlterarSenhaUseCase.UsuarioAlterarSenhaCommand;
import com.ergo.ergonomic.usuario.api.dto.UsuarioDto;
import com.ergo.ergonomic.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CriarUsuarioUseCase usuarioService;
    private final AlterarUsuarioUsecase alterarUsuario;
    private final UsuarioAlterarSenhaUseCase usuarioAlterarSenha;
    private final GetByIdUsuarioUseCase getByIdUsuarioUseCase;
    private final GetAllUsuarioUseCase getAllUsuarioUseCase;


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

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable UUID id) {
        var usuario = getByIdUsuarioUseCase.getById(id);
        UsuarioDto usuarioDto = new UsuarioDto();
        BeanUtils.copyProperties(usuario, usuarioDto);
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping()
    public ResponseEntity<Set<UsuarioDto>> getAll() {
        Set<Usuario> usuarios = getAllUsuarioUseCase.getAll();
        Set<UsuarioDto> usuarioDto = usuarios.stream().map(UsuarioDto::from).collect(Collectors.toSet());
        return ResponseEntity.ok(usuarioDto);
    }

}
