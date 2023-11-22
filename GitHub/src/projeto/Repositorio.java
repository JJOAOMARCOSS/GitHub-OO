package projeto;

//Classe Repositorio representa um repositório com itens de controle.
public class Repositorio {
	private String nome;							// Atributo para armazenar o nome do repositório.
	private String dtCriacao;						// Atributo para armazenar a data de criação do repositório.
	private ItemControle[] listaItensControles = new ItemControle[100]; // Array para armazenar itens de controle.
	private int numItensControles;					// Número de itens de controle presentes no repositório.
	
	// Construtor que inicializa os atributos com os valores passados como parâmetros.
	public Repositorio(String nome, String dtCriacao) {
		this.nome = nome;
		this.dtCriacao = dtCriacao;
		numItensControles = 0;
	}

	// Métodos de acesso e modificação para obter e definir o nome do repositório.
	public String getNome() {
		return nome;
	}

	// Método para definir o nome.
	public void setNome(String nome) {
		this.nome = nome;
	}

	// Métodos de acesso e modificação para obter e definir a data de criação do repositório.
	public String getDtCriacao() {
		return dtCriacao;
	}

	// Método para definir a data de criação.
	public void setDtCriacao(String dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	// Métodos de acesso e modificação para obter e definir a lista de itens de controle.
	public ItemControle[] getListarItensControles() {
		return this.listaItensControles;
	}

	// Método para definir a lista de itens de controle.
	public void setListarItensControles(ItemControle[] ic) {
		this.listaItensControles = ic;
	}

	// Métodos de acesso e modificação para obter e definir um item de controle específico.
	public ItemControle getItemControle(int i) {
		return listaItensControles[i];
	}
	
	// Método para definir um item de controle em uma posição específica da lista.
	public void setItemControle(ItemControle ic, int i) {
		this.listaItensControles[i] = ic;
	}
	
	// Métodos de acesso e modificação para obter e definir o número de itens de controle.
	public int getNumItensControles() {
		return numItensControles;
	}

	// Método para definir o número de itens de controle.
	public void setNumItensControles(int numItensControles) {
		this.numItensControles = numItensControles;
	}
	
	// Método de representação em formato de string do objeto.
	public String toString() {
		return "Nome: " + nome + ", Data de criacao: " + dtCriacao;
	}
}
	