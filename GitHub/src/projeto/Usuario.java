package projeto;

public class Usuario {
	private String nome;							// Atributo para armazenar o nome do usuário.
	private String email;							// Atributo para armazenar o email do repositório.
	private String senha;							// Atributo para armazenar a senha do repositório.
	private Repositorio[] listaRepositorios = new Repositorio [100]; // Array para armazenar repositórios.
	private int numRepositorios;					// Número de repositórios associados ao usuário.
	
	// Construtor para inicializar um objeto Usuario com nome, email e senha.
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		numRepositorios = 0;
	}

	// Método de acesso para obter o nome do Usuário.
	public String getNome() {
		return nome;
	}

	// Método de modificação para definir o nome do Usuário.
	public void setNome(String nome) {
		this.nome = nome;
	}

	// Método de acesso para obter o email do Usuário.
	public String getEmail() {
		return email;
	}

	// Método de modificação para definir o email do Usuário.
	public void setEmail(String email) {
		this.email = email;
	}

	// Método de acesso para obter a senha do Usuário.
	public String getSenha() {
		return senha;
	}

	// Método de modificação para definir a senha do Usuário.
	public void setSenha(String senha) {
		this.senha = senha;
	}

	// Método de acesso para obter a lista de repositórios associados ao usuário.
	public Repositorio[] getListaRepositorios() {
		return this.listaRepositorios;
	}

	// Método de modificação para definir a lista de repositórios associados ao usuário.
	public void setArrayListaRepositorios(Repositorio[] r) {
		this.listaRepositorios = r;
	}
	
	// Método de acesso para obter um repositório específico da lista.
	public Repositorio getRepositorio(int i) { 
		return listaRepositorios[i];
	}
	
	 // Método de modificação para definir a referência para um repositório na lista.
	public void setArrayRepositorio(Repositorio repo, int i) {
		this.listaRepositorios[i] = repo;
	}
	
	// Método de modificação para definir a referência para um repositório na lista.
	public void setRepositorio(Repositorio repo, int i) {
		this.listaRepositorios[i] = repo;
	}

	 // Método de acesso para obter o número de repositórios associados ao usuário.
	public int getNumRepositorios() {
		return numRepositorios;
	}

	// Método de modificação para definir o número de repositórios associados ao usuário.
	public void setNumRepositorios(int numRepositorios) {
		this.numRepositorios = numRepositorios;
	}
		
	// Método de representação em formato de string do objeto.
	public String toString() {
		return "Usuario: " + nome + ", Email: " + email + ", Senha: " + senha;
	}
	
	}
