package main;

import java.util.*;
import projeto.*;
import view.*;
import dados.*;

public class Main {
	
	private static Dados d = new Dados(); 		
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int op = -1;
		int aux;
		d.preencherDados();
		
		while(op != 0) {
			System.out.print(imprimirMenu());
			// Verificando se o usuario digitou um numero ao invés de letra ou caractere
			while (!in.hasNextInt()) {
				System.out.println("Entrada inválida. Por favor, insira o numero da opção desejada.");
				in.next(); // Limpa o buffer do scannerpara receber uma nova entrada sem erros
			}
			op = in.nextInt();
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
					System.out.println("Escolha um dos Usuarios a seguir para editar as informacoes:\n");
					listarUsuarios();
					aux = in.nextInt();
					System.out.println("\n");
					Usuario u = lerDadosUsuario();
					editar(aux, u);
					break;
				case 4:
					listarUsuarios();
					break;
			case 5:
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
	public static String imprimirMenu() {
		String saida = new String("Bem vindo ao Menu GitHub! \nEscolha uma das opcoes a seguir:\n");
		saida = saida + "00 - Sair da aplicacao\n";
		saida = saida + "01 - Cadastrar novo Usuario\n";
		saida = saida + "02 - Remover usuario existente\n";
		saida = saida + "03 - Editar usuario existente\n";
		saida = saida + "04 - Listar usuarios\n";
		saida = saida + "05 - Acessar Usuario\n";
		return saida;
	}
	
	public static String imprimirMenuUsuarioRep() {
		String saida = new String("Escolha uma das opcoes a seguir:\n");
		saida = saida + "00 - Nao, voltar para o menu\n";
		saida = saida + "01 - Sim\n";
		return saida;
	}

	public static String imprimirMenuRepositorio() {
		String saida = new String("Escolha uma das opcoes a seguir:\n");
		saida = saida + "00 - Voltar para o menu\n";
		saida = saida + "01 - Cadastrar novo Repositorio\n";
		saida = saida + "02 - Remover repositorio existente\n";
		saida = saida + "03 - Editar repositorio existente\n";
		saida = saida + "04 - Listar repositorios\n";
		saida = saida + "05 - Buscar Repositorio\n";
        saida = saida + "06 - Cadastrar novo Commit\n";
        saida = saida + "07 - Remover commit existente\n";
        saida = saida + "08 - Editar commit existente\n";
        saida = saida + "09 - Listar commits\n";
        saida = saida + "10 - Cadastrar novo Issue\n";
        saida = saida + "11 - Remover projeto issue\n";
        saida = saida + "12 - Editar projeto issue\n";
        saida = saida + "13 - Listar issues\n";
		return saida;
	}

	//Menu Diferente Teste
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
                	cadastrarRepositorio(usuario);
                    break;
                case 2:
                	removerRepositorio(usuario);
                    break;
                case 3:
                	if(usuario.getNumRepositorios() > 0) {
					System.out.println("Escolha um dos Repositorios para editar as informacoes:");
					listarRepositorios(usuario);

					aux = in.nextInt();
				
                    // Verifica se há pelo menos um repositório
                    if (aux >= 0 && aux < usuario.getNumRepositorios()) {
                        Repositorio r = lerDadosRepositorio();
                        editarRepositorio(usuario, aux, r);
                    } else {
						System.out.println("Entrada inválida. Por favor, repita o processo.");
					}
					
					} else {
                        System.out.println("Nenhum repositório disponivel para edicao.");
        			}
				    	
                    break;
                case 4:
                	listarRepositorios(usuario);
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
                	cadastrarCommit(repositorio);
                    break;
                case 2:
					removerCommit(repositorio);
                    break;
                case 3:

					if(repositorio.getNumItensControles() > 0) {
                    System.out.println("Escolha um dos Commit para editar as informacoes:");
					listarCommit(repositorio);
              
                    aux = in.nextInt();

                    // Verifica se há pelo menos um commit
                    if (aux >= 0 && aux < repositorio.getNumItensControles()) {
                        Commit c = lerDadosCommit();
                        editarCommit(repositorio, aux, c);
                    } else {
						System.out.println("Entrada inválida. Por favor, repita o processo.");
					}
					
					} else {
                        System.out.println("Nenhum commit disponivel para edicao.");
        			}

					break;
                case 4:
                	listarCommit(repositorio);
                    break;
                case 5:
                	cadastrarIssue(repositorio);
                    break;
                case 6:
					removerIssue(repositorio);
                    break;
                case 7:
                	if(repositorio.getNumItensControles() > 0) {
                    System.out.println("Escolha um dos issues para editar as informacoes:");
					listarIssues(repositorio);
				
                    aux = in.nextInt();

                    // Verifica se há pelo menos um issue
                    if (aux >= 0 && aux < repositorio.getNumItensControles()) {	
                        Issue i = lerDadosIssue();
                        editarIssue(repositorio, aux, i);
                    } else {
						System.out.println("Entrada inválida. Por favor, repita o processo.");
					}
					
					} else {
                        System.out.println("Nenhum issue disponivel para edicao.");
        			}
					
					break;
                case 8:
                	listarIssues(repositorio);
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
	
	public static Usuario lerDadosUsuario() {
		String nome;
		String email; 
		String senha;
		in.nextLine(); //esvazia dados do teclado
		System.out.println("Digite o nome do Usuario: ");
		nome = in.nextLine();
		System.out.println("Digite o email do Usuario: ");
		email = in.nextLine();
		System.out.println("Digite a senha do Usuario: ");
		senha = in.nextLine();
		Usuario u = new Usuario(nome, email, senha);
		return u;	
	}
	
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
	
	public static void editar(int i, Usuario u) {
		if(i < d.getnUsuarios() && i >= 0) {
			d.setUsuario(i, u);
			System.out.println("Dados editados com sucesso");
		} else {
			System.out.println("Voce escolheu um numero invalido!");
		}
	}
	
	public static void listarUsuarios() {
		in.nextLine(); //esvazia dados do teclado
		for(int i = 0; i < d.getnUsuarios(); i++) 
			System.out.println(i + " -> " + d.getUsuarios()[i].toString());
	}
	
	public static Usuario buscarUsuario(String nomeUsuario) {
		for (int i = 0; i < d.getnUsuarios(); i++) {
	        if (d.getUsuarios()[i] != null && d.getUsuarios()[i].getNome().equals(nomeUsuario)) {
	            return d.getUsuarios()[i];
	        }
	    }
	    return null;
    }
	
	
	/*
	private static void buscarRepositorio(String nome) {
        //Busca Dentro do Usuário

        for(int i = 0; i < d.getnUsuarios(); i++) {
            if(d.getUsuarios()[i].buscaRepositorio(nome)!= null){
                System.out.println(d.getUsuarios()[i].buscaRepositorio(nome).toString());
            }
        }
       

        //Dentro do Dados
        /*for(int i = 0; i < d.getnRepositorios(); i++) {
            if(d.getRepositorios()[i].getNome().compareToIgnoreCase(nome) == 0) {
                System.out.println(d.getRepositorios()[i].toString());
                
         
            }
        }
		
    }
	*/


	/////////////
	//Repositorio
	/////////////
	
	public static boolean cadastrarRepositorio(Usuario usuario) {
		Repositorio r = lerDadosRepositorio();
		if(d.getnRepositorios() < 100) {
			d.adicionarRepositorio(usuario, r);
			d.setRepositorio(d.getnRepositorios(), r);
			d.setnRepositorios(d.getnRepositorios()+1);
			System.out.println("Repositorio cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar o Repositorio!\n");
			return false;
		}
	}
	
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
	
	public static void removerRepositorio(Usuario usuario) {
    	System.out.print("Digite o nome do repositório a ser removido: ");
		String nomeRemoverRepositorio = in.next();
        d.removerRepositorio(usuario, nomeRemoverRepositorio);
	}
	
	public static void swapListaRepositorios(int r) {
		for(int i = r; i < d.getnRepositorios() - 1; i++) 
			d.setRepositorio(i, d.getRepositorio(i+1));
	}
	
	public static void editarRepositorio(Usuario usuario, int i, Repositorio r) {
			d.editarRepositorio(usuario, i, r);
	}
	
	public static void listarRepositorios(Usuario usuario) {
		System.out.print("Lista de Repositorios: \n");
	    Repositorio[] repositorios = usuario.getListaRepositorios();
	    int i = 0;

		boolean repertorioEncontrado = false;

	    for (Repositorio repositorio : repositorios) {
	        if (repositorio != null) {
	            System.out.println(i + " -> " + repositorio.toString());
				repertorioEncontrado = true;
	            i++;
	        } 
	    }

		if(!repertorioEncontrado){
			System.out.println("Não há nenhum repertorio cadastrado!");
		}
	}
	
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
	
	public static boolean cadastrarCommit(Repositorio repositorio) {
		Commit c = lerDadosCommit();
		if(d.getnCommits() < 100) {
			d.adicionarCommit(repositorio, c);
			d.setCommit(d.getnCommits(), c);
			d.setnCommits(d.getnCommits()+1);
			System.out.println("Commit cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar a Commit!\n");
			return false;
		}
	}
	
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
	
	public static void removerCommit(Repositorio repositorio) {
		System.out.print("Digite o nome do Commit a ser removido: ");
		String nomeRemoverCommit = in.next();
        d.removerCommit(repositorio, nomeRemoverCommit);

	}
	
	public static void swapListaCommits(int c) {
		for(int i = c; i < d.getnCommits() - 1; i++) 
			d.setCommit(i, d.getCommit(i+1));
	}
	
	public static void editarCommit(Repositorio repositorio, int i, Commit c) {
		d.editarCommit(repositorio, i, c);
	}
	
	public static void listarCommit(Repositorio repositorio) {
	    in.nextLine(); // Esvazia dados do teclado
	    ItemControle[] itemControles = repositorio.getListarItensControles();
	    int i = 0;

		boolean commitEncontrado = false;

	    for (ItemControle itemControle : itemControles) {
	        if (itemControle != null) {   	
	            System.out.println(i + " -> " + itemControle.toString());
				commitEncontrado = true;
	            i++;
	        } 
	    }

		if(!commitEncontrado){
			System.out.println("Não há nenhum commit cadastrado!");
		}
	}
	
	/////////////
	//Issue
	/////////////
	
	public static boolean cadastrarIssue(Repositorio repositorio) {
		Issue i = lerDadosIssue();
		if(d.getnIssues() < 100) {
			d.adicionarIssue(repositorio, i);
			d.setIssue(d.getnIssues(), i);
			d.setnIssues(d.getnIssues()+1);
			System.out.println("Issue cadastrado com sucesso!\n");
			return true;
		} else {
			System.out.println("Não foi possivel cadastrar a Issue!\n");
			return false;
		}
	}
	
	public static Issue lerDadosIssue() {
		String nome;
		int id;
		String descricao;
		String status;
		in.nextLine();
		System.out.println("Digite o nome do Issue: ");
		nome = in.nextLine();
		System.out.println("Digite o ID: ");
		id = in.nextInt();
		in.nextLine();
		System.out.println("Digite a Descrição: ");
		descricao = in.nextLine();
		System.out.println("Digite o status do Issue: ");
		status = in.nextLine();
		Issue iss = new Issue(nome, id, descricao, status);
		return iss;	
	}
	
	public static void removerIssue(Repositorio repositorio) {
		System.out.print("Digite o nome do Issue a ser removido: ");
		String nomeRemoverIssue = in.next();
        d.removerIssue(repositorio, nomeRemoverIssue);
		
	}
	
	public static void swapListaIssues(int c) {
		for(int i = c; i < d.getnIssues() - 1; i++) 
			d.setIssue(i, d.getIssue(i+1));
	}
	
	public static void editarIssue(Repositorio repositorio, int i, Issue iss) {
		d.editarIssue(repositorio, i, iss);
	}
	
	public static void listarIssues(Repositorio repositorio) {
		in.nextLine(); // Esvazia dados do teclado
	    ItemControle[] itemControles = repositorio.getListarItensControles();
	    int i = 0;

		boolean issueEncontrado = false;

	    for (ItemControle itemControle : itemControles) {
	        if (itemControle != null) {
	            System.out.println(i + " -> " + itemControle.toString());
				issueEncontrado = true;
	            i++;
	        } 
	    }

		if(!issueEncontrado){
			System.out.println("Não há nenhum issue cadastrado!");
		}
	}
	
}
