package br.com.alura.codechella.controller;

import br.com.alura.codechella.model.Usuario;
import br.com.alura.codechella.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriBuilder) {
		var usuarioCadastrado = service.cadastrarUsuario(usuario);
		var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		
		
		return ResponseEntity.created(uri).body(usuarioCadastrado);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.ok(service.listarTodos());
	}
	
}
