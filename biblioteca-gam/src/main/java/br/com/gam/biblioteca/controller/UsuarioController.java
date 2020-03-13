package br.com.gam.biblioteca.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gam.biblioteca.model.Usuario;
import br.com.gam.biblioteca.repository.UsuarioRepository;

/**
 * Classe de Controle de Usuários da Biblioteca
 */
@RestController
@RequestMapping({ "/biblioteca/usuarios" })
public class UsuarioController {

	private UsuarioRepository repository;

	UsuarioController(UsuarioRepository usuariorepository) {
		this.repository = usuariorepository;
	}

	@PostMapping
	public void cadastrarUsuario(@RequestBody Usuario usuario) {
		repository.save(usuario);
	}

	@GetMapping
	public List<Usuario> listarUsuarios() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{cpf}" })
	public ResponseEntity cunsulatUsuarioId(@PathVariable String cpf) {
		return repository.findById(cpf).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping(path = { "/{cpf}" })
	public ResponseEntity<?> deletarUsuario(@PathVariable String cpf) {
		return repository.findById(cpf).map(record -> {
			repository.deleteById(cpf);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
