package projeto;

//Classe Issue  representa um registro de controle, herda de ItemControle.
public class Issue extends ItemControle{
	private String status;		// Atributo específico para armazenar o status da Issue.
	
	// Construtor que inicializa os atributos com os valores passados como parâmetros.
	public Issue(String n, int numId, String d, String status) {
		nome = n;
		id = numId;
		descricao = d;
		this.status = status;

	}

	// Método de acesso para obter o status da Issue.
	public String getStatus() {
		return status;
	}
	
	// Método de modificação para definir o status da Issue.
	public void setStatus(String status) {
		this.status = status;
	}

	// Método de representação em formato de string do objeto.
	public String toString() {
		return "Nome: " + nome + ", " +
		"Id: " + id + ", " +
		"Descrição: " + descricao + ", " +
		"Status: " + status; 
	}
}
