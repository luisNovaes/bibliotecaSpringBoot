package br.com.casadocodigo.livraria.testes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.casadocodigo.livraria.Autor;
import br.com.casadocodigo.livraria.produtos.Livro;
import br.com.casadocodigo.livraria.produtos.LivroFisico;
import br.com.casadocodigo.livraria.testes.NovidadesDoJava8;

public class NovidadesDoJava8 {

	public static void main(String[] args) {

		Autor autor = new Autor();
		autor.setNome("Rodrigo Turini");

		Livro javaoo = new LivroFisico(autor);
		javaoo.setNome("Java OO");

		Livro java8 = new LivroFisico(autor);
		java8.setNome("Java 8 Prático");

		Livro ruby = new LivroFisico(autor);
		ruby.setNome("Livro de Ruby");

		List<Livro> livros = Arrays.asList(javaoo, java8, ruby);

		Collections.sort(livros, new ComparadorPorNome());

		for (Livro livro : livros) {
			System.out.println(livro.getNome());
		}
	}

}
