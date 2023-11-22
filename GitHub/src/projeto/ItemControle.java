package projeto;

//Classe abstrata ItemControle serve como base para classes que representam itens de controle.
public abstract class ItemControle {
	protected String nome;			// Atributo para armazenar o nome do item.
	protected int id;				// Atributo para armazenar o ID do item.
	protected String descricao;		// Atributo para armazenar a descrição do item.

	// Método de acesso para obter o nome do item.
	public String getNome() {
		return nome;
	}

	// Método de modificação para definir o nome do item.
	public void setNome(String nome) {
		this.nome = nome;
	}

	// Método de acesso para obter o ID do item.
	public int getId() {
		return id;
	}

	// Método de modificação para definir o ID do item.
	public void setId(int id) {
		this.id = id;
	}

	// Método de acesso para obter a descrição do item.
	public String getDescricao() {
		return descricao;
	}

	// Método de modificação para definir a descrição do item.
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	// Método de representação em formato de string do objeto.
	public String toString() {
		return "Nome: " + nome + ", ID: " + id + ", Descrição: " + descricao;
	}

}
