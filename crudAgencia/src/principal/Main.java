package principal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.SQLException;

import principal.DAO.AgenciaDAO;
import principal.DAO.ClienteDAO;
import principal.DAO.DestinosDAO;
import principal.DAO.FazDAO;
import principal.DAO.OfereceDAO;
import principal.DAO.PromocoesDAO;
import principal.DAO.PropoeDAO;
import principal.DAO.UsuarioDAO;
import principal.DAO.PassagensDAO;
import principal.DAO.CompraPassagemDAO;

public class Main {

	public static void main(String[] args) throws SQLException {

		ClienteDAO clienteDAO = new ClienteDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		AgenciaDAO agenciaDAO = new AgenciaDAO();
		DestinosDAO destinosDAO = new DestinosDAO();
		PromocoesDAO promocoesDAO = new PromocoesDAO();
		PassagensDAO passagensDAO = new PassagensDAO();
		CompraPassagemDAO comprasDAO = new CompraPassagemDAO();

		Scanner sc = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 8) {
			System.out.println("\n----------------------------------------------");
			System.out.println("Sistema da Agencia Turistica Noturna");
			System.out.println("----------------------------------------------");
			System.out.println("1. Menu da Agencia");
			System.out.println("2. Menu de Destinos");
			System.out.println("3. Menu das Promoções");
			System.out.println("4. Menu das Passagens");
			System.out.println("5. Menu dos Pedidos/Compras");
			System.out.println("6. Menu de Usuarios");
			System.out.println("7. Menu de Clientes");
			System.out.println("8. Sair");
			System.out.println("Escolha uma opção: ");

			opcao = sc.nextInt();

			switch (opcao) {
			case 1:

				boolean sairDoMenuAgencia = false;

				while (!sairDoMenuAgencia) {

					System.out.println("===============================");
					System.out.println("\nSistema de Gestão da Agencia");
					System.out
							.println("1. Cadastrar Agencia - Obs:Digite uma vez e sera desenvolvida automaticammente");
					System.out.println("2. Listar Agencias");
					System.out.println("3. Atualizar Agencia");
					System.out.println("4. Excluir Agencia");
					System.out.println("Escolha uma opção: ");
					int opcaoMenuAgencia = sc.nextInt();

					switch (opcaoMenuAgencia) {
					case 1:
						Agencia agencia1 = new Agencia(1, "Agencia Turistica Noturna",
								"A nossa Agência Viagens e no mercado a partir da união de profissionais experientes vindos de diferentes áreas: turismo e informação.\n"
										+ "A soma desses dois olhares conduziu a uma proposta de trabalho diferenciada,\n"
										+ "com o objetivo de oferecer um serviço não só com qualidade, mas com conteúdo.");
						agenciaDAO.criarAgencia(agencia1);
						System.out.println("\nAgencia cadastrada com sucesso!");
						break;
					case 2:
						System.out.println("");
						System.out.println("===============================");
						System.out.println("Agencia:");

						List<Agencia> agencias = null;

						try {
							agencias = agenciaDAO.mostrarAgencia();

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("\nNão Existe Agencia Criada");
						}

						for (Agencia a : agencias) {
							System.out.println("");
							System.out.println("Nome: " + a.getNome());
							System.out.println("Descrição: " + a.getDescricao());
						}

						break;
					case 3:

						System.out.println("");
						List<Agencia> agencias1 = agenciaDAO.mostrarAgencia();
						System.out.println("Lista de Agencias:");
						for (Agencia a : agencias1) {
							System.out.println("Id: " + a.getIdAgencia());
							System.out.println("Nome: " + a.getNome());
							System.out.println("Descrição: " + a.getDescricao());
						}

						System.out.print("\nID da Agencia para atualização: ");
						int agenciaIdAtualizar = sc.nextInt();
						Agencia AgenciaAtualizar = agenciaDAO.buscarAgencia(agenciaIdAtualizar);
						if (AgenciaAtualizar != null) {
							System.out.println("Novo Nome da Agencia: ");
							sc.nextLine();
							AgenciaAtualizar.setNome(sc.nextLine());
							System.out.println("Nova Descrição: ");
							AgenciaAtualizar.setDescricao(sc.nextLine());
							agenciaDAO.atualizarAgencia(AgenciaAtualizar);
							System.out.println("\nAgencia atualizada com sucesso!");
						} else {
							System.out.println("\nAgencia não encontrada.");
						}
						break;
					case 4:
						System.out.println("");
						List<Agencia> agencias2 = agenciaDAO.mostrarAgencia();
						System.out.println("Lista de Agencias:");
						for (Agencia a : agencias2) {
							System.out.println("Id: " + a.getIdAgencia());
							System.out.println("Nome: " + a.getNome());
							System.out.println("Descrição: " + a.getDescricao());
						}

						System.out.print("\nID da Agencia para exclusão: ");
						int agenciaIdExcluir = sc.nextInt();
						Agencia agenciaExcluir = agenciaDAO.buscarAgencia(agenciaIdExcluir);
						if (agenciaExcluir != null) {
							agenciaDAO.excluirAgencia(agenciaIdExcluir);
							System.out.println("\nAgencia excluída com sucesso!");
						} else {
							System.out.println("\nAgencia não encontrada.");
						}
						break;
					default:
						System.out.println("\nOpção inválida. Tente novamente.");
						break;
					}
					System.out.println("");
					System.out.println("====================");
					System.out.println(
							"Se deseja continuar no Menu da Agencia\nDigite qualquer Número diferente de 5(!=5)");
					System.out.println("5. Sair");
					System.out.println("====================");
					System.out.println("Digite: ");
					int entrada = sc.nextInt();
					if (entrada == 5) {
						sairDoMenuAgencia = true;

					}
				}
				break;
			case 2:

				boolean sairDoMenuDestino = false;

				while (!sairDoMenuDestino) {

					System.out.println("===============================");
					System.out.println("\nSistema de Gestão de Destinos");
					System.out.println("1. Cadastrar Destino");
					System.out.println("2. Listar Destinos");
					System.out.println("3. Atualizar Destino");
					System.out.println("4. Excluir Destino");
					System.out.println("Escolha uma opção: ");
					int opcaoMenuDestino = sc.nextInt();

					switch (opcaoMenuDestino) {
					case 1:
						Destinos destino1 = new Destinos();
						System.out.println("");
						System.out.println("Nome do Destino: ");
						sc.nextLine();
						destino1.setNome(sc.nextLine());
						System.out.println("Descrição: ");
						destino1.setDescricao(sc.nextLine());
						System.out.println("Preço Médio: ");
						destino1.setPreco(sc.nextDouble());
						destinosDAO.criarDestinos(destino1);
						System.out.println("\nDestino cadastrado com sucesso!");
						break;
					case 2:
						System.out.println("");
						System.out.println("===============================");
						System.out.println("Destinos:");

						List<Destinos> destinos = null;

						try {
							destinos = destinosDAO.listarDestinos();

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Não Existe Destinos Fornecidos");
						}

						for (Destinos d : destinos) {
							System.out.println("");
							System.out.println("Nome: " + d.getNome());
							System.out.println("Descrição: " + d.getDescricao());
							System.out.println("Preço Médio: " + d.getPreco());
						}

						break;
					case 3:
						System.out.println("");
						List<Destinos> destino = destinosDAO.listarDestinos();
						System.out.println("Lista de Destinos:");
						for (Destinos d : destino) {
							System.out.println("Id: " + d.getIdDestino());
							System.out.println("Nome: " + d.getNome());
							System.out.println("Descrição: " + d.getDescricao());
							System.out.println("Preço Médio: " + d.getPreco());
						}

						System.out.println("\nID dO Destino para atualização: ");
						int destinoIdAtualizar = sc.nextInt();
						Destinos destinoAtualizar = destinosDAO.buscarDestino(destinoIdAtualizar);
						if (destinoAtualizar != null) {
							System.out.println("Novo Nome do Destino: ");
							sc.nextLine();
							destinoAtualizar.setNome(sc.nextLine());
							System.out.println("Nova Descrição: ");
							destinoAtualizar.setDescricao(sc.nextLine());
							System.out.print("Novo Preço Médio: ");
							destinoAtualizar.setPreco(sc.nextDouble());
							destinosDAO.atualizarDestinos(destinoAtualizar);
							System.out.println("\nDestino atualizado com sucesso!");
						} else {
							System.out.println("\nDestino não encontrada.");
						}
						break;
					case 4:
						System.out.println("");
						List<Destinos> destino2 = destinosDAO.listarDestinos();
						System.out.println("Lista de Destinos:");
						for (Destinos d : destino2) {
							System.out.println("Id: " + d.getIdDestino());
							System.out.println("Nome: " + d.getNome());
							System.out.println("Descrição: " + d.getDescricao());
							System.out.println("Preço Médio: " + d.getPreco());
						}

						System.out.print("\nID do Destino para exclusão: ");
						int destinoIdExcluir = sc.nextInt();
						Destinos destinoExcluir = destinosDAO.buscarDestino(destinoIdExcluir);
						if (destinoExcluir != null) {
							destinosDAO.excluirDestino(destinoIdExcluir);
							System.out.println("\nDestino excluído com sucesso!");
						} else {
							System.out.println("\nDestino não encontrado.");
						}

						break;
					default:
						System.out.println("\nOpção inválida. Tente novamente.");
						break;
					}
					System.out.println("");
					System.out.println("====================");
					System.out.println(
							"Se deseja continuar no Menu de Destinos\nDigite qualquer Número diferente de 5(!=5)");
					System.out.println("5. Sair");
					System.out.println("====================");
					System.out.println("Digite: ");
					int entrada1 = sc.nextInt();
					if (entrada1 == 5) {
						sairDoMenuDestino = true;

					}

				}

				break;
			case 3:

				boolean sairDoMenuPromocoes = false;

				while (!sairDoMenuPromocoes) {

					System.out.println("===============================");
					System.out.println("\nSistema de Gestão de Promoções");
					System.out.println("1. Cadastrar Promoção");
					System.out.println("2. Listar Promoções");
					System.out.println("3. Atualizar Promoções");
					System.out.println("4. Excluir Promoção");
					System.out.println("Escolha uma opção: ");
					int opcaoMenuPromocoes = sc.nextInt();

					switch (opcaoMenuPromocoes) {
					case 1:
						Promocoes promocao1 = new Promocoes();
						System.out.println("");
						System.out.println("Nome da Promoção: ");
						sc.nextLine();
						promocao1.setNome(sc.nextLine());
						System.out.println("Descrição: ");
						promocao1.setDescricao(sc.nextLine());
						System.out.println("Preço Promocionall(%): ");
						promocao1.setPrecoPromocional(sc.nextInt());
						System.out.println("Data de Inicio da Promoção (dd/mm/yyyy): ");
						String dataString = sc.next();
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Date dataInicioPromocao = sdf.parse(dataString);
							promocao1.setDataDeInicio(dataInicioPromocao);
						} catch (ParseException e) {
							System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
						}

						System.out.println("\nData de Finalização da Promoção (dd/mm/yyyy): ");
						String dataString1 = sc.next();
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Date dataFinalizacaoPromocao = sdf.parse(dataString1);
							promocao1.setDataDeTermino(dataFinalizacaoPromocao);

						} catch (ParseException e) {
							System.out.println("\nFormato de data inválido. Use dd/mm/yyyy.");
						}

						System.out.println("");
						System.out.println("===============================");
						System.out.println("Destinos:");

						List<Destinos> destinos = null;

						try {
							destinos = destinosDAO.listarDestinos();

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("\nNão Existe Destinos Fornecidos");
						}

						for (Destinos d : destinos) {
							System.out.println("");
							System.out.println("Id: " + d.getIdDestino());
							System.out.println("Nome: " + d.getNome());
							System.out.println("Descrição: " + d.getDescricao());
							System.out.println("Preço Médio: " + d.getPreco());
						}

						System.out.println("\nDigite o Id do Destino que deseja Associar a Promoção:");
						int destinoId = sc.nextInt();
						Destinos destinoConsulta = destinosDAO.buscarDestino(destinoId);
						if (destinoConsulta != null) {
							promocao1.setDestinos(destinoConsulta);
							promocoesDAO.criarPromocoes(promocao1);
							System.out.println("\nPromoção cadastrada com sucesso!");
						} else {
							System.out.println("\nDestino não encontrado");
						}
						break;
					case 2:
						System.out.println("");
						System.out.println("===============================");
						System.out.println("Promoções:");

						List<Promocoes> promocoes = null;

						try {
							promocoes = promocoesDAO.listarPromocoes();

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("\nNão Existe Promoções Fornecidas");
						}

						for (Promocoes p : promocoes) {
							System.out.println("");
							System.out.println("Nome: " + p.getNome());
							System.out.println("Descrição: " + p.getDescricao());
							System.out.println("Desconto: " + p.getPrecoPromocional() + "%");
							System.out.println("Data de Incio da Promoção: " + p.getDataDeInicio());
							System.out.println("Data de Finalização da Promoção: " + p.getDataDeTermino());
							System.out.println("Destino Associado: " + p.getDestinos().getIdDestino());
						}

						break;
					case 3:

						System.out.println("");
						List<Promocoes> promocao = promocoesDAO.listarPromocoes();
						System.out.println("Lista de Promoções:");
						for (Promocoes p : promocao) {
							System.out.println("");
							System.out.println("Nome: " + p.getIdPromocao());
							System.out.println("Nome: " + p.getNome());
							System.out.println("Descrição: " + p.getDescricao());
							System.out.println("Desconto: " + p.getPrecoPromocional() + "%");
							System.out.println("Data de Incio da Promoção: " + p.getDataDeInicio());
							System.out.println("Data de Finalização da Promoção: " + p.getDataDeTermino());
							System.out.println("Destino Associado: " + p.getDestinos().getIdDestino());

						}

						System.out.println("");
						System.out.print("ID da Promoção para atualização: ");
						int promocaoIdAtualizar = sc.nextInt();
						Promocoes promocaoAtualizar = promocoesDAO.buscarPromocao(promocaoIdAtualizar);
						if (promocaoAtualizar != null) {
							System.out.print("Novo Nome da Promoção: ");
							sc.nextLine();
							promocaoAtualizar.setNome(sc.nextLine());
							System.out.print("Nova Descrição: ");
							promocaoAtualizar.setDescricao(sc.nextLine());
							System.out.print("Novo Preço Promocional(%): ");
							promocaoAtualizar.setPrecoPromocional(sc.nextInt());

							System.out.println("Nova Data de Inicio da Promoção (dd/mm/yyyy): ");
							String dataString3 = sc.next();
							try {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								Date dataInicioPromocaoAtualizada = sdf.parse(dataString3);
								promocaoAtualizar.setDataDeInicio(dataInicioPromocaoAtualizada);
							} catch (ParseException e) {
								System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
							}

							System.out.println("Nova Data de Finalização da Promoção (dd/mm/yyyy): ");
							String dataString4 = sc.next();
							try {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								Date dataFinalizacaoPromocaoAtualizada = sdf.parse(dataString4);
								promocaoAtualizar.setDataDeTermino(dataFinalizacaoPromocaoAtualizada);

							} catch (ParseException e) {
								System.out.println("\nFormato de data inválido. Use dd/mm/yyyy.");
							}

							System.out.println("\nDeseja mudar o Destino associado? [s/n]");
							String deseja = sc.next();
							if (deseja == "s") {

								System.out.println("Digite o Id do Novo Destino que deseja Associar a Promoção:");
								int destinoId1 = sc.nextInt();
								Destinos destinoConsulta1 = destinosDAO.buscarDestino(destinoId1);
								if (destinoConsulta1 != null) {
									promocaoAtualizar.setDestinos(destinoConsulta1);
									promocoesDAO.atualizarPromocao(promocaoAtualizar);
									System.out.println("\nPromoção atualizada com sucesso!");
								} else {
									System.out.println("\nDestino não encontrado");
								}
							}

							if (deseja == "s") {

							} else {
								promocoesDAO.atualizarPromocao(promocaoAtualizar);
								System.out.println("\nPromoção atualizada com sucesso!");
							}

						} else {
							System.out.println("\nPromoção não encontrada.");
						}
						break;
					case 4:
						System.out.println("");
						List<Promocoes> promocao2 = promocoesDAO.listarPromocoes();
						System.out.println("Lista de Promoções:");
						for (Promocoes p : promocao2) {
							System.out.println("");
							System.out.println("Nome: " + p.getIdPromocao());
							System.out.println("Nome: " + p.getNome());
							System.out.println("Descrição: " + p.getDescricao());
							System.out.println("Desconto: " + p.getPrecoPromocional() + "%");
							System.out.println("Data de Incio da Promoção: " + p.getDataDeInicio());
							System.out.println("Data de Finalização da Promoção: " + p.getDataDeTermino());
							System.out.println("Id do Destino Associado: " + p.getDestinos().getIdDestino());

						}

						System.out.print("\nID da Promoção para exclusão: ");
						int promocaoIdExcluir = sc.nextInt();
						Promocoes promocaoExcluir = promocoesDAO.buscarPromocao(promocaoIdExcluir);
						if (promocaoExcluir != null) {
							promocoesDAO.excluirPromocao(promocaoIdExcluir);
							System.out.println("\nPromoção excluída com sucesso!");
						} else {
							System.out.println("\nPromoção não encontrada.");
						}
						break;
					default:
						System.out.println("\nOpção inválida. Tente novamente.");
						break;
					}
					System.out.println("");
					System.out.println("====================");
					System.out.println(
							"Se deseja continuar no Menu de Promoções\nDigite qualquer Número diferente de 5(!=5)");
					System.out.println("5. Sair");
					System.out.println("====================");
					System.out.print("Digite: ");
					int entrada2 = sc.nextInt();
					if (entrada2 == 5) {
						sairDoMenuPromocoes = true;
					}

				}

				break;
			case 4:
				boolean sairDoMenuPassagens = false;

				while (!sairDoMenuPassagens) {

					System.out.println("===============================");
					System.out.println("\nSistema de Gestão de Passagens");
					System.out.println("1. Cadastrar Passagens");
					System.out.println("2. Listar Passagens");
					System.out.println("3. Atualizar Passagem");
					System.out.println("4. Excluir Passagem");
					System.out.println("Escolha uma opção: ");
					int opcaoMenuPassagem = sc.nextInt();

					switch (opcaoMenuPassagem) {
					case 1:
						Passagens passagens1 = new Passagens();

						System.out.println("");
						System.out.println("Preço da Passagem: ");
						passagens1.setPrecoPassagem(sc.nextDouble());
						System.out.println("Número do Voo: ");
						passagens1.setNumeroDeVoo(sc.nextInt());

						System.out.println("Data da Partida do Voo (dd/mm/yyyy): ");
						String dataString8 = sc.next();
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Date dataDePartidaDoVoo = sdf.parse(dataString8);
							passagens1.setDataDePartida(dataDePartidaDoVoo);
						} catch (ParseException e) {
							System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
						}

						System.out.println("Data do Retorno do Voo (dd/mm/yyyy): ");
						String dataString9 = sc.next();
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Date dataDeRetoronoDoVoo = sdf.parse(dataString9);
							passagens1.setDataDeRetorno(dataDeRetoronoDoVoo);

						} catch (ParseException e) {
							System.out.println("\nFormato de data inválido. Use dd/mm/yyyy.");
						}

						passagensDAO.criarPassagem(passagens1);
						System.out.println("\nPassagem cadastrada com sucesso!");
						break;
					case 2:
						System.out.println("");
						System.out.println("===============================");
						System.out.println("Passagens Cadastradas:");

						List<Passagens> passagens = null;

						try {
							passagens = passagensDAO.listarPassagens();

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("\nNão Existe Passagem cadastrada");
						}

						for (Passagens p : passagens) {
							System.out.println("");
							System.out.println("Preço da Passagem: " + p.getPrecoPassagem());
							System.out.println("Número do Voo: " + p.getNumeroDeVoo());
							System.out.println("Data de Partida do Voo: " + p.getDataDePartida());
							System.out.println("Data de Retorno do Voo: " + p.getDataDeRetorno());
						}

						break;
					case 3:

						System.out.println("");
						List<Passagens> passagen = passagensDAO.listarPassagens();
						System.out.println("Lista de Passagens:");
						for (Passagens p : passagen) {
							System.out.println("");
							System.out.println("Preço da Passagem: " + p.getPrecoPassagem());
							System.out.println("Número do Voo: " + p.getNumeroDeVoo());
							System.out.println("Data de Partida do Voo: " + p.getDataDePartida());
							System.out.println("Data de Retorno do Voo: " + p.getDataDeRetorno());
						}

						System.out.print("\nID da Passagem para atualização: ");
						int passagemIdAtualizar = sc.nextInt();
						Passagens passagemAtualizar = passagensDAO.buscarPassagens(passagemIdAtualizar);
						if (passagemAtualizar != null) {
							System.out.println("");
							System.out.println("Preço da Passagem: ");
							passagemAtualizar.setPrecoPassagem(sc.nextDouble());
							System.out.println("Número do Voo: ");
							passagemAtualizar.setNumeroDeVoo(sc.nextInt());

							System.out.println("Data da Partida do Voo (dd/mm/yyyy): ");
							String dataString10 = sc.next();
							try {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								Date dataDePartidaDoVoo = sdf.parse(dataString10);
								passagemAtualizar.setDataDePartida(dataDePartidaDoVoo);
							} catch (ParseException e) {
								System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
							}

							System.out.println("Data do Retorno do Voo (dd/mm/yyyy): ");
							String dataString11 = sc.next();
							try {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								Date dataDeRetoronoDoVoo = sdf.parse(dataString11);
								passagemAtualizar.setDataDeRetorno(dataDeRetoronoDoVoo);

							} catch (ParseException e) {
								System.out.println("\nFormato de data inválido. Use dd/mm/yyyy.");
							}

							passagensDAO.atualizarPassagem(passagemAtualizar);
							System.out.println("\nPassagem atualizada com sucesso!");
						} else {
							System.out.println("\nPassagem não encontrada.");
						}
						break;
					case 4:
						System.out.println("");
						List<Passagens> passagen2 = passagensDAO.listarPassagens();
						System.out.println("Lista de Passagens:");
						for (Passagens p : passagen2) {
							System.out.println("");
							System.out.println("Preço da Passagem: " + p.getPrecoPassagem());
							System.out.println("Número do Voo: " + p.getNumeroDeVoo());
							System.out.println("Data de Partida do Voo: " + p.getDataDePartida());
							System.out.println("Data de Retorno do Voo: " + p.getDataDeRetorno());
						}

						System.out.print("\nID da Agencia para exclusão: ");
						int passagemIdExcluir = sc.nextInt();
						Passagens passagemExcluir = passagensDAO.buscarPassagens(passagemIdExcluir);
						if (passagemExcluir != null) {
							passagensDAO.excluirPassagem(passagemIdExcluir);
							System.out.println("\nPassagem excl4uída com sucesso!");
						} else {
							System.out.println("\nPassagem não encontrada.");
						}
						break;
					default:
						System.out.println("\nOpção inválida. Tente novamente.");
						break;
					}
					System.out.println("");
					System.out.println("====================");
					System.out.println(
							"Se deseja continuar no Menu de Passagens\nDigite qualquer Número diferente de 5(!=5)");
					System.out.println("5. Sair");
					System.out.println("====================");
					System.out.println("Digite: ");
					int entrada = sc.nextInt();
					if (entrada == 5) {
						sairDoMenuPassagens = true;

					}
				}
				break;

			case 5:
				boolean sairDoMenuPedidos = false;

				while (!sairDoMenuPedidos) {

					System.out.println("===============================");
					System.out.println("\nSistema de Gestão de Pedidos/Compras");
					System.out.println("1. Cadastrar Pedido");
					System.out.println("2. Listar Pedidos");
					System.out.println("3. Atualizar Pedido");
					System.out.println("4. Excluir Pedido");
					System.out.println("Escolha uma opção: ");
					int opcaoMenuPedidos = sc.nextInt();

					switch (opcaoMenuPedidos) {
					case 1:
						CompraPassagem compra1 = new CompraPassagem();
						System.out.println("");
						System.out.println("Valor Pago: ");
						compra1.setValorPago(sc.nextDouble());
						sc.nextLine();
						System.out.println("Status: ");
						compra1.setStatus(sc.nextLine());

						System.out.println("Data da Compra (dd/mm/yyyy): ");
						String dataStringPedido = sc.next();
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							Date dataDaCompra = sdf.parse(dataStringPedido);
							compra1.setDataDaCompra(dataDaCompra);

							System.out.println("");
							System.out.println("===============================");
							System.out.println("Passagens:");

							List<Passagens> passagens = null;

							try {
								passagens = passagensDAO.listarPassagens();

							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("\nNão Existe Passagens Fornecidas");
							}

							for (Passagens p : passagens) {
								System.out.println("");
								System.out.println("Id " + p.getIdPassagem());
								System.out.println("Preço da Passagem: " + p.getPrecoPassagem());
								System.out.println("Número do Voo: " + p.getNumeroDeVoo());
								System.out.println("Data de Partida do Voo: " + p.getDataDePartida());
								System.out.println("Data de Retorno do Voo: " + p.getDataDeRetorno());
							}

							System.out.println("\nDigite o Id da Passagem que está liagado a essa Compra:");
							int passagemId = sc.nextInt();
							Passagens passagemConsulta = passagensDAO.buscarPassagens(passagemId);
							if (passagemConsulta != null) {
								compra1.setPassagem(passagemConsulta);
								comprasDAO.criarCompraPassagem(compra1);
								System.out.println("\nPedido cadastrado com sucesso!");
							} else {
								System.out.println("\nPassagem não encontrada");
							}

						} catch (ParseException e) {
							System.out.println("\nFormato de data inválido. Use dd/mm/yyyy.");
							System.out.println("\nTente Novamente");
						}
						break;
					case 2:
						System.out.println("");
						System.out.println("===============================");
						System.out.println("Pedidos:");

						List<CompraPassagem> compraspassagens = null;

						try {
							compraspassagens = comprasDAO.listarCompras();

							for (CompraPassagem cp : compraspassagens) {
								System.out.println("");
								System.out.println("Data da Compra " + cp.getDataDaCompra());
								System.out.println("Valor Pago: " + cp.getValorPago());
								System.out.println("Status: " + cp.getStatus());
								System.out.println("Id da Passagem relacionada: " + cp.getPassagem().getIdPassagem());
							}

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("\nNão Existe Pedidos Feitos!");
						}

						break;
					case 3:

						System.out.println("");
						List<CompraPassagem> compras = comprasDAO.listarCompras();
						System.out.println("Lista de Pedidos/Compras:");
						for (CompraPassagem cp : compras) {
							System.out.println("");
							System.out.println("Data da Compra " + cp.getDataDaCompra());
							System.out.println("Valor Pago: " + cp.getValorPago());
							System.out.println("Status: " + cp.getStatus());
							System.out.println("Id da Passagem relacionada: " + cp.getPassagem().getIdPassagem());
						}

						System.out.println("");
						System.out.print("ID do Pedido/Compra para atualização: ");
						int compraIdAtualizar = sc.nextInt();
						CompraPassagem compraAtualizar = comprasDAO.buscarCompra(compraIdAtualizar);
						if (compraAtualizar != null) {
							System.out.println("");
							System.out.println("Valor Pago: ");
							compraAtualizar.setValorPago(sc.nextDouble());
							System.out.println("Status: ");
							compraAtualizar.setStatus(sc.nextLine());

							System.out.println("Data da Compra (dd/mm/yyyy): ");
							String dataStringPedido1 = sc.next();
							try {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								Date dataDaCompra = sdf.parse(dataStringPedido1);
								compraAtualizar.setDataDaCompra(dataDaCompra);
							} catch (ParseException e) {
								System.out.println("\nFormato de data inválido. Use dd/mm/yyyy.");
							}

							System.out.println("\nDeseja mudar a Passagem associada? [s/n]");
							String desejaM = sc.next();
							if (desejaM == "s") {

								System.out.println("Digite o Id da Nova Passagem foi efetuada a compra:");
								int compraId = sc.nextInt();
								Passagens passagemConsultar = passagensDAO.buscarPassagens(compraId);
								if (passagemConsultar != null) {
									compraAtualizar.setPassagem(passagemConsultar);
									comprasDAO.atualizarCompra(compraAtualizar);
									System.out.println("\nPedido atualizado com sucesso!");
								} else {
									System.out.println("\nPassagem não encontrada");
								}
							}

							if (desejaM == "s") {

							} else {
								comprasDAO.atualizarCompra(compraAtualizar);
								System.out.println("\nPedido atualizado com sucesso!");
							}

						} else {
							System.out.println("\nPedido não encontrado.");
						}
						break;
					case 4:
						System.out.println("");
						List<CompraPassagem> comprasp = comprasDAO.listarCompras();
						System.out.println("Lista de Pedidos/Compras:");
						for (CompraPassagem cp : comprasp) {
							System.out.println("");
							System.out.println("Data da Compra " + cp.getDataDaCompra());
							System.out.println("Valor Pago: " + cp.getValorPago());
							System.out.println("Status: " + cp.getStatus());
							System.out.println("Id da Passagem relacionada: " + cp.getPassagem().getIdPassagem());
						}

						System.out.print("\nID do Pedido para exclusão: ");
						int pedidoIdExcluir = sc.nextInt();
						Promocoes compraExcluir = promocoesDAO.buscarPromocao(pedidoIdExcluir);
						if (compraExcluir != null) {
							comprasDAO.buscarCompra(pedidoIdExcluir);
							System.out.println("\nPedido excluído com sucesso!");
						} else {
							System.out.println("\nPedido não encontrado.");
						}
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
						break;
					}
					System.out.println("");
					System.out.println("====================");
					System.out.println(
							"Se deseja continuar no Menu de Pedidos/Compras\nDigite qualquer Número diferente de 5(!=5)");
					System.out.println("5. Sair");
					System.out.println("====================");
					System.out.print("Digite: ");
					int entrada2 = sc.nextInt();
					if (entrada2 == 5) {
						sairDoMenuPedidos = true;
					}

				}

				break;

			case 6:

				boolean sairDoMenuUsuario = false;

				while (!sairDoMenuUsuario) {

					System.out.println("===============================");
					System.out.println("\nSistema de Gestão de Usuarios");
					System.out.println("1. Cadastrar Usuarios");
					System.out.println("2. Listar Usuarios");
					System.out.println("3. Atualizar Usuario");
					System.out.println("4. Excluir Usuario");
					System.out.println("Escolha uma opção: ");
					int opcaoMenuUsuario = sc.nextInt();

					switch (opcaoMenuUsuario) {
					case 1:
						Usuario usuario1 = new Usuario();
						System.out.println("");
						System.out.println("Nome do Usuario: ");
						sc.nextLine();
						usuario1.setNome(sc.nextLine());
						System.out.println("Email de Login: ");
						usuario1.setLogin(sc.nextLine());
						System.out.println("Senha: ");
						usuario1.setSenha(sc.nextInt());
						System.out.println("Tipo de Acesso [Adm/User]: ");
						usuario1.setPermissaoDeAcesso(sc.next());
						usuarioDAO.criarUsuario(usuario1);
						System.out.println("\nUsuario cadastrado com sucesso!");
						break;
					case 2:
						System.out.println("");
						System.out.println("===============================");
						System.out.println("Usuarios:");

						List<Usuario> usuarios = null;

						try {
							usuarios = usuarioDAO.listarUsuarios();

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("\nNão Existe Usuario cadastrado");
						}

						for (Usuario u : usuarios) {
							System.out.println("");
							System.out.println("Nome: " + u.getNome());
							System.out.println("Email de Login: " + u.getLogin());
							System.out.println("Senha: " + u.getSenha());
							System.out.println("Tipo de Acesso [Adm/User]: " + u.getPermissaoDeAcesso());
						}

						break;
					case 3:

						System.out.println("");
						List<Usuario> usuarios2 = usuarioDAO.listarUsuarios();
						System.out.println("Lista de Usuarios:");
						for (Usuario u : usuarios2) {
							System.out.println("Id: " + u.getIdUsuario());
							System.out.println("Nome: " + u.getNome());
							System.out.println("Email de Login: " + u.getLogin());
							System.out.println("Senha: " + u.getSenha());
							System.out.println("Tipo de Acesso [Adm/User]: " + u.getPermissaoDeAcesso());
						}

						System.out.print("\nID do Usuario para atualização: ");
						int usuarioIdAtualizar = sc.nextInt();
						Usuario usuarioAtualizar = usuarioDAO.buscarUsuario(usuarioIdAtualizar);
						if (usuarioAtualizar != null) {
							System.out.println("Nome do Usuario: ");
							sc.nextLine();
							usuarioAtualizar.setNome(sc.nextLine());
							System.out.println("Email de Login: ");
							usuarioAtualizar.setLogin(sc.nextLine());
							System.out.println("Senha: ");
							usuarioAtualizar.setSenha(sc.nextInt());
							System.out.println("Tipo de Acesso [Adm/User]: ");
							usuarioAtualizar.setPermissaoDeAcesso(sc.next());
							usuarioDAO.atualizarUsuario(usuarioAtualizar);
							System.out.println("\nUsuario atualizado com sucesso!");
						} else {
							System.out.println("\nUsuario não encontrado.");
						}
						break;

					case 4:
						System.out.println("");
						List<Usuario> usuario3 = usuarioDAO.listarUsuarios();
						for (Usuario u : usuario3) {
							System.out.println("Id: " + u.getIdUsuario());
							System.out.println("Nome: " + u.getNome());
							System.out.println("Email de Login: " + u.getLogin());
							System.out.println("Senha: " + u.getSenha());
							System.out.println("Tipo de Acesso [Adm/User]: " + u.getPermissaoDeAcesso());
						}

						System.out.print("\nID do Usuario para excluir: ");
						int usuarioIdExcluir = sc.nextInt();
						Usuario usuarioExcluir = usuarioDAO.buscarUsuario(usuarioIdExcluir);
						if (usuarioExcluir != null) {
							usuarioDAO.excluirUsuario(usuarioIdExcluir);
							System.out.println("\nUsuario excluído com sucesso!");
						} else {
							System.out.println("\nUsuario não encontrado.");
						}
						break;
					default:
						System.out.println("\nOpção inválida. Tente novamente.");
						break;
					}
					System.out.println("");
					System.out.println("====================");
					System.out.println(
							"Se deseja continuar no Menu de Usuarios\nDigite qualquer Número diferente de 5(!=5)");
					System.out.println("5. Sair");
					System.out.println("====================");
					System.out.println("Digite: ");
					int entrada = sc.nextInt();
					if (entrada == 5) {
						sairDoMenuUsuario = true;

					}
				}
				break;
			case 7:

				boolean sairDoMenuCliente = false;

				while (!sairDoMenuCliente) {

					System.out.println("===============================");
					System.out.println("\nSistema de Gestão de Clientes");
					System.out.println("1. Cadastrar Clientes");
					System.out.println("2. Listar Clientes");
					System.out.println("3. Atualizar Clientes");
					System.out.println("4. Excluir Clientes");
					System.out.println("Escolha uma opção: ");
					int opcaoMenuCliente = sc.nextInt();

					switch (opcaoMenuCliente) {
					case 1:
						Cliente cliente1 = new Cliente();
						System.out.println("");
						System.out.println("Nome do Cliente: ");
						sc.nextLine();
						cliente1.setNome(sc.nextLine());
						System.out.println("Email: ");
						cliente1.setEmail(sc.nextLine());
						System.out.println("Telefone: ");
						cliente1.setTelefone(sc.nextInt());
						sc.nextLine();
						System.out.println("Endereço: ");
						cliente1.setEndereco(sc.nextLine());

						System.out.println("");
						System.out.println("===============================");
						System.out.println("Usuarios:");

						List<Usuario> usuarios3 = null;

						try {
							usuarios3 = usuarioDAO.listarUsuarios();

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("\nNão Existe Usuarios Cadastrados");
						}

						for (Usuario u : usuarios3) {
							System.out.println("");
							System.out.println("Id: " + u.getIdUsuario());
							System.out.println("Nome: " + u.getNome());
							System.out.println("EMail de Login: " + u.getLogin());
							System.out.println("Senha: " + u.getSenha());
							System.out.println("Tipo de Acesso[Adm/User]: " + u.getPermissaoDeAcesso());
						}

						System.out.println("\nDigite o Id do Usuario que esteja Associado a esse Cliente:");
						System.out.println("");
						int usuarioId = sc.nextInt();
						 sc.nextLine();
						Usuario usuarioConsulta = usuarioDAO.buscarUsuario(usuarioId);
						if (usuarioConsulta != null) {
							cliente1.setUsuario(usuarioConsulta);

							System.out.println("");
							System.out.println("===============================");
							System.out.println("Agencias:");

							List<Agencia> agencia4 = null;

							try {
								agencia4 = agenciaDAO.mostrarAgencia();

							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("\nNão Existe Agencia Cadastrada");
							}

							for (Agencia a : agencia4) {
								System.out.println("");
								System.out.println("Id: " + a.getIdAgencia());
								System.out.println("Nome: " + a.getNome());
								System.out.println("EMail de Login: " + a.getDescricao());
							}

							System.out.println("\nDigite o Id da Agencia Associará a esse Cliente:");
							int agenciaId = sc.nextInt();
							 sc.nextLine();
							Agencia agenciaConsulta = agenciaDAO.buscarAgencia(agenciaId);
							if (agenciaConsulta != null) {
								cliente1.setAgencia(agenciaConsulta);
								clienteDAO.criarCliente(cliente1);
								System.out.println("\nCliente cadastrado com sucesso!");
							} else {
								System.out.println("\nAgencia não encontrada.");
							}
						} else {
							System.out.println("\nUsuario não encontrado");
						}
						break;

					case 2:
						System.out.println("");
						System.out.println("===============================");
						System.out.println("Clientes:");

						List<Cliente> clientes = null;

						try {
							clientes = clienteDAO.listarClientes();

						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("\nNão Existe Clientes cadastrados");
						}

						for (Cliente c : clientes) {
							System.out.println("");
							System.out.println("Nome: " + c.getNome());
							System.out.println("Email de Login: " + c.getEmail());
							System.out.println("Telefone: " + c.getTelefone());
							System.out.println("Endereço: " + c.getEndereco());
							System.out.println("Id do Usuario associado: " + c.getUsuario().getIdUsuario());
							System.out.println("Id da Agencia associada: " + c.getAgencia().getIdAgencia());
						}

						break;
					case 3:

						System.out.println("");
						List<Cliente> cliente = clienteDAO.listarClientes();
						System.out.println("Lista de Clientes:");
						for (Cliente c : cliente) {
							System.out.println("");
							System.out.println("Nome: " + c.getNome());
							System.out.println("Email de Login: " + c.getEmail());
							System.out.println("Telefone: " + c.getTelefone());
							System.out.println("Endereço: " + c.getEndereco());
							System.out.println("Id do Usuario associado: " + c.getUsuario().getIdUsuario());
							System.out.println("Id da Agencia associada: " + c.getAgencia().getIdAgencia());
						}

						System.out.println("");
						System.out.print("ID do Cliente para atualização: ");
						int clienteIdAtualizar = sc.nextInt();
						Cliente clienteAtualizar = clienteDAO.buscarCliente(clienteIdAtualizar);
						if (clienteAtualizar != null) {
							System.out.print("Nome do Cliente: ");
							sc.nextLine();
							clienteAtualizar.setNome(sc.nextLine());
							System.out.println("Email: ");
							clienteAtualizar.setEmail(sc.nextLine());
							System.out.println("Telefone: ");
							clienteAtualizar.setTelefone(sc.nextInt());
							System.out.println("Endereço: ");
							clienteAtualizar.setEndereco(sc.nextLine());

							System.out.println("Deseja mudar a Usuario associado? [s/n]");
							String deseja1 = sc.next();
							if (deseja1 == "s") {

								System.out.println("Digite o Id do novo Usuario que deseja associar a esse Cliente:");
								int usuarioId1 = sc.nextInt();
								Usuario usuarioConsulta1 = usuarioDAO.buscarUsuario(usuarioId1);
								if (usuarioConsulta1 != null) {
									clienteAtualizar.setUsuario(usuarioConsulta1);
									clienteDAO.atualizarCliente(clienteAtualizar);
									System.out.println("\nCliente atualizado com sucesso!");
								} else {
									System.out.println("\nUsuario não encontrado");
								}
							}

							if (deseja1 == "s") {

							} else {
								clienteDAO.atualizarCliente(clienteAtualizar);
								System.out.println("\nCliente atualizado com sucesso!");
							}

						} else {
							System.out.println("\nCliente não encontrada.");
						}

						break;
					case 4:
						System.out.println("");
						List<Cliente> cliente0 = clienteDAO.listarClientes();
						System.out.println("Lista de Clientes:");
						for (Cliente c : cliente0) {
							System.out.println("");
							System.out.println("Nome: " + c.getNome());
							System.out.println("Email de Login: " + c.getEmail());
							System.out.println("Telefone: " + c.getTelefone());
							System.out.println("Endereço: " + c.getEndereco());
							System.out.println("Id do Usuario associado: " + c.getUsuario().getIdUsuario());
							System.out.println("Id da Agencia associada: " + c.getAgencia().getIdAgencia());
						}

						System.out.print("\nID do Cliente para excluir: ");
						int clienteIdExcluir = sc.nextInt();
						Cliente clienteExcluir = clienteDAO.buscarCliente(clienteIdExcluir);
						if (clienteExcluir != null) {
							clienteDAO.excluirCliente(clienteIdExcluir);
							System.out.println("\nCliente excluído com sucesso!");
						} else {
							System.out.println("\nCliente não encontrado.");
						}
						break;
					default:
						System.out.println("\nOpção inválida. Tente novamente.");
						break;
					}
					System.out.println("");
					System.out.println("====================");
					System.out.println(
							"Se deseja continuar no Menu de Clientes\nDigite qualquer Número diferente de 5(!=5)");
					System.out.println("5. Sair");
					System.out.println("====================");
					System.out.print("Digite: ");
					int entrada2 = sc.nextInt();
					if (entrada2 == 5) {
						sairDoMenuCliente = true;
					}
				}

				break;
			case 8:
				System.out.println("Saindo do sistema...");
				System.out.println("\nAguarde...");
				System.out.println("----------------------------------------------");
				System.out.println("Sistema da Agencia Turistica Noturna");
				System.out.println("Finalizando...");
				System.out.println("----------------------------------------------");
				clienteDAO.fecharConexao();
				usuarioDAO.fecharConexao();
				agenciaDAO.fecharConexao();
				destinosDAO.fecharConexao();
				promocoesDAO.fecharConexao();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					System.err.println("Driver JDBC não encontrado");
					e.printStackTrace();
					return;
				}

				// Configurar detalhes da conexão
				String url = "jdbc:mysql://localhost:3307/agenciaTuristicaNoturna";
				String username = "root";
				String password = "root";

				// Estabelecer a conexão

				var connection = Conexao.conectar();

				try {
					connection = DriverManager.getConnection(url, username, password);
				} catch (SQLException e) {
					System.err.println("Erro ao conectar ao banco de dados");
					e.printStackTrace();
					return;
				}

				System.out.println("\nInformações Adicionais para o banco");
				System.out.println("Digite as informações que foram criadas nos Menus");
				System.out.println("\n----------------------------------------------");

				List<Integer> idsAgencia = new ArrayList<>();
				List<Integer> idsPromocao = new ArrayList<>();

				while (true) {
					System.out.print("Digite o ID da agencia:");
					int idAgencia = sc.nextInt();

					System.out.print("Digite o ID da Promoção: ");
					int idPromocao = sc.nextInt();

					idsAgencia.add(idAgencia);
					idsPromocao.add(idPromocao);

					System.out.println("Digite '0' para Sair)");
					int sair = sc.nextInt();

					if (sair == 0) {
						break;

					}
				}

				OfereceDAO ofereceDAO = new OfereceDAO(connection);
				for (int i = 0; i < idsAgencia.size(); i++) {
					int idAgencia = idsAgencia.get(i);
					int idPromocao = idsPromocao.get(i);

					ofereceDAO.adicionarOferta(idAgencia, idPromocao);
				}

				ofereceDAO.fecharConexao();

				List<Integer> idsCliente = new ArrayList<>();
				List<Integer> idsCompraPassagem = new ArrayList<>();

				while (true) {
					System.out.print("Digite o ID do Cliente:");
					int idCliente = sc.nextInt();

					System.out.print("Digite o ID do(a) Pedido/Compra: ");
					int idCompraPassagem = sc.nextInt();

					idsCliente.add(idCliente);
					idsCompraPassagem.add(idCompraPassagem);

					System.out.println("Digite '0' para Sair)");
					int sair = sc.nextInt();

					if (sair == 0) {
						break;

					}
				}

				FazDAO fazDAO = new FazDAO(connection);

				for (int i = 0; i < idsCliente.size(); i++) {
					int idCliente = idsCliente.get(i);
					int idCompraPassagem = idsCompraPassagem.get(i);

					fazDAO.adicionarRelacaoClienteCompra(idCliente, idCompraPassagem);
				}

				fazDAO.fecharConexao();

				List<Integer> idsAgencia1 = new ArrayList<>();
				List<Integer> idsDestino = new ArrayList<>();

				while (true) {
					System.out.print("Digite o ID da Agencia:");
					int idAgencia0 = sc.nextInt();

					System.out.print("Digite o ID do destino: ");
					int idDestino = sc.nextInt();

					idsAgencia1.add(idAgencia0);
					idsDestino.add(idDestino);

					System.out.println("Digite '0' para Sair)");
					int sair = sc.nextInt();

					if (sair == 0) {
						break;

					}
				}

				PropoeDAO propoeDAO = new PropoeDAO(connection);

				for (int i = 0; i < idsAgencia1.size(); i++) {
					int idAgencia0 = idsAgencia1.get(i);
					int idDestino = idsDestino.get(i);

					propoeDAO.adicionarProposta(idAgencia0, idDestino);
				}

				propoeDAO.fecharConexao();
				System.out.println("Saindo do sistema...");
				System.out.println("\nObrigado por usar nosso Sistema");
				System.out.println("\nFinalizado!");
				sc.close();
				connection.close();

				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}

		}

	}

}
