package br.com.gam.biblioteca.dto;

public class EstoqueDTO {

	private String isbnLivro;
	private int quantidade;

	public EstoqueDTO() {
	}

	public EstoqueDTO(String isbnLivro, int quantidade) {
		this.isbnLivro = isbnLivro;
		this.quantidade = quantidade;
	}

	public String getIsbnLivro() {
		return isbnLivro;
	}

	public void setIsbnLivro(String isbnLivro) {
		this.isbnLivro = isbnLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
