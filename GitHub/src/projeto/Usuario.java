package projeto;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private Repositorio[] listaRepositorios = new Repositorio [100];
	private int numRepositorios;
	
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		numRepositorios = 0;
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

	
	public Repositorio[] getListaRepositorios() {
		return this.listaRepositorios;
	}

	public void setArrayListaRepositorios(Repositorio[] r) {
		this.listaRepositorios = r;
	}
	
	public Repositorio getRepositorio(int i) { 
		return listaRepositorios[i];
	}
	
	public void setArrayRepositorio(Repositorio repo, int i) {
		this.listaRepositorios[i] = repo;
	}
	
	public void setRepositorio(Repositorio repo, int i) {
		this.listaRepositorios[i] = repo;
	}

	public int getNumRepositorios() {
		return numRepositorios;
	}

	public void setNumRepositorios(int numRepositorios) {
		this.numRepositorios = numRepositorios;
	}
	
	public boolean addrepositorio(Repositorio r) {
		if(numRepositorios < 100) {
			listaRepositorios[numRepositorios] = r;
			numRepositorios++;
			return true;
		} else {
			return false;
		}
	}
	
	public Repositorio buscaRepositorio(String nomeRepositorio) {

        Repositorio repositorioAchado = null; //saida
        Repositorio repositorioParaComparar;

        for(int i = 0; i < numRepositorios; i++) {
            repositorioParaComparar = listaRepositorios[i];
            if(repositorioParaComparar.getNome().compareToIgnoreCase(nomeRepositorio) == 0) {
                repositorioAchado = repositorioParaComparar;
                break;
            }
        }

        return repositorioAchado; //saida
    }

    /*
    //Buscar repositorio por data

    public Repositorio buscaData(String dtCriacao) {
        Repositorio saida = null;
        for(int i = 0; i < numRepositorios; i++) {
            if(saida.getNome().compareToIgnoreCase(dtCriacao) == 0) {
                saida = listaRepositorios[i];
            }
        } 
            return saida;
        }*/
	
	public String toString() {
		return "Usuario: " + nome + ", Email: " + email + ", Senha: " + senha;
	}
	
	}
