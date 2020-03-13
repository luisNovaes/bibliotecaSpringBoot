package br.com.gam.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gam.biblioteca.model.Categoria;
import br.com.gam.biblioteca.model.Usuario;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
