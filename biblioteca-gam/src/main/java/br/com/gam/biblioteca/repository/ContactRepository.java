package br.com.gam.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gam.biblioteca.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
