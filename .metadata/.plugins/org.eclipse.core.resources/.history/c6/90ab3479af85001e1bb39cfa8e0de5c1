package projeto;

public class Repositorio {
	private String nome;
	private String dtCriacao;
	private ItemControle[] listaItensControles = new ItemControle[100]; 
	private int numItensControles;
	
	public Repositorio(String nome, String dtCriacao) {
		this.nome = nome;
		this.dtCriacao = dtCriacao;
		numItensControles = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(String dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public ItemControle[] getListarItensControles() {
		return this.listaItensControles;
	}

	public void setListarItensControles(ItemControle[] ic) {
		this.listaItensControles = ic;
	}

	public ItemControle getItemControle(int i) {
		return listaItensControles[i];
	}
	
	public void setItemControle(ItemControle ic, int i) {
		this.listaItensControles[i] = ic;
	}
	
	public int getNumItensControles() {
		return numItensControles;
	}

	public void setNumItensControles(int numItensControles) {
		this.numItensControles = numItensControles;
	}
	
	public boolean addItemControle(ItemControle ic) {
		if(numItensControles < 100) {
			listaItensControles[numItensControles] = ic; 
			numItensControles++;
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public ItemControle buscaItemControle(String nomeItemControle) {
		ItemControle saida = null;
		for(int i = 0; i < numItensControles; i++) {
			if(saida.getNome().compareToIgnoreCase(nomeItemControle) == 0) {
				saida = listaItensControles[i];
			}
		}
			return saida;
	}
	
	public String toString() {
		return "Nome: " + nome + ", Data de criação: " + dtCriacao;
	}
}
	