package br.com.gam.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gam.biblioteca.model.Emprestimo;
import br.com.gam.biblioteca.model.EmprestimoID;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, EmprestimoID> {

}
