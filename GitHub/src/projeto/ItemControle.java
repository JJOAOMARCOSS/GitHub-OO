package projeto;

public abstract class ItemControle {
	protected String nome;
	protected int id;
	protected String descricao;
	protected Commit[] listaCommits = new Commit[100];
	protected Issue[] listaIssues = new Issue[100];
	protected int numCommits;
	protected int numIssues;

	public ItemControle(String nome, int id, String descricao) {
		this.nome = nome;
		this.id = id;
		this.descricao = descricao;
		numCommits = 0;
		numIssues = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
    public Commit buscaCommit(String nomeCommit) {
		Commit saida = null;
		for(int i = 0; i < numCommits; i++) {
			if(saida.getNome().compareToIgnoreCase(nomeCommit) == 0) {
				saida = listaCommits[i];
		}
	}
		return saida;
	}
    
    public Issue buscaIssue(String nomeIssue) {
		Issue saida = null;
		for(int i = 0; i < numIssues; i++) {
			if(saida.getNome().compareToIgnoreCase(nomeIssue) == 0) {
				saida = listaIssues[i];
		}
	}
		return saida;
	}
    
	public String toString() {
		return "Nome: " + nome + ", ID: " + id + ", Descrição: " + descricao;
	}

}
