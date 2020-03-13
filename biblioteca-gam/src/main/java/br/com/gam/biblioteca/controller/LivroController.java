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

import br.com.gam.biblioteca.model.Livro;
import br.com.gam.biblioteca.model.Usuario;
import br.com.gam.biblioteca.repository.LivroRepository;

/**
 * Classe de Controle de Usuários da Biblioteca
 */
@RestController
@RequestMapping({ "/biblioteca/livros" })
public class LivroController {

	private LivroRepository repository;

	LivroController(LivroRepository livrorepository) {
		this.repository = livrorepository;
	}

	//implementar casoja exista um livro com isbn informado, exibir mensagem para usuario. 
	@PostMapping
	public void cadastrarLivro(@RequestBody Livro livro) {
		repository.save(livro);
	}

	@GetMapping
	public List<Livro> listarLivros() {
		return repository.findAll();
	}
	
	@GetMapping(path = { "/{isbn}" })
	public ResponseEntity cunsulatLivroId(@PathVariable String isbn) {
		return repository.findById(isbn).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}

	@DeleteMapping(path = { "/{isbn}" })
	public ResponseEntity<?> deletarLivro(@PathVariable String isbn) {
		return repository.findById(isbn).map(record -> {
			repository.deleteById(isbn);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
