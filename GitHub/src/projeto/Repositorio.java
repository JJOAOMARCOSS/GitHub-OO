package projeto;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Repositorio {
	private String nome;
	private Usuario usuario;
	private Date dtCriacao;
	private ArrayList<Commit> listaCommits;
	private ArrayList<Issue> listaIssues;
	
	public Repositorio(String nome, Usuario usuario, Date dtCriacao) {
		this.nome = nome;
		this.usuario = usuario;
		this.dtCriacao = dtCriacao;
		listaCommits = new ArrayList<Commit>();
		listaIssues = new ArrayList<Issue>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public ArrayList<Commit> getListaCommits() {
		return listaCommits;
	}

	public void setListaCommits(ArrayList<Commit> listaCommits) {
		this.listaCommits = listaCommits;
	}

	public ArrayList<Issue> getListaIssues() {
		return listaIssues;
	}

	public void setListaIssues(ArrayList<Issue> listaIssues) {
		this.listaIssues = listaIssues;
	}
	
	//Adicionar Buscar Commit
	//Adcionar Buscar Issue
	
	@Override
	public String toString() {
		
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yy");
		
		return "Nome: " + nome + ", Usuario: " + usuario.getNome() + 
				", Data de Criação: " + data.format(dtCriacao) + 
				", Lista de Commits: " + listaCommits.size() + ", Lista de Issues: " + listaIssues.size();
	}
}
