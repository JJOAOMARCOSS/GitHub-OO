package projeto;

public class Repositorio {
	private String nome;
	private Usuario usuario;
	private String dtCriacao;
	private Commit[] listaCommits = new Commit[100];
	private Issue[] listaIssues = new Issue[100];
	private int numCommits;
	private int numIssues;
	
	public Repositorio(String nome, Usuario usuario, String dtCriacao) {
		this.nome = nome;
		this.usuario = usuario;
		this.dtCriacao = dtCriacao;
		numCommits = 0;
		numIssues = 0;
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

	public String getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(String dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Commit[] getListaCommits() {
		return listaCommits;
	}
	
	public void setArrayCommit(Commit c, int i) {
		this.listaCommits[i] = c;
	}
	
	public void setListaCommits(Commit[] listaCommits) {
		this.listaCommits = listaCommits;
	}
	
	public Commit getCommit(int i) {
		return listaCommits[i];
	}

	public Issue[] getListaIssues() {
		return listaIssues;
	}

	public void setArrayListaIssues(Issue[] listaIssues) {
		this.listaIssues = listaIssues;
	}

	public int getNumCommits() {
		return numCommits;
	}

	public void setNumCommits(int numCommits) {
		this.numCommits = numCommits;
	}

	public int getNumIssues() {
		return numIssues;
	}

	public void setNumIssues(int numIssues) {
		this.numIssues = numIssues;
	}
	
	public void setArrayIssue(Issue iss, int i) {
		this.listaIssues[i] = iss;
	}
	
	public Issue getIssue(int i) {
		return listaIssues[i];
	}
	
	public void setIssue(Issue iss, int i) {
		this.listaIssues[i] = iss;
	}
	
	public boolean addCommit(Commit c) {
		if(numCommits < 100) {
			listaCommits[numCommits] = c;
			numCommits++;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addIssue(Issue is) {
		if(numIssues < 100) {
			listaIssues[numIssues] = is;
			numIssues++;
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		
		return "Nome: " + nome + ", Usuario: " + usuario.getNome() + 
				", Data de Criação: " + dtCriacao;
	}
	
}
