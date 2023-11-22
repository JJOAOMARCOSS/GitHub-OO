package projeto;

public class Repositorio {
	private String nome;
	private String dtCriacao;

	public Repositorio(String nome, String dtCriacao) {
		this.nome = nome;
		this.dtCriacao = dtCriacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(String dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String toString() {
		return "Nome: " + nome + ", Data de criacao: " + dtCriacao;
	}
}
	