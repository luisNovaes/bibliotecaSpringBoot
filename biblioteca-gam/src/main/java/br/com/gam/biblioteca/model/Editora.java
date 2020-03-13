package br.com.gam.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEditora;

	private String nome;

	public Editora() {
	}

	public Editora(Long idEditora, String nome) {
		this.idEditora = idEditora;
		this.nome = nome;
	}

	public Long getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(Long idEditora) {
		this.idEditora = idEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Editora [idEditora=" + idEditora + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEditora == null) ? 0 : idEditora.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editora other = (Editora) obj;
		if (idEditora == null) {
			if (other.idEditora != null)
				return false;
		} else if (!idEditora.equals(other.idEditora))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
