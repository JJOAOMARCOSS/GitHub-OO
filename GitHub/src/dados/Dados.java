package dados;

import projeto.*;
import java.util.ArrayList;

public class Dados {
    private Usuario[] usuarios;
    private int nUsuarios = 0;
    private Repositorio[] repositorios;
    private int nRepositorios = 0;
    private Commit[] commits;
    private int nCommits = 0;
    private Issue[] issues;
    private int nIssues = 0;
    private Projeto[] projetos;
    private int nProjetos = 0;

    public Dados() {
        usuarios = new Usuario[100];
        repositorios = new Repositorio[100];
        commits = new Commit[100];
        issues = new Issue[100];
        projetos = new Projeto[100];
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuario(int i) {
        return usuarios[i];
    } 

    public String[] getNomeUsuarios() {
        String[] s = new String[nUsuarios];
        for(int i = 0; i < nUsuarios; i++) {
            s[i] = usuarios[i].getNome();
        }
        return s;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public void setUsuario(int i, Usuario a) {
        usuarios[i] = a;
    }
}
