package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import negocio.*;
import dados.*;

public class Main {
    public static void main(String[] args) {
        Dados dados = new Dados();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Cadastrar Usuário");
            System.out.println("2. Remover Usuário");
            System.out.println("3. Listar Usuários");
            System.out.println("4. Acessar Usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.next();
                    Usuario novoUsuario = new Usuario(nomeUsuario);
                    dados.adicionarUsuario(novoUsuario);
                    break;

                case 2:
                    System.out.print("Digite o nome do usuário a ser removido: ");
                    String nomeRemoverUsuario = scanner.next();
                    dados.removerUsuario(nomeRemoverUsuario);
                    break;

                case 3:
                    dados.listarUsuarios();
                    break;

                case 4:
                    System.out.print("Digite o nome do usuário: ");
                    String nomeAcessarUsuario = scanner.next();
                    Usuario usuarioSelecionado = dados.buscarUsuario(nomeAcessarUsuario);

                    if (usuarioSelecionado != null) {
                        realizarOperacoesNoUsuario(dados, usuarioSelecionado, scanner);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do programa.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void realizarOperacoesNoUsuario(Dados dados, Usuario usuario, Scanner scanner) {
        while (true) {
            System.out.println("\nOperações no Usuário '" + usuario.getNome() + "':");
            System.out.println("1. Adicionar Repositório");
            System.out.println("2. Remover Repositório");
            System.out.println("3. Listar Repositórios");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcaoUsuario = scanner.nextInt();

            switch (opcaoUsuario) {
                case 1:
                    System.out.print("Digite o nome do repositório: ");
                    String nomeRepositorio = scanner.next();
                    Repositorio novoRepositorio = new Repositorio(nomeRepositorio);
                    dados.adicionarRepositorio(usuario, novoRepositorio);
                    System.out.println("Repositório adicionado com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o nome do repositório a ser removido: ");
                    String nomeRemoverRepositorio = scanner.next();
                    dados.removerRepositorio(usuario, nomeRemoverRepositorio);
                    break;

                case 3:
                    dados.listarRepositorios(usuario);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}