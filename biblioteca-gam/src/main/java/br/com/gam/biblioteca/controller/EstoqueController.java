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

import br.com.gam.biblioteca.dao.EstoqueDAO;
import br.com.gam.biblioteca.dto.EstoqueDTO;
import br.com.gam.biblioteca.model.Estoque;
import br.com.gam.biblioteca.model.Livro;
import br.com.gam.biblioteca.repository.EstoqueRepository;
import br.com.gam.biblioteca.repository.LivroRepository;

/**
 * Classe de Controle de Usuários da Biblioteca
 */
@RestController
@RequestMapping({ "/biblioteca/estoque" })
public class EstoqueController {

	private EstoqueRepository repository;

	private LivroRepository livrorepository;

	EstoqueController(EstoqueRepository repository, LivroRepository livrorepository) {
		this.repository = repository;
		this.livrorepository = livrorepository;
	}

	//implementar, caso já exista livro cadastrado no estoqe, fazer update da quantidade.
	@PostMapping
	public ResponseEntity<?> cadastrarLivroEstoque(@RequestBody EstoqueDTO estoqueDTO) {

		String isbnLivro = estoqueDTO.getIsbnLivro();
		int quantidade = estoqueDTO.getQuantidade();
		ResponseEntity response = null;

		try {
			Livro livro = livrorepository.findById(isbnLivro).orElseThrow(RuntimeException::new);

			EstoqueDAO estoque = new EstoqueDAO(repository);
			estoque.inserir(livro, quantidade);
			response = ResponseEntity.ok().body("Livro cadastrado com sucesso!!");

		} catch (Exception e) {
			response = ResponseEntity.ok().body("Livro não cadastrado no sistema, por favor digite um ISBN válido!");
		}

		return response;
	}

	@GetMapping
	public List<Estoque> listarEstoque() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{idEstoque}" })
	public ResponseEntity cunsularLivroEstoqueId(@PathVariable long idEstoque) {
		return repository.findById(idEstoque).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping(path = { "/{idEstoque}" })
	public ResponseEntity<?> deletarLivroEstoque(@PathVariable long idEstoque) {
		return repository.findById(idEstoque).map(record -> {
			repository.deleteById(idEstoque);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
