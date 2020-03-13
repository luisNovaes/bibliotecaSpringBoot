package br.com.gam.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gam.biblioteca.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

}
