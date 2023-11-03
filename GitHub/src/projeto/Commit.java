package projeto;

public class Commit extends ItemControle{
	private Usuario autor;
	private String dtEnvio;
	
	public Commit(String nome, int id, String descricao, Usuario autor, String dtEnvio) {
		super(nome, id, descricao);
		this.autor = autor;
		this.dtEnvio = dtEnvio;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public String getDtEnvio() {
		return dtEnvio;
	}

	public void setDtEnvio(String dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	
	public String toString() {
		return "Autor: " + autor.getNome() + ", Data de Envio: " + dtEnvio;
	}
	
}
