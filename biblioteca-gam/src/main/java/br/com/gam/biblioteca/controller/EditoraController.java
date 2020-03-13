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

import br.com.gam.biblioteca.model.Editora;
import br.com.gam.biblioteca.model.Usuario;
import br.com.gam.biblioteca.repository.EditoraRepository;

/**
 * Classe de Controle de Usuários da Biblioteca
 */
@RestController
@RequestMapping({ "/biblioteca/editoras" })
public class EditoraController {

	private EditoraRepository repository;

	EditoraController(EditoraRepository editorarepository) {
		this.repository = editorarepository;
	}

	@PostMapping
	public void cadastrarEditora(@RequestBody Editora editora) {
		repository.save(editora);
	}

	@GetMapping
	public List<Editora> listarEditoras() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{idEditora}" })
	public ResponseEntity cunsulatEditoraId(@PathVariable long idEditora) {
		return repository.findById(idEditora).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping(path = { "/{idEditora}" })
	public ResponseEntity<?> deletarEditora(@PathVariable long idEditora) {
		return repository.findById(idEditora).map(record -> {
			repository.deleteById(idEditora);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
