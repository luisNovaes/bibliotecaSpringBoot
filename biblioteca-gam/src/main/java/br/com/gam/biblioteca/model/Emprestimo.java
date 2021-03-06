package br.com.gam.biblioteca.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {

	// passar o isbn do livro, o usuario e as dadtas, para desamarrar

	@EmbeddedId
	private EmprestimoID emprestimoID;

	@Temporal(value = TemporalType.DATE)
	private Date dtEmprestimo;

	@Temporal(value = TemporalType.DATE)
	private Date dtDevolucao;

	public Emprestimo() {
	}

	public EmprestimoID getEmprestimoID() {
		return emprestimoID;
	}

	public void setEmprestimoID(EmprestimoID emprestimoID) {
		this.emprestimoID = emprestimoID;
	}

	public Date getDtEmprestimo() {
		return dtEmprestimo;
	}

	public void setDtEmprestimo(Date dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}

	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(Date dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

}
