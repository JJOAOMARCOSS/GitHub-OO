package projeto;

public class Issue extends ItemControle{
	private String status;
	private Usuario responsavel;
	
	public Issue(String nome, int id, String descricao, String status, Usuario responsavel) {
		super(nome, id, descricao);
		this.status = status;
		this.responsavel = responsavel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public String toString() {
		return "Status: " + status + ", Responsavel: " + responsavel.getNome();
	}
	
	
}
