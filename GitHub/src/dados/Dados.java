package dados;

import projeto.*;

public class Dados {
	private Usuario[] usuarios;
	private int nUsuarios = 0;
	private Repositorio[] repositorios;
	private int nRepositorios = 0;
	private Projeto[] projetos;
	private int nProjetos = 0;
	private Commit[] commits;
	private int nCommits = 0;
	private Issue[] issues;
	private int nIssues = 0;
	private ItemControle[] itensControles; 
	private int nItensControles = 0;
	
	public Dados() {
		usuarios = new Usuario[100];
		repositorios = new Repositorio[100];
		projetos = new Projeto[100];
		commits = new Commit[100];
		issues = new Issue[100];
		itensControles = new ItemControle[100];
		
		
	}

	// Usuario
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

	// Repositorio
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

	// Projeto
	public Projeto[] getProjetos() {
		return projetos;
	}

	public Projeto getProjeto(int i) {
		return projetos[i];
	}

	public String[] getNomeProjetos() {
		String[] s = new String[nProjetos];
		for(int i = 0; i < nProjetos; i++) {
			s[i] = projetos[i].getNome();
		}
		return s;
	}

	public void setProjetos(Projeto[] projetos) {
		this.projetos = projetos;
	}

	public void setProjeto(int i, Projeto p) {
		projetos[i] = p;
	}

	public int getnProjetos() {
		return nProjetos;
	}

	public void setnProjetos(int nProjetos) {
		this.nProjetos = nProjetos;
	}

	//ItemControle
	
	public ItemControle[] getItensControles() {
		return itensControles;
	}

	public ItemControle getItensControles(int i) {
		return itensControles[i];
	}

	public String[] getNomeItensControles() {
		String[] s = new String[nItensControles];
		for(int i = 0; i < nItensControles; i++) {
			s[i] = itensControles[i].getNome();
		}
		return s;
	}

	public void setItensControles(ItemControle[] itensControles) {
		this.itensControles = itensControles;
	}

	public void setItensControles(int i, ItemControle c) {
		itensControles[i] = c;
	}

	public int getnItensControles() {
		return nItensControles;
	}

	public void setnItensControles(int nItensControles) {
		this.nItensControles = nItensControles;
	}
	
	// Commit
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

	// Issue
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
	
	public void preencherDados() {
		for(int i = 0; i < 10; i++) {
			String s = String.valueOf(i);
			usuarios[i] = new Usuario("Nome".concat(s), "email".concat(s), "senha".concat(s));
			projetos[i] = new Projeto("Nome".concat(s));
			repositorios[i] = new Repositorio("Nome".concat(s), "Data de Criação".concat(s));
			commits[i] = new Commit("Nome".concat(s), i, "Descricao".concat(s), "Data de Envio".concat(s));
			issues[i] = new Issue("Nome".concat(s), i, "Descricao".concat(s), "Status".concat(s));
		}
		nUsuarios = nProjetos = nRepositorios = nCommits = nIssues = 10;
	}
}
