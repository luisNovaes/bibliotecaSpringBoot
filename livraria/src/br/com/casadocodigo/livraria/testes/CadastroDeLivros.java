package br.com.casadocodigo.livraria.testes;

import br.com.casadocodigo.livraria.Autor;
import br.com.casadocodigo.livraria.produtos.Livro;
import br.com.casadocodigo.livraria.produtos.LivroFisico;

public class CadastroDeLivros {

	public static void main(String[] args) {

		Autor autor = new Autor();
		autor.setNome("Rodrigo Turine");
		autor.setEmail("rodrigo.turine@caelum.com.br");
		autor.setCpf("123.456.798.10");

		Livro livro = new LivroFisico(autor);
		livro.setNome("Java 8 Pr�tico");
		livro.setDescricao("Novos recursos da linguagem");
		livro.setValor(59.90);
		livro.setIsbn("978-85-66250-46-6");

		livro.mostrarDetalhes();

		Autor outroAutor = new Autor();
		outroAutor.setNome("Paulo Silveira");
		outroAutor.setEmail("paulo.silveira@caelum.com.br");
		outroAutor.setCpf("123.456.798.10");

		Livro outroLivro = new LivroFisico(outroAutor);
		outroLivro.setNome("L�gica de Programa��o");
		outroLivro.setDescricao("Crie seus primeiros programas");
		outroLivro.setValor(59.90);
		outroLivro.setIsbn("978-85-66250-22-0");

		outroLivro.mostrarDetalhes();

	}

}