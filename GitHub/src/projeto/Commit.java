package projeto;

public class Commit extends ItemControle{
	private String dtEnvio;
	
	public Commit(String n, int numId, String d, String dtEnvio) {
		nome = n;
		id = numId;
		descricao = d;
		this.dtEnvio = dtEnvio;
	}

	public String getDtEnvio() {
		return dtEnvio;
	}

	public void setDtEnvio(String dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	public String toString() {
		return "Nome: " + nome + ", " +
		"Id: " + id + ", " +
		"Descricao: " + descricao + ", " +
		"DtEnvio: " + dtEnvio; 
	}


}
