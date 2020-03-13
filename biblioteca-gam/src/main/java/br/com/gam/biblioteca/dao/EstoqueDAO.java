package br.com.gam.biblioteca.dao;

import org.springframework.http.ResponseEntity;

import br.com.gam.biblioteca.model.Estoque;
import br.com.gam.biblioteca.model.Livro;
import br.com.gam.biblioteca.repository.EstoqueRepository;

public class EstoqueDAO {

	private EstoqueRepository repository;

	public EstoqueDAO(EstoqueRepository repository) {
		this.repository = repository;
	}

	public ResponseEntity<?> inserir(Livro livro, int quantidade) {
		ResponseEntity response = null;
		Estoque estoque = new Estoque();

		try {
			estoque.setLivro(livro);
			estoque.setQuantidade(quantidade);
			repository.save(estoque);

		} catch (Exception e) {
			response = ResponseEntity.ok().body("Erro ao gravar dados no banco!");
		}

		return response;
	}

	public int buscarQuantidade(Livro livro) {
		return 0;

	}

	public boolean excluir(String isbn, int quantidade) {
		return false;

	}
}
