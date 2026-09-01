package SonoraFase02;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        Plataforma plataforma = new Plataforma();
        App.popularExemplos(plataforma);

        do {
            System.out.println("== SONORA ==");
            System.out.println("1 - Cadastrar música manualmente");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Criar playlist e adicionar músicas");
            System.out.println("4 - Buscar música por ID");
            System.out.println("5 - Buscar música por título");
            System.out.println("6 - Reproduzir uma música");
            System.out.println("7 - Listar acervo de músicas");
            System.out.println("8 - Gerenciair uma playlist");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção (Dica: não utilize espaços nos nomes): ");
            try {
                opcao = Integer.parseInt(scan.next());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite um número. ");
                opcao = Integer.parseInt(scan.next());
            }

            switch (opcao) {
                case 1:
                    String titulo = " ";
                    String artista = " ";
                    int duracao = 0;

                    System.out.print("Digite o título da música: ");
                    titulo = scan.next();
                    titulo = App.isEmpty(titulo);

                    System.out.print("Digite o artista da música: ");
                    artista = scan.next();
                    artista = App.isEmpty(artista);

                    System.out.print("Digite a duração da música (em segundos): ");
                    duracao = scan.nextInt();

                    try {
                        Musica novaMusica = new Musica(titulo, artista, duracao);
                        if (plataforma.cadastrarMusica(novaMusica)) {
                            System.out.println("Música cadastrada com sucesso!");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Falha ao cadastrar a música: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scan.next();
                    nome = App.isEmpty(nome);

                    System.out.print("Digite o e-mail do usuário: ");
                    String email = scan.next();
                    email = App.isEmpty(email);

                    try {
                        User novoUsuario = new User(nome, email);
                        if (plataforma.cadastrarUsuario(novoUsuario)) {
                            System.out.println("Usuário cadastrado com sucesso!");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Falha ao cadastrar usuário: " + e.getMessage());
                    }

                    break;

                case 3:
                    System.out.println(
                            "Deseja criar uma playlist (1) ou adicionar músicas a uma playlist existente (2)? ");
                    int escolhaPlaylist = scan.nextInt();
                    if (escolhaPlaylist == 1) {
                        System.out.println("Digite o nome da playlist: ");
                        String nomePlaylist = scan.next();

                        System.out.println("Digite o nome do dono da playlist: ");
                        String nomeDono = scan.next();

                        User dono = plataforma.buscarUsuario(nomeDono);

                        if (dono != null) {
                            try {
                                Playlist playlist = new Playlist(nomePlaylist, dono);
                                if (plataforma.cadastrarPlaylist(playlist)) {
                                    System.out.println("Playlist criada com sucesso!");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("Falha ao criar playlist: " + e.getMessage());
                            }
                        }

                    } else if (escolhaPlaylist == 2) {
                        System.out.println("Digite o nome da playlist: ");
                        String nomePlaylist = scan.next();
                        Playlist playlist = plataforma.buscarPlaylist(nomePlaylist);

                        if (playlist != null) {
                            System.out.println("Digite o título da música a ser adicionada: ");
                            String tituloMusica = scan.next();
                            Musica musica = plataforma.buscarMusica(tituloMusica);
                            if (musica != null) {
                                if (playlist.adicionarMusica(musica)) {
                                    System.out.println("Música adicionada à playlist.");
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID da música: ");
                    try {
                        int id = Integer.parseInt(scan.next());
                        Musica musicaEncontrada = plataforma.buscarMusica(id);
                        if (musicaEncontrada != null) {
                            System.out.println("Música encontrada: " + musicaEncontrada.getTitulo() + " - "
                                    + musicaEncontrada.getArtista());
                        } else {
                            System.out.println("Música não encontrada.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: O ID precisa ser um número.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o título da música: ");
                    String tituloMusica = scan.next();
                    Musica musicaEncontradaTitulo = plataforma.buscarMusica(tituloMusica);
                    if (musicaEncontradaTitulo != null) {
                        System.out.println("Música encontrada: " + musicaEncontradaTitulo.getTitulo() + " - "
                                + musicaEncontradaTitulo.getArtista());
                    }
                    break;
                case 6:
                    System.out.println("Informe a música que deseja reproduzir: ");
                    String nomeMusica = scan.next();
                    Musica musicaReproduzir = plataforma.buscarMusica(nomeMusica);
                    if (musicaReproduzir != null) {
                        musicaReproduzir.reproduzir();
                        System.out.println("Reproduzindo " + musicaReproduzir.getTitulo() + " - "
                                + musicaReproduzir.getArtista() + " (" + musicaReproduzir.getDuracaoFormatada() + ")");
                        System.out.println("Reproduções totais de " + musicaReproduzir.getTitulo() + " na plataforma: "
                                + musicaReproduzir.getReproducoes());
                    }
                    break;
                case 7:
                    System.out.println("=== ACERVO DE MÚSICAS DA PLATAFORMA ===");
                    plataforma.getMusicas();
                    break;
                case 8:
                    System.out.println("Digite o nome da playlist: ");
                    String nomePlaylist = scan.next();
                    Playlist playlist = plataforma.buscarPlaylist(nomePlaylist);

                    if (playlist != null) {
                        System.out.println("Escolha uma opção: ");
                        System.out.println("[1] - Exibir a playlist");
                        System.out.println("[2] - Excluir uma música");
                        System.out.println("[3] - Reproduzir a playlist");
                        int escolha = scan.nextInt();

                        switch (escolha) {
                            case 1:
                                playlist.exibirPlaylist();
                                break;

                            case 2:
                                playlist.exibirPlaylist();
                                
                                try {
                                    System.out.print("Digite a posição da música em sua playlist: ");
                                    int musicaExcluidaPos = Integer.parseInt(scan.next());
                                    Musica musicaExcluida = playlist.getNaPosicao(musicaExcluidaPos - 1);

                                    System.out.println("Deseja remover a música " + musicaExcluida.getTitulo() + "? (S/n):");
                                    String removerMus = scan.next();

                                    if (removerMus.equalsIgnoreCase("S")) {
                                        if (playlist.removerMusica(musicaExcluidaPos - 1))
                                            ;
                                        {
                                            System.out.println("Música excluída com sucesso!");
                                        }
                                    } else if (removerMus.equalsIgnoreCase("N")) {
                                        System.out.println("A música não foi removida.");
                                    } else {
                                        System.out.println("Opção inválida.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Erro: A posição precisa ser um número");

                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("Erro: " + e.getMessage());
                                } finally {
                                    System.out.println("Operação finalizada.");
                                }

                                break;
                            case 3:
                                Musica playlistNula = playlist.getNaPosicao(0);
                                if (playlistNula != null) {
                                    playlist.reproduzirTudo();
                                    System.out.println("--Reproduzindo a playlist " + playlist.getNome() + "--");
                                } else {
                                    System.out.println("Playlist vazia, erro ao reproduzir.");
                                }

                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }

                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scan.close();

    }

    private static void popularExemplos(Plataforma plataforma) {
        plataforma.cadastrarMusica((new Musica("PerfectSystem", "Oingo Boingo", 226)));
        plataforma.cadastrarMusica((new Musica("Fine", "Lemon Demon", 200)));
        plataforma.cadastrarMusica((new Musica("TurnTheLightsOff", "Tally Hall", 210)));
        Musica mus4 = new Musica("Duvet", "Boa", 204);
        plataforma.cadastrarMusica(mus4);
        plataforma.cadastrarMusica((new Musica("CharliesInferno", "The Handsome Devil", 225)));

        User usuario = new User("Beatriz", "bea@gmail.com");
        plataforma.cadastrarUsuario(usuario);

        Playlist playlist1 = new Playlist("Play1", usuario);
        plataforma.cadastrarPlaylist(playlist1);

        playlist1.adicionarMusica(mus4);

    }

    private static String isEmpty(String nome) {
        if (nome.equalsIgnoreCase("null") || nome.equalsIgnoreCase("-") || nome.equalsIgnoreCase(".")) {
            return null;
        }
        return nome;
    }

}
