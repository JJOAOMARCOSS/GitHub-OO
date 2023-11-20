package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.*;

public class Dados {
    private List<Usuario> usuarios;

    public Dados() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(String nomeUsuario) {
        Usuario usuario = buscarUsuario(nomeUsuario);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado para remoção.");
        }
    }

    public void listarUsuarios() {
        System.out.println("Lista de Usuários:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome());
        }
    }

    public Usuario buscarUsuario(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getNome().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public void adicionarRepositorio(Usuario usuario, Repositorio repositorio) {
        usuario.adicionarRepositorio(repositorio);
    }

    public void removerRepositorio(Usuario usuario, String nomeRepositorio) {
        usuario.removerRepositorio(nomeRepositorio);
    }

    public void listarRepositorios(Usuario usuario) {
        Repositorio[] repositorios = usuario.getRepositorios();
        System.out.println("Repositórios do Usuário '" + usuario.getNome() + "':");
        for (Repositorio repositorio : repositorios) {
            if (repositorio != null) {
                System.out.println(repositorio.getNome());
            }
        }
    }
}