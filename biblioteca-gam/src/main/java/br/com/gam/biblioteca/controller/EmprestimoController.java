package br.com.gam.biblioteca.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gam.biblioteca.dto.EmprestimoDTO;
import br.com.gam.biblioteca.model.Emprestimo;
import br.com.gam.biblioteca.model.EmprestimoID;
import br.com.gam.biblioteca.repository.EmprestimoRepository;

/**
 * Classe de Controle de Usuários da Biblioteca
 */
@RestController
@RequestMapping({ "/biblioteca/emprestimo" })
public class EmprestimoController {

	private EmprestimoRepository repository;

	EmprestimoController(EmprestimoRepository emprestimoRepository) {
		this.repository = emprestimoRepository;
	}

	@PostMapping
	public void EmprestarLivro(@RequestBody EmprestimoDTO emprestimoDTO) {
		
		EmprestimoID isbnLivro = emprestimoDTO.getEmprestimoID(); //como? emprestimoID?
		Date dataEmprestimmo = emprestimoDTO.getDtEmprestimo(); //data artual
		Date dataDevolucao = emprestimoDTO.getDtDevolucao(); // pegar data de 15 dias após data emprestimo
		
		
		ResponseEntity response = null;
		
		
		repository.save(emprestimo);
	}

	@GetMapping
	public List<Emprestimo> listarEmprestimo() {
		return repository.findAll();
	}
	
	@GetMapping(path = { "/{id}" })
	public ResponseEntity cunsulatEmprestimoId(@PathVariable EmprestimoID id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}

	@DeleteMapping(path = { "/{id}" }) // devolver livro
	public ResponseEntity<?> deletarEmprestimo(@PathVariable EmprestimoID id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
