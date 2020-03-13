package br.com.gam.biblioteca.dto;

import java.util.Date;

import br.com.gam.biblioteca.model.EmprestimoID;

public class EmprestimoDTO {

	private EmprestimoID emprestimoID;
	private Date dtEmprestimo;
	private Date dtDevolucao;
	
	public EmprestimoDTO() {
		
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
