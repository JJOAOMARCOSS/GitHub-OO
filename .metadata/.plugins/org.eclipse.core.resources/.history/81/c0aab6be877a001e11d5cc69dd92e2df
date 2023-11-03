package projeto;

import java.util.Date;

public class Commit extends ItemControle{
	private Usuario autor;
	private Date dtEnvio;
	
	public Commit(String nome, int id, String descricao, Usuario autor, Date dtEnvio) {
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

	public Date getDtEnvio() {
		return dtEnvio;
	}

	public void setDtEnvio(Date dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	@Override
	public String toString() {
		return "Autor: " + autor.getNome() + ", Data de Envio: " + dtEnvio;
	}
	
}
