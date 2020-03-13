package br.com.gam.biblioteca.dao;

import br.com.gam.biblioteca.model.Usuario;
import br.com.gam.biblioteca.repository.UsuarioRepository;

public class UsuarioDAO {

	private UsuarioRepository repository;

	public UsuarioDAO() {
	}

	public UsuarioDAO(UsuarioRepository usuariorepository) {
		this.repository = usuariorepository;
	}

	public Usuario inserir(Usuario usuario) {

		try {
			repository.save(usuario);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;

	}

	public Usuario localizar(String nome) {
		return null;
	}
}
