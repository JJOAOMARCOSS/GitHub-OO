package projeto;

public class Issue extends ItemControle{
	private String status;
	
	public Issue(String n, int numId, String d, String status) {
		nome = n;
		id = numId;
		descricao = d;
		this.status = status;

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "Nome: " + nome + ", " +
		"Id: " + id + ", " +
		"Descrição: " + descricao + ", " +
		"Status: " + status; 
	}
}
