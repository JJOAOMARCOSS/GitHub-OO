package projeto;

//Classe Commit representa um registro de controle, herda de ItemControle.
public class Commit extends ItemControle{
	private String dtEnvio; 		// Atributo específico para armazenar a data de envio.
	
	 // Construtor que inicializa os atributos com os valores passados como parâmetros.
	public Commit(String n, int numId, String d, String dtEnvio) {
		nome = n;
		id = numId;
		descricao = d;
		this.dtEnvio = dtEnvio;
	}

	// Método de acesso para obter a data de envio.
	public String getDtEnvio() {
		return dtEnvio;
	}
	
	// Método de modificação para definir a data de envio.
	public void setDtEnvio(String dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	// Método de representação em formato de string do objeto.
	public String toString() {
		return "Nome: " + nome + ", " +
		"Id: " + id + ", " +
		"Descricao: " + descricao + ", " +
		"DtEnvio: " + dtEnvio; 
	}


}
