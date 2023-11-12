package projeto;

public class Issue extends ItemControle{
	private String status;
	
	public Issue(String nome, int id, String descricao, String status) {
		super(nome, id, descricao);
		this.status = status;

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "Status: " + status; 
	}
}
