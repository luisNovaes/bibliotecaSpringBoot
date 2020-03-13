package br.com.gam.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	private String cpfUsuario;
	private String nome;
	private String email;
	private String phone;

	@OneToMany
	private List<Emprestimo> emprestimoItems = new ArrayList<Emprestimo>();

	public Usuario() {
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Emprestimo> getEmprestimoItems() {
		return emprestimoItems;
	}

	public void setEmprestimoItems(List<Emprestimo> emprestimoItems) {
		this.emprestimoItems = emprestimoItems;
	}

	@Override
	public String toString() {
		return "Usuario [cpfUsuario=" + cpfUsuario + ", nome=" + nome + ", email=" + email + ", phone=" + phone
				+ ", emprestimoItems=" + emprestimoItems + "]";
	}

}
