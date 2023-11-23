
// Pacote principal
package main;

import java.util.*;
import projeto.*;
import view.*;
import dados.*;

//Classe principal
public class Main {
	
	private static Dados d = new Dados(); 		
	private static Scanner in = new Scanner(System.in);

	 // Método principal
	public static void main(String[] args) {
		int op = -1;
		int aux;
		d.preencherDados();// Preenche dados iniciais

		// Loop principal do menu
		while(op != 0) {
			System.out.print(imprimirMenu()); // Exibe o menu principal
			
			 // Verifica se o usuário digitou um número
			while (!in.hasNextInt()) {
				System.out.println("Entrada invalida. Por favor, insira o numero da opcao desejada.");
				in.next(); // Limpa o buffer do scanner para receber uma nova entrada sem erros
			}
			
			op = in.nextInt(); // Lê a opção do usuário
			
			// Switch para lidar com a opção escolhida
			switch (op) {
			case 0:
				System.out.println("Obrigado por utilizar o GitHub. Ate logo!");
				break;
			case 1:
				cadastrarUsuario();
				break;
			case 2:
				removerUsuario();
				break;
			case 3:
				
				// Editar usuário existente
				if(d.getnUsuarios() > 0) {
                    System.out.println("Escolha um dos Usuarios para editar as informacoes:");
                    listarUsuarios();
                    aux = in.nextInt();
                    
                 // Verifica se há pelo menos um usuário
                    if (aux >= 0 && aux < d.getnUsuarios()) {
                        editarInformacoesNoUsuario(d, d.getUsuarios()[aux], in);
                    } else {
                        System.out.println("Entrada inválida. Por favor, repita o processo.");
                    }

                } else {
                    System.out.println("Nenhum usuário disponivel para edicao.");
                }
                break;

			case 4:

				// Listar usuários
				if(d.getnUsuarios() > 0) {
				listarUsuarios();
				} else {
					System.out.println("Nenhum usuário cadastrado.");
				}

				break;
			case 5:
				
				// Acessar usuário
				System.out.println("Digite o nome do usuario: ");
				String nomeAcessarUsuario = in.next();
				Usuario usuarioSelecionado = buscarUsuario(nomeAcessarUsuario);

				if (usuarioSelecionado != null) {
					System.out.println("Usuario encontrado: " + usuarioSelecionado.getNome());
					realizarOperacoesNoUsuario(d, usuarioSelecionado, in);
				} else {
					System.out.println("Usuario não encontrado.");
				}
				break;
			}
		}
		in.close();
	}

	/////////////
	//Menus
	/////////////
	
	// Função para imprimir o menu
	public static String imprimirMenu() {
        String saida = new String("----------------------------------------------\n" + 
                "---------Bem vindo(a) ao Menu GitHub!---------\n" + 
                "----------------------------------------------\n"  +
                "Escolha uma das opcoes a seguir:\n");
        saida = saida + "0 - Sair da aplicacao\n";
        saida = saida + "1 - Cadastrar novo Usuario\n";
        saida = saida + "2 - Remover usuario existente\n";
        saida = saida + "3 - Editar usuario existente\n";
        saida = saida + "4 - Listar usuarios\n";
        saida = saida + "5 - Acessar Usuario\n";
        return saida;
    }

	// Função para realizar operações no usuário
	private static void realizarOperacoesNoUsuario(Dados d, Usuario usuario, Scanner scanner) {
        int aux;
        while (true) {
            System.out.println("\nUsuario selecionado: '" + usuario.getNome() + "':\n");
            System.out.print("Escolha uma das opcoes a seguir:\n");
            System.out.println("00 - Voltar ao Menu Principal");
            System.out.println("01 - Cadastrar novo Repositorio");
            System.out.println("02 - Remover repositorio existente");
            System.out.println("03 - Editar repositorio existente");
            System.out.println("04 - Listar repositorios");
            System.out.println("05 - Acessar repositorio");

            // Verificando se o usuario digitou um numero ao invés de letra ou caractere
            while (!in.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira o numero da opção desejada.");
                in.next(); // Limpa o buffer do scannerpara receber uma nova entrada sem erros
            }

            int opcaoUsuario = scanner.nextInt();

            switch (opcaoUsuario) {
            case 0:
                return;
            case 1:
                cadastrarRepositorio();
                break;
            case 2:
                removerRepositorio();
                break;
            case 3:
                if(d.getnRepositorios() > 0) {
                    System.out.println("Escolha um dos Repositorios para editar as informacoes:");
                    listarRepositorios();

                    aux = in.nextInt();

                    // Verifica se há pelo menos um repositório
                    if (aux >= 0 && aux < d.getnRepositorios()) {
                        Repositorio r = lerDadosRepositorio();
                        editarRepositorio(aux, r);
                    } else {
                        System.out.println("Entrada inválida. Por favor, repita o processo.");
                    }

                } else {
                    System.out.println("Nenhum repositório disponivel para edicao.");
                }

                break;
            case 4:

                if(d.getnRepositorios() > 0) {
                listarRepositorios();
                } else {
                    System.out.println("Nenhum repositório cadastrado.");
                }

                break;
            case 5:
                System.out.println("Digite o nome do repositorio: ");
                String nomeAcessarRepositorio = in.next();
                Repositorio repositorioSelecionado = buscarRepositorio(nomeAcessarRepositorio);

                if (repositorioSelecionado != null) {
                    System.out.println("Repositorio encontrado: " + repositorioSelecionado.getNome());
                    realizarOperacoesNoRepositorio(repositorioSelecionado, in);
                } else {
                    System.out.println("Repositorio não encontrado.");
                }
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

	private static void editarInformacoesNoUsuario(Dados d, Usuario usuario, Scanner scanner) {
        while (true) {
            System.out.println("\nUsuário selecionado: '" + usuario.getNome() + "':\n");
            System.out.print("Escolha o que deseja editar:\n");
            System.out.println("1. Nome");
            System.out.println("2. Email");
            System.out.println("3. Senha");
            System.out.println("0. Voltar");

            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira o número da opção desejada.");
                scanner.next(); // Limpa o buffer do scanner para receber uma nova entrada sem erros
            }

            int opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario) {
                case 0:
                    return; // Retorna ao menu principal
                case 1:
                    System.out.println("\nDigite o novo nome do usuário: ");
                    String novoNome = scanner.nextLine();
                    Usuario nNome = new Usuario(novoNome, usuario.getEmail(), usuario.getSenha());
                    editarUsuario(1, d, usuario, nNome);
                    break;
                case 2:
                    System.out.println("\nDigite o novo email do usuário: ");
                    String novoEmail = scanner.nextLine();
                    Usuario nEmail = new Usuario(usuario.getNome(), novoEmail, usuario.getSenha());
                    editarUsuario(2, d, usuario, nEmail);
                    break;
                case 3:
                    System.out.println("\nDigite a nova senha do usuário: ");
                    String novaSenha = scanner.nextLine();
                    Usuario nSenha = new Usuario(usuario.getNome(), usuario.getEmail(), novaSenha);
                    editarUsuario(3, d, usuario, nSenha);
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    } 
	
	// Função para realizar operações no repositório
	private static void realizarOperacoesNoRepositorio(Repositorio repositorio, Scanner scanner) {
        int aux;

        while (true) {
            System.out.println("\nRepositorio '" + repositorio.getNome() + "':");
            System.out.print("Escolha uma das opcoes a seguir:\n");
            System.out.println("00 - Voltar ao Menu Principal");
            System.out.println("01 - Cadastrar novo Commit");
            System.out.println("02 - Remover commit existente");
            System.out.println("03 - Editar commit existente");
            System.out.println("04 - Listar commits");
            System.out.println("05 - Cadastrar novo issue");
            System.out.println("06 - Remover issue existente");
            System.out.println("07 - Editar issue existente");
            System.out.println("08 - Listar issues");

            int opcaoRepositorio = scanner.nextInt();
            switch (opcaoRepositorio) {
            case 0:
                return;
            case 1:
                cadastrarCommit();
                break;
            case 2:
                removerCommit();
                break;
            case 3:

                if(d.getnCommits() > 0) {
                    System.out.println("Escolha um dos Commit para editar as informacoes:");
                    listarCommit();

                    aux = in.nextInt();

                    // Verifica se há pelo menos um commit
                    if (aux >= 0 && aux < d.getnCommits()) {
                        editarInformacoesNoCommit(d, d.getCommits()[aux], in);
                    } else {
                        System.out.println("Entrada inválida. Por favor, repita o processo.");
                    }

                } else {
                    System.out.println("Nenhum commit disponivel para edicao.");
                }

                break;
                
            case 4:

                if(d.getnCommits() > 0) {
                listarCommit();
                } else {
                    System.out.println("Nenhum commit cadastrado.");
                }

                break;
            case 5:
                cadastrarIssue();
                break;
            case 6:
                removerIssue();
                break;
            case 7:
                if(d.getnCommits() > 0) {
                    System.out.println("Escolha um dos Issue para editar as informacoes:");
                    listarIssues();
                    aux = in.nextInt();

                    // Verifica se há pelo menos um commit
                    if (aux >= 0 && aux < d.getnIssues()) {
                        editarInformacoesNaIssue(d, d.getIssues()[aux], in);
                    } else {
                        System.out.println("Entrada inválida. Por favor, repita o processo.");
                    }

                } else {
                    System.out.println("Nenhum issue disponivel para edicao.");
                }

                break;
            case 8:

                if(d.getnIssues() > 0) {
                listarIssues();
                } else {
                    System.out.println("Nenhum issue cadastrado.");
                }

                break;

            default:
                System.out.println("\nOpção Invalida!\n");
                break;
            }
        }
    }
                

	/////////////
	//Usuario
	/////////////

	// Função de cadastrar usuário
	public static boolean cadastrarUsuario() {
		Usuario u = lerDadosUsuario();
		if(d.getnUsuarios() < 100) {
			d.setUsuario(d.getnUsuarios(), u);
			d.setnUsuarios(d.getnUsuarios()+1);
			System.out.println("Usuario cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar o usuario!\n");
			return false;
		}
	}

	// Função de ler os dados do usuário
	public static Usuario lerDadosUsuario() {
		String nome;
		String email; 
		String senha;
		
		in.nextLine(); // Limpa o buffer
		
		System.out.println("Digite o nome do Usuario: ");
		nome = in.nextLine();
		System.out.println("Digite o email do Usuario: ");
		email = in.nextLine();
		System.out.println("Digite a senha do Usuario: ");
		senha = in.nextLine();
		Usuario u = new Usuario(nome, email, senha);
		return u;	
	}

	// Função de remover usuário
	public static void removerUsuario() {
		System.out.println("Escolha um dos usuarios a seguir para ser removido:\n");
		listarUsuarios();
		int i = in.nextInt();
		if(i < d.getnUsuarios() && i > 0) {
			swapListaUsuarios(i);
			d.setUsuario(d.getnUsuarios(), null);
			d.setnUsuarios(d.getnUsuarios() - 1);
			System.out.println("Usuario removido com sucesso\n");
		} else {
			System.out.println("Voce escolheu um numero invalido!\n");
		}

	}

	public static void swapListaUsuarios(int u) {
		for(int i = u; i < d.getnUsuarios() - 1; i++) 
			d.setUsuario(i, d.getUsuario(i+1));
	}

	// Função de editar dados do usuário
	private static void editarUsuario(int opcao, Dados d, Usuario usuario, Usuario novoUsuario) {
        switch (opcao) {
            case 1:
                usuario.setNome(novoUsuario.getNome());
                System.out.println("Nome do usuário editado com sucesso");
                break;
            case 2:
                usuario.setEmail(novoUsuario.getEmail());
                System.out.println("Email do usuário editado com sucesso");
                break;
            case 3:
                usuario.setSenha(novoUsuario.getSenha());
                System.out.println("Senha do usuário editada com sucesso");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

	// Função de listar  usuários
	public static void listarUsuarios() {
		
		in.nextLine(); // Limpa o buffer
		
		for(int i = 0; i < d.getnUsuarios(); i++) 
			System.out.println(i + " -> " + d.getUsuarios()[i].toString());
	}

	// Função buscar um usuários
	public static Usuario buscarUsuario(String nomeUsuario) {
		for (int i = 0; i < d.getnUsuarios(); i++) {
			if (d.getUsuarios()[i] != null && d.getUsuarios()[i].getNome().equals(nomeUsuario)) {
				return d.getUsuarios()[i];
			}
		}
		return null;
	}
	
	/////////////
	//Repositorio
	/////////////
	
	// Função de cadastrar repositório
	public static boolean cadastrarRepositorio() {
		Repositorio r = lerDadosRepositorio();
		if(d.getnRepositorios() < 100) {
			d.setRepositorio(d.getnRepositorios(), r);
			d.setnRepositorios(d.getnRepositorios()+1);
			System.out.println("Repositorio cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar o Repositorio!\n");
			return false;
		}
	}

	// Função de ler dados do repositório
	public static Repositorio lerDadosRepositorio() {  
		String nomeRepositorio;
		String dtCriacao;
		
		in.nextLine(); //esvazia dados do teclado
		
		System.out.println("Digite o nome do Repositorio: ");
		nomeRepositorio = in.nextLine();
		System.out.println("Digite a data de criacao do Repositorio: ");
		dtCriacao = in.nextLine();
		Repositorio r = new Repositorio(nomeRepositorio, dtCriacao);
		return r;	
	}

	// Função de remover repositório
	public static void removerRepositorio() {
		if(d.getnRepositorios() != 0) {
			System.out.println("Escolha um dos repositorios a seguir para ser removido:\n");
			listarRepositorios();
			int i = in.nextInt();
			if(i < d.getnRepositorios() && i >= 0) {
				swapListaRepositorios(i);
				d.setRepositorio(d.getnRepositorios(), null);
				d.setnRepositorios(d.getnRepositorios() - 1);
				System.out.println("Repositorio removido com sucesso\n");
			} else {
				System.out.println("Voce escolheu um numero invalido!\n");
			}
		} else {
			System.out.println("Não existe nenhum repositorio cadastrado!\n");
		}

	}

	public static void swapListaRepositorios(int r) {
		for(int i = r; i < d.getnRepositorios() - 1; i++) 
			d.setRepositorio(i, d.getRepositorio(i+1));
	}

	public static void editarRepositorio(int i, Repositorio r) {
		if (i < d.getnRepositorios() && i >= 0) {
			d.setRepositorio(i, r);
			System.out.println("Repositorio editado com sucesso");
		} else {
			System.out.println("Você escolheu um número inválido!");
		}	
	}

	// Função de listar repositórios
	public static void listarRepositorios() {
		System.out.print("Lista de Repositorios: \n");

		in.nextLine(); // Limpa o buffer
		
		for(int i = 0; i < d.getnRepositorios(); i++) 
			System.out.println(i + " -> " + d.getRepositorios()[i].toString());
		
	}
	
	// Função de buscar repositório
	public static Repositorio buscarRepositorio(String nomeRepositorio) {
		for (int i = 0; i < d.getnRepositorios(); i++) {
			if (d.getRepositorios()[i] != null && d.getRepositorios()[i].getNome().equals(nomeRepositorio)) {
				return d.getRepositorios()[i];
			}
		}
		return null;
	}

	/////////////
	//Commit
	/////////////
	
	private static void editarInformacoesNoCommit(Dados d, Commit commit, Scanner scanner) {
        while (true) {
            System.out.println("\nCommit selecionado: '" + commit.getNome() + "':\n");
            System.out.print("Escolha o que deseja editar:\n");
            System.out.println("1. Nome");
            System.out.println("2. ID");
            System.out.println("3. Descricao");
            System.out.println("0. Voltar");

            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira o número da opção desejada.");
                scanner.next(); // Limpa o buffer do scanner para receber uma nova entrada sem erros
            }

            int opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario) {
                case 0:
                    return; // Retorna ao menu principal
                case 1:
                    System.out.println("Digite o novo nome do commit: ");
                    String novoNome = scanner.nextLine();
                    Commit nNome = new Commit(novoNome, commit.getId(), commit.getDescricao(), commit.getDtEnvio());
                    editarCommit(1, d, commit, nNome);
                    break;
                case 2:
                    while (true) {
                        System.out.println("Digite o novo ID do commit: ");
                        if (in.hasNextInt()) {
                            int novoId = scanner.nextInt();
                            Commit nId = new Commit(commit.getNome(), novoId, commit.getDescricao(), commit.getDtEnvio());
                            editarCommit(2, d, commit, nId);
                            break; // Sai do loop se um número inteiro válido for fornecido
                        } else {
                            System.out.println("Por favor, digite um valor numérico para o ID.");
                            in.nextLine(); // Limpa o buffer
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite a nova descricao do commit: ");
                    String novaDescricao = scanner.nextLine();
                    Commit nDescricao = new Commit(commit.getNome(), commit.getId(), novaDescricao, commit.getDtEnvio());
                    editarCommit(3, d, commit, nDescricao);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
	
	private static void editarCommit(int opcao, Dados d, Commit commit, Commit novoCommit) {
        switch (opcao) {
            case 1:
                commit.setNome(novoCommit.getNome());
                System.out.println("Nome do commit editado com sucesso");
                break;
            case 2:
                commit.setId(novoCommit.getId());
                System.out.println("ID do commit editado com sucesso");
                break;
            case 3:
                commit.setDescricao(novoCommit.getDescricao());
                System.out.println("Descricao do commit editada com sucesso");
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }
 
	// Função de cadastrar commit	
	public static boolean cadastrarCommit() {
		Commit c = lerDadosCommit();
		if(d.getnCommits() < 100) {
			d.setCommit(d.getnCommits(), c);
			d.setnCommits(d.getnCommits()+1);
			System.out.println("Commit cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar a Commit!\n");
			return false;
		}
	}

	// Função de ler dados do commit
	public static Commit lerDadosCommit() {
		String nome;
		int id;
		String descricao;
		String dtEnvio;

		in.nextLine(); //Limpa o buffer

		System.out.println("Digite o nome do Commit: ");
		nome = in.nextLine();

		while (true) {
			System.out.println("Digite o ID: ");
			if (in.hasNextInt()) {
				id = in.nextInt();
				
				in.nextLine(); // Limpa o buffer
				
				break; // Sai do loop se um número inteiro válido for fornecido
			} else {
				System.out.println("Por favor, digite um valor numérico para o ID.");
				
				in.nextLine(); // Limpa o buffer
			}
		}

		System.out.println("Digite a Descrição: ");
		descricao = in.nextLine();

		System.out.println("Digite a data de envio do Commit: ");
		dtEnvio = in.nextLine();

		Commit c = new Commit(nome, id, descricao, dtEnvio);
		return c;	
	}

	// Função de remover commit
	public static void removerCommit() {
		if(d.getnCommits() != 0) {
			System.out.println("Escolha um dos commits a seguir para ser removido:\n");
			listarCommit();
			int i = in.nextInt();
			if(i < d.getnCommits() && i >= 0) {
				swapListaCommits(i);
				d.setCommit(d.getnCommits(), null);
				d.setnCommits(d.getnCommits() - 1);
				System.out.println("Commit removido com sucesso\n");
			} else {
				System.out.println("Voce escolheu um numero invalido!\n");
			}
		} else {
			System.out.println("Não existe nenhum commit cadastrado!\n");
		}

	}

	public static void swapListaCommits(int c) {
		for(int i = c; i < d.getnCommits() - 1; i++) 
			d.setCommit(i, d.getCommit(i+1));
	}


	// Função de listar commits
	public static void listarCommit() {
		System.out.print("Lista de Commits: \n");

		in.nextLine(); // Limpa o buffer
		
		for(int i = 0; i < d.getnCommits(); i++) 
			System.out.println(i + " -> " + d.getCommits()[i].toString());
	}

	/////////////
	//Issue
	/////////////
	
	private static void editarInformacoesNaIssue(Dados d, Issue issue, Scanner scanner) {
        while (true) {
            System.out.println("\nIssue selecionada: '" + issue.getNome() + "':\n");
            System.out.print("Escolha o que deseja editar:\n");
            System.out.println("1. Nome");
            System.out.println("2. ID");
            System.out.println("3. Descricao");
            System.out.println("4. Status");
            System.out.println("0. Voltar");

            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira o número da opção desejada.");
                scanner.next(); // Limpa o buffer do scanner para receber uma nova entrada sem erros
            }

            int opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario) {
                case 0:
                    return; // Retorna ao menu principal
                case 1:
                    System.out.println("Digite o novo nome da issue: ");
                    String novoNome = scanner.nextLine();
                    Issue nNome = new Issue(novoNome, issue.getId(), issue.getDescricao(), issue.getStatus());
                    editarIssue(1, d, issue, nNome);
                    break;
                case 2:
                    while (true) {
                        System.out.println("Digite o novo ID da issue: ");
                        if (in.hasNextInt()) {
                            int novoId = scanner.nextInt();
                            Issue nId = new Issue(issue.getNome(), novoId, issue.getDescricao(), issue.getStatus());
                            editarIssue(2, d, issue, nId);
                            break; // Sai do loop se um número inteiro válido for fornecido
                        } else {
                            System.out.println("Por favor, digite um valor numérico para o ID.");
                            in.nextLine(); // Limpa o buffer
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite a nova descricao da issue: ");
                    String novaDescricao = scanner.nextLine();
                    Issue nDescricao = new Issue(issue.getNome(), issue.getId(), novaDescricao, issue.getStatus());
                    editarIssue(3, d, issue, nDescricao);
                    break;
                case 4:
                    System.out.println("Digite o novo status da issue: ");
                    String novoStatus = scanner.nextLine();
                    Issue nStatus = new Issue(issue.getNome(), issue.getId(), issue.getDescricao(), novoStatus);
                    editarIssue(4, d, issue, nStatus);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

	//Função de editar issue
	private static void editarIssue(int opcao, Dados d, Issue issue, Issue novaIssue) {
    switch (opcao) {
        case 1:
            issue.setNome(novaIssue.getNome());
            System.out.println("Nome da issue editada com sucesso");
            break;
        case 2:
            issue.setId(novaIssue.getId());
            System.out.println("ID da issue editada com sucesso");
            break;
        case 3:
            issue.setDescricao(novaIssue.getDescricao());
            System.out.println("Descricao da issue editada com sucesso");
            break;
        case 4:
            issue.setStatus(novaIssue.getStatus());
            System.out.println("Status da issue editada com sucesso");
            break;
        default:
            System.out.println("Opcao invalida!");
    }
}

	// Função de cadastrar issue
	public static boolean cadastrarIssue() {
		Issue i = lerDadosIssue();
		if(d.getnIssues() < 100) {
			d.setIssue(d.getnIssues(), i);
			d.setnIssues(d.getnIssues()+1);
			System.out.println("Issue cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar a Issue!\n");
			return false;
		}
	}

	// Função de ler dados do issue
	public static Issue lerDadosIssue() {
		String nome;
		int id;
		String descricao;
		String status;
		
		in.nextLine(); // Limpa o buffer
		
		System.out.println("Digite o nome do Issue: ");
		nome = in.nextLine();
		System.out.println("Digite o ID: ");
		id = in.nextInt();
		
		in.nextLine(); // Limpa o buffer
		
		System.out.println("Digite a Descrição: ");
		descricao = in.nextLine();
		System.out.println("Digite o status do Issue: ");
		status = in.nextLine();
		Issue iss = new Issue(nome, id, descricao, status);
		return iss;	
	}
	
	// Função de remover issue
	public static void removerIssue() {
		if(d.getnIssues() != 0) {
			System.out.println("Escolha um dos issues a seguir para ser removido:\n");
			listarIssues();
			int i = in.nextInt();
			if(i < d.getnIssues() && i >= 0) {
				swapListaIssues(i);
				d.setIssue(d.getnIssues(), null);
				d.setnIssues(d.getnIssues() - 1);
				System.out.println("Issue removido com sucesso\n");
			} else {
				System.out.println("Voce escolheu um numero invalido!\n");
			}
		} else {
			System.out.println("Não existe nenhum issue cadastrado!\n");
		}
	}

	public static void swapListaIssues(int c) {
		for(int i = c; i < d.getnIssues() - 1; i++) 
			d.setIssue(i, d.getIssue(i+1));
	}


	// Função de listar os issues
	public static void listarIssues() {
		System.out.print("Lista de Issues: \n");

		in.nextLine(); // Limpa o buffer
		
		for(int i = 0; i < d.getnIssues(); i++) 
			System.out.println(i + " -> " + d.getIssues()[i].toString());
	}
	

}
