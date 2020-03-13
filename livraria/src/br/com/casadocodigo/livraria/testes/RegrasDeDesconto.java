package br.com.casadocodigo.livraria.testes;

import br.com.casadocodigo.livraria.Autor;
import br.com.casadocodigo.livraria.produtos.Ebook;
import br.com.casadocodigo.livraria.produtos.Livro;
import br.com.casadocodigo.livraria.produtos.MiniLivro;

public class RegrasDeDesconto {

	public static void main(String[] args) {

		Autor autor = new Autor();
		autor.setNome("Rodrigo Turini");

		Livro livro = new MiniLivro(autor);
		livro.setValor(39.90);

		if (!livro.aplicaDescontoDe(0.3)) {
			System.out.println("Desconto do livro não pode ser maior do que 30%");
		} else {
			System.out.println("Valor do livro com desconto: " + livro.getValor());
		}

		Ebook ebook = new Ebook(autor);
		ebook.setValor(29.90);

		if (!ebook.aplicaDescontoDe(0.15)) {
			System.out.println("Desconto no ebook não pode ser maior do que 15%");
		} else {
			System.out.println("Valor do ebook com desconto: " + ebook.getValor());

		}

	}

}
