package br.com.gam.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gam.biblioteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {

}
