package dados;

import projeto.*;

//A classe Dados representa o conjunto de dados do sistema.
public class Dados {
	
	// Atributos para armazenar arrays de usuários, repositórios, commits e issues.
	private Usuario[] usuarios;
	private int nUsuarios = 0;
	private Repositorio[] repositorios;
	private int nRepositorios = 0;
	private Commit[] commits;
	private int nCommits = 0;
	private Issue[] issues;
	private int nIssues = 0;


	// Construtor padrão que inicializa os arrays.
	public Dados() {
		usuarios = new Usuario[100];
		repositorios = new Repositorio[100];
		commits = new Commit[100];
		issues = new Issue[100];
	}

	// Métodos de acesso para obter os usuários.
	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public Usuario getUsuario(int i) {
		return usuarios[i];
	}

	public String[] getNomeUsuario() {
		String[] s = new String[nUsuarios];
		for(int i = 0; i < nUsuarios; i++) {
			s[i] = usuarios[i].getNome();
		}
		return s;
	}

	// Métodos de modificação para definir os usuários.
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}

	public void setUsuario(int i, Usuario u) {
		usuarios[i] = u;
	}

	public int getnUsuarios() {
		return nUsuarios;
	}
	public void setnUsuarios(int nUsuarios) {
		this.nUsuarios = nUsuarios;
	}
	
	// Métodos de acesso para obter os repositórios.
	
	public boolean removerRepositorio(Usuario usuario, String nomeRepositorio) {
        return usuario.removerRepositorio(nomeRepositorio);
	}
	
	public Repositorio[] getRepositorios() {
		return repositorios;
	}

	public Repositorio getRepositorio(int i) {
		return repositorios[i];
	}

	public String[] getNomeRepositorios() {
		String[] s = new String[nRepositorios];
		for(int i = 0; i < nRepositorios; i++) {
			s[i] = repositorios[i].getNome();
		}
		return s;
	}

	// Métodos de modificação para definir os repositórios.
	public void setRepositorios(Repositorio[] repositorios) {
		this.repositorios = repositorios;
	}

	public void setRepositorio(int i, Repositorio r) {
		repositorios[i] = r;
	}

	public int getnRepositorios() {
		return nRepositorios;
	}

	public void setnRepositorios(int nRepositorios) {
		this.nRepositorios = nRepositorios;
	}

	// Métodos de acesso para obter os commits.
	public Commit[] getCommits() {
		return commits;
	}

	public Commit getCommit(int i) {
		return commits[i];
	}

	public String[] getNomeCommits() {
		String[] s = new String[nCommits];
		for(int i = 0; i < nCommits; i++) {
			s[i] = commits[i].getNome();
		}
		return s;
	}

	// Métodos de modificação para definir os commits.
	public void setCommits(Commit[] commits) {
		this.commits = commits;
	}

	public void setCommit(int i, Commit c) {
		commits[i] = c;
	}

	public int getnCommits() {
		return nCommits;
	}

	public void setnCommits(int nCommits) {
		this.nCommits = nCommits;
	}

	// Métodos de acesso para obter as issues.
	public Issue[] getIssues() {
		return issues;
	}

	public Issue getIssue(int i) {
		return issues[i];
	}

	public String[] getNomeIssues() {
		String[] s = new String[nIssues];
		for(int i = 0; i < nIssues; i++) {
			s[i] = issues[i].getNome();
		}
		return s;
	}

	// Métodos de modificação para definir as issues.
	public void setIssues(Issue[] issues) {
		this.issues = issues;
	}

	public void setIssue(int i, Issue s) {
		issues[i] = s;
	}

	public int getnIssues() {
		return nIssues;
	}

	public void setnIssues(int nIssues) {
		this.nIssues = nIssues;
	}

	// Método para preencher os dados com exemplos.
	public void preencherDados() {
		for (int i = 0; i < 10; i++) {
	        String s = String.valueOf(i);
	        
	        usuarios[i] = new Usuario("Nome".concat(s), "email".concat(s), "senha".concat(s));

	        repositorios[i] = new Repositorio("Nome".concat(s), "Data de Criação".concat(s));

	        commits[i] = new Commit("Nome".concat(s), i, "Descricao".concat(s), "Data de Envio".concat(s));

	        issues[i] = new Issue("Nome".concat(s), i, "Descricao".concat(s), "Status".concat(s));
	        
	    }

	    nUsuarios = nCommits = nIssues = 10; // Atualize conforme a quantidade real de dados inseridos
	}
}
