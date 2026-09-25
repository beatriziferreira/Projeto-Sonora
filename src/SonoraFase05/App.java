package SonoraFase05;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcaoSonora = 0;
        Plataforma plataforma = new Plataforma();
        App.popularExemplos(plataforma);

        do {
            System.out.println("== SONORA ==");
            System.out.println("1 - Cadastrar conteúdo manualmente");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Criar playlist e adicionar músicas");
            System.out.println("4 - Buscar conteúdo por ID");
            System.out.println("5 - Buscar conteúdo por título");
            System.out.println("6 - Reproduzir um conteúdo");
            System.out.println("7 - Listar acervo de músicas");
            System.out.println("8 - Gerenciar uma playlist/lista de podcasts");
            System.out.println("9 - Seguir ou deixar de seguir um usuário");
            System.out.println("10 - Exibir um perfil de usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção (Dica: não utilize espaços nos nomes): ");
            try {
                opcaoSonora = Integer.parseInt(scan.next());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite um número. ");
                opcaoSonora = Integer.parseInt(scan.next());
            }

            switch (opcaoSonora) {
                case 1:
                    System.out.print("Digite [1] para adicionar uma música e [2] para adicionar um podcast: ");
                    int opcao = 0;
                    try {
                        opcao = Integer.parseInt(scan.next());
                    } catch (NumberFormatException e) {
                        System.out.print("Valor inválido. Digite um número. ");
                        break;
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

                            System.out.print("Digite o álbum da música: ");
                            String album = scan.next();
                            album = App.isEmpty(album);

                            System.out.print("Digite a duração da música (em segundos): ");
                            duracao = scan.nextInt();

                            try {
                                Musica novaMusica = new Musica(titulo, duracao, artista, album);
                                if (plataforma.cadastrarMusica(novaMusica)) {
                                    System.out.println("Música cadastrada com sucesso!");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("Falha ao cadastrar a música: " + e.getMessage());
                            }
                            break;

                        case 2:
                            String tituloPd = " ";
                            String apresentador = " ";
                            int ep = 0;
                            int duracaoPd = 0;

                            System.out.print("Digite o título do podcast: ");
                            tituloPd = scan.next();
                            tituloPd = App.isEmpty(tituloPd);

                            System.out.print("Digite o apresentador do podcast: ");
                            apresentador = scan.next();
                            apresentador = App.isEmpty(apresentador);

                            System.out.print("Digite o número do episodio ");
                            ep = scan.nextInt();

                            System.out.print("Digite a duração da música (em segundos): ");
                            duracaoPd = scan.nextInt();

                            try {
                                Podcast novoPd = new Podcast(tituloPd, duracaoPd, apresentador, ep);
                                if (plataforma.cadastrarPodcast(novoPd)) {
                                    System.out.println("Podcast cadastrado com sucesso!");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("Falha ao cadastrar o Podcast: " + e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;

                    }

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
                    int escolhaPlaylist = 0;
                    try {
                        escolhaPlaylist = Integer.parseInt(scan.next());

                    } catch (NumberFormatException e) {
                        System.out.println("Opção inválida.");
                        break;
                    }

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
                    System.out.print("Digite [1] para buscar uma música e [2] para buscar um podcast: ");
                    int op = 0;
                    try {
                        op = Integer.parseInt(scan.next());
                    } catch (NumberFormatException e) {
                        System.out.print("Valor inválido. Digite um número. ");
                        break;
                    }
                    switch (op) {
                        case 1:
                            System.out.print("Digite o ID da música: ");
                            try {
                                int id = Integer.parseInt(scan.next());
                                Musica musicaEncontrada = plataforma.buscarMusica(id);
                                if (musicaEncontrada != null) {
                                    System.out.println("Música encontrada: " + musicaEncontrada.toString());
                                } else {
                                    System.out.println("Música não encontrada.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Erro: O ID precisa ser um número.");
                            }
                            break;
                        case 2:
                            System.out.print("Digite o ID do podcast: ");
                            try {
                                int id = Integer.parseInt(scan.next());
                                Podcast pdEncontrado = plataforma.buscarPodcast(id);
                                if (pdEncontrado != null) {
                                    System.out.println("Podcast encontrado: " + pdEncontrado.toString());
                                } else {
                                    System.out.println("Podcast não encontrado.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Erro: O ID precisa ser um número.");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }

                    break;

                case 5:
                    System.out.print("Digite [1] para buscar uma música e [2] para buscar um podcast: ");
                    int op2 = 0;
                    try {
                        op2 = Integer.parseInt(scan.next());
                    } catch (NumberFormatException e) {
                        System.out.print("Valor inválido. Digite um número. ");
                    }
                    switch (op2) {
                        case 1:
                            System.out.print("Digite o título da música: ");
                            String tituloMusica = scan.next();
                            Musica musicaEncontradaTitulo = plataforma.buscarMusica(tituloMusica);
                            if (musicaEncontradaTitulo != null) {
                                System.out.println("Música encontrada: " + musicaEncontradaTitulo.toString());
                            }
                            break;
                        case 2:
                            System.out.print("Digite o título da música: ");
                            String tituloPd = scan.next();
                            Podcast pd = plataforma.buscarPodcast(tituloPd);
                            if (pd != null) {
                                System.out.println("Música encontrada: " + pd.toString());
                            }
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }

                    break;
                case 6:
                    System.out.print("Digite [1] para reproduzir uma música e [2] para reproduzir um podcast: ");
                    int op3 = 0;
                    try {
                        op3 = Integer.parseInt(scan.next());
                    } catch (NumberFormatException e) {
                        System.out.print("Valor inválido. Digite um número. ");
                    }
                    switch (op3) {
                        case 1:
                            System.out.println("Informe a música que deseja reproduzir: ");
                            String nomeMusica = scan.next();
                            Musica musicaReproduzir = plataforma.buscarMusica(nomeMusica);
                            if (musicaReproduzir != null) {
                                musicaReproduzir.reproduzir();
                                System.out.println("Reproduzindo " + musicaReproduzir.toString());
                                System.out.println("Reproduções totais de " + musicaReproduzir.getTitulo()
                                        + " na plataforma: " + musicaReproduzir.getReproducoes());
                            }
                            break;
                        case 2:
                            System.out.println("Informe a música que deseja reproduzir: ");
                            String nomePd = scan.next();
                            Podcast pdReproduzir = plataforma.buscarPodcast(nomePd);
                            if (pdReproduzir != null) {
                                pdReproduzir.reproduzir();
                                System.out.println("Reproduzindo " + pdReproduzir.toString());
                                System.out.println("Reproduções totais de " + pdReproduzir.getTitulo()
                                        + " na plataforma: " + pdReproduzir.getReproducoes());
                            }
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    break;

                case 7:
                    System.out.println("=== ACERVO DE MÚSICAS DA PLATAFORMA ===");
                    plataforma.getMusicas();
                    break;

                case 8:
                    System.out.print("Digite [1] para gerenciar uma playlist e [2] para gerenciar uma  podcast: ");
                    int op4 = 0;
                    try {
                        op4 = Integer.parseInt(scan.next());
                    } catch (NumberFormatException e) {
                        System.out.print("Valor inválido. Digite um número. ");
                    }
                    switch (op4) {
                        case 1:
                            System.out.println("Digite o nome da playlist: ");
                            String nomePlaylist = scan.next();
                            Playlist playlist = plataforma.buscarPlaylist(nomePlaylist);

                            if (playlist != null) {
                                System.out.println("Escolha uma opção: ");
                                System.out.println("[1] - Exibir a playlist");
                                System.out.println("[2] - Excluir uma música");
                                System.out.println("[3] - Reproduzir a playlist");
                                int escolha = 0;

                                try {
                                    escolha = Integer.parseInt(scan.next());
                                } catch (NumberFormatException e) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }

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

                                            System.out.println(
                                                    "Deseja remover a música " + musicaExcluida.getTitulo()
                                                            + "? (S/n):");
                                            String removerMus = scan.next();

                                            if (removerMus.equalsIgnoreCase("S")) {
                                                if (playlist.removerMusica(musicaExcluidaPos - 1)) {
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
                                        try {
                                            Musica playlistNula = playlist.getNaPosicao(0);
                                            if (playlistNula != null) {
                                                playlist.reproduzirTudo();
                                                System.out.println("--Reproduzindo a playlist--");
                                                playlist.exibirPlaylist();
                                            }
                                        } catch (IndexOutOfBoundsException e) {
                                            System.out.println("Playlist vazia, erro ao reproduzir.");
                                        }
                                        break;

                                    default:
                                        System.out.println("Opção inválida.");
                                        break;
                                }

                            }

                            break;
                        case 2:
                            System.out.println("Digite o nome da lista de episódios(podcasts): ");
                            String nomeEp = scan.next();
                            Episodios ep = plataforma.buscarEp(nomeEp);

                            if (ep != null) {
                                System.out.println("Escolha uma opção: ");
                                System.out.println("[1] - Exibir os episódios");
                                System.out.println("[2] - Excluir um episódio");
                                System.out.println("[3] - Reproduzir os episódios");
                                int escolha = 0;

                                try {
                                    escolha = Integer.parseInt(scan.next());
                                } catch (NumberFormatException e) {
                                    System.out.println("Opção inválida.");
                                    break;
                                }

                                switch (escolha) {
                                    case 1:
                                        ep.exibirEp();
                                        break;

                                    case 2:
                                        ep.exibirEp();

                                        try {
                                            System.out.print("Digite a posição do episódio em sua playlist: ");
                                            int posicao = Integer.parseInt(scan.next());
                                            Podcast excluirPd = ep.getNaPosicao(posicao - 1);

                                            System.out.println("Deseja remover o episódio " + excluirPd.getTitulo() + "? (S/n):");
                                            String removerEp = scan.next();

                                            if (removerEp.equalsIgnoreCase("S")) {
                                                if (ep.removerpodcast(posicao - 1)) {
                                                    System.out.println("Episódio excluído com sucesso!");
                                                }
                                            } else if (removerEp.equalsIgnoreCase("N")) {
                                                System.out.println("O episódio não foi removido.");
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
                                        try {
                                            Podcast listaNula = ep.getNaPosicao(0);
                                            if (listaNula != null) {
                                                ep.reproduzirTudo();
                                                System.out.println("--Reproduzindo seus episódio--");
                                                ep.exibirEp();
                                            }
                                        } catch (IndexOutOfBoundsException e) {
                                            System.out.println("Lista vazia, erro ao reproduzir.");
                                        }
                                        break;

                                    default:
                                        System.out.println("Opção inválida.");
                                        break;
                                }

                            }
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 9:
                    System.out.println("Digite o nome do seu usuário:");
                    String nomeUsuario = scan.next();
                    User usuario = plataforma.buscarUsuario(nomeUsuario);
                    if (usuario != null) {
                        System.out.println("Deseja seguir (1) ou deixar de seguir (2) outro usuário?");
                        int escolhaSeguir = 0;
                        try {
                            escolhaSeguir = Integer.parseInt(scan.next());
                        } catch (NumberFormatException e) {
                            System.out.println("Opção inválida.");
                            break;
                        }
                        switch (escolhaSeguir) {
                            case 1:
                                System.out.println("Digite o nome do usuário que deseja seguir:");
                                String nomeSeguir = scan.next();
                                User usuarioSeguir = plataforma.buscarUsuario(nomeSeguir);
                                if (usuarioSeguir.getNome().equalsIgnoreCase(nomeUsuario)) {
                                    System.out.println("Você não pode seguir a si mesmo.");
                                } else if (usuarioSeguir != null) {
                                    usuario.seguir(usuarioSeguir);
                                }
                                break;
                            case 2:
                                System.out.println("Digite o nome do usuário que deseja deixar de seguir:");
                                String nomeDeixarDeSeguir = scan.next();
                                User usuarioDeixarDeSeguir = plataforma.buscarUsuario(nomeDeixarDeSeguir);
                                if (usuarioDeixarDeSeguir.getNome().equalsIgnoreCase(nomeUsuario)) {
                                    System.out.println("Você não pode deixar de seguir a si mesmo.");
                                } else if (usuarioDeixarDeSeguir != null) {
                                    usuario.deixarDeSeguir(usuarioDeixarDeSeguir);
                                }
                                break;
                        }

                    }

                    break;

                case 10:
                    System.out.println("Digite o nome do usuário que deseja exibir o perfil:");
                    String nomePerfil = scan.next();
                    User usuarioPerfil = plataforma.buscarUsuario(nomePerfil);
                    if (usuarioPerfil != null) {
                        usuarioPerfil.exibirPerfil(usuarioPerfil);
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcaoSonora != 0);

        scan.close();

    }

    private static void popularExemplos(Plataforma plataforma) {
        plataforma.cadastrarMusica((new Musica("mus1", 226, "art1", "alb1")));
        plataforma.cadastrarMusica((new Musica("mus2", 216, "art2", "alb2")));

        User usuario = new User("Beatriz", "bea@gmail.com");
        plataforma.cadastrarUsuario(usuario);

        Playlist playlist1 = new Playlist("Play1", usuario);
        plataforma.cadastrarPlaylist(playlist1);

        playlist1.adicionarMusica((new Musica("mus3", 126, "art3", "alb3")));

        Episodios e1 = new Episodios("Podcasts", usuario);
        plataforma.cadastrarEpisodio(e1);
        Podcast pd1 = new Podcast("pod1", 126, "ap1", 1);
        plataforma.cadastrarPodcast(pd1);
        e1.adicionarpodcast(pd1);
    }

    private static String isEmpty(String nome) {
        if (nome.equalsIgnoreCase("null") || nome.equalsIgnoreCase("-") || nome.equalsIgnoreCase(".")) {
            return null;
        }
        return nome;
    }

}
