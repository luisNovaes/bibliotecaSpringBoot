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

import br.com.gam.biblioteca.model.Categoria;
import br.com.gam.biblioteca.model.Usuario;
import br.com.gam.biblioteca.repository.CategoriaRepository;

/**
 * Classe de Controle de Usuários da Biblioteca
 */
@RestController
@RequestMapping({ "/biblioteca/categorias" })
public class CategoriaController {

	private CategoriaRepository repository;

	CategoriaController(CategoriaRepository categoriarepository) {
		this.repository = categoriarepository;
	}

	@PostMapping
	public void cadastrarCategoria(@RequestBody Categoria categoria) {
		repository.save(categoria);
	}

	@GetMapping
	public List<Categoria> listarcategorias() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{idCategoria}" })
	public ResponseEntity cunsulatCategoriaId(@PathVariable long idCategoria) {
		return repository.findById(idCategoria).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping(path = { "/{idCategoria}" })
	public ResponseEntity<?> deletarCategoria(@PathVariable long idCategoria) {
		return repository.findById(idCategoria).map(record -> {
			repository.deleteById(idCategoria);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
