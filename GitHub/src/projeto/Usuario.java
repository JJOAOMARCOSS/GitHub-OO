package projeto;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private Projeto[] listaProjetos = new Projeto [100];
	private int numProjetos;
	
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		numProjetos = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Projeto[] getListaProjetos() {
		return this.listaProjetos;
	}

	public void setArrayListaProjetos(Projeto[] p) {
		this.listaProjetos = p;
	}
	
	public Projeto getProjeto(int i) {
		return listaProjetos[i];//.getProjeto()
	}
	
	public void setProjeto(Projeto projs, int i) {
		this.listaProjetos[i] = projs;
	}

	public int getNumProjetos() {
		return numProjetos;
	}

	public void setNumProjetos(int numProjetos) {
		this.numProjetos = numProjetos;
	}
	
	public String toString() {
		return "Usuario: " + nome + ", Email: " + email + ", Senha: " + senha;
	}
	
	public boolean addprojeto(Projeto p) {
		if(numProjetos < 100) {
			listaProjetos[numProjetos] = p;
			numProjetos++;
			return true;
		} else {
			return false;
		}
	}
	
	/*
	public String buscarProjeto() {
        String nome =  "Nome do Projeto:\n ";
        for(int i = 0; i < numProjetos; i++) {
        System.out.println(i);
            nome = nome + "\n" + listaProjetos[i].getProjeto().toString(); //resolver o problema do getRepositorio
        }

        return nome; 
    }*/
	
	public Projeto buscarProjeto(String nomeProjeto) {
	    for (int i = 0; i < numProjetos; i++) {
	        Projeto projeto = listaProjetos[i];
	        if (projeto.getNome().equals(nomeProjeto)) {
	            return projeto; // Retorna o projeto se encontrar um com o nome correspondente.
	        }
	    }
	    // Retorna null se nenhum projeto com o nome correspondente for encontrado.
	    return null;
	}
}
