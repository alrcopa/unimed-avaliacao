package br.com.requeijo.backend.controller;

import br.com.requeijo.backend.model.Usuario;
import br.com.requeijo.backend.service.UsuarioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioServiceImpl service;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioServiceImpl service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Integer> salvar(@RequestBody Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return ResponseEntity.ok(service.salvar(usuario));
    }
}
