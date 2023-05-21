package com.ergo.ergonomic.usuario.api;

import com.ergo.ergonomic.usuario.AlterarUsuarioUsecase;
import com.ergo.ergonomic.usuario.AlterarUsuarioUsecase.AlterarUsuarioCommand;
import com.ergo.ergonomic.usuario.CriarUsuarioUseCase;
import com.ergo.ergonomic.usuario.GetAllUsuarioUseCase;
import com.ergo.ergonomic.usuario.GetByIdUsuarioUseCase;
import com.ergo.ergonomic.usuario.UsuarioAlterarSenhaUseCase;
import com.ergo.ergonomic.usuario.UsuarioAlterarSenhaUseCase.UsuarioAlterarSenhaCommand;
import com.ergo.ergonomic.usuario.api.dto.UsuarioDto;
import com.ergo.ergonomic.usuario.api.specification.UsuarioSpecifications;
import com.ergo.ergonomic.usuario.domain.Usuario;
import com.ergo.ergonomic.usuario.domain.enums.StatusUsuario;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<Page<UsuarioDto>> getAll(
            @ParameterObject UsuarioSpecifications spec,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Usuario> usuarios = getAllUsuarioUseCase.getAll(spec, pageable);
        List<UsuarioDto> usuarioDto = usuarios.stream().map(UsuarioDto::from).toList();
        return ResponseEntity.ok(new PageImpl<>(usuarioDto));
    }

}
