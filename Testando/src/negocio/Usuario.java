package negocio;

public class Usuario {
    private String nome;
    private Repositorio[] listaRepositorios;
    private int numRepositorios;

    public Usuario(String nome) {
        this.nome = nome;
        this.listaRepositorios = new Repositorio[100];
        this.numRepositorios = 0;
    }

	public String getNome() {
        return nome;
    }

    public Repositorio[] getRepositorios() {
        return listaRepositorios;
    }

    public void adicionarRepositorio(Repositorio repositorio) {
        if (numRepositorios < 100) {
            listaRepositorios[numRepositorios] = repositorio;
            numRepositorios++;
        } else {
            System.out.println("Limite de repositórios atingido para o usuário '" + nome + "'.");
        }
    }

    public void removerRepositorio(String nomeRepositorio) {
        for (int i = 0; i < numRepositorios; i++) {
            if (listaRepositorios[i] != null && listaRepositorios[i].getNome().equals(nomeRepositorio)) {
                // Move os repositórios restantes uma posição para frente
                for (int j = i; j < numRepositorios - 1; j++) {
                    listaRepositorios[j] = listaRepositorios[j + 1];
                }
                listaRepositorios[numRepositorios - 1] = null;
                numRepositorios--;
                System.out.println("Repositório removido com sucesso.");
                return;
            }
        }
        System.out.println("Repositório não encontrado para remoção.");
    }

    // Outros métodos de manipulação do usuário, se necessário
}