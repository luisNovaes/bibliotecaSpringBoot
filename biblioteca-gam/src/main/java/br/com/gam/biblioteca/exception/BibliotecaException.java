package br.com.gam.biblioteca.exception;

public class BibliotecaException {

	private String erro;
	private String mensagem;

	public BibliotecaException() {
	}

	public BibliotecaException(String erro, String mensagem) {
		this.erro = erro;
		this.mensagem = mensagem;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "BibliotecaException [erro=" + erro + ", mensagem=" + mensagem + "]";
	}

}
