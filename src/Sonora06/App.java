package Sonora06;

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
            System.out.println("8 - Gerenciar uma playlist");
            System.out.println("9 - Seguir ou deixar de seguir um usuário");
            System.out.println("10 - Exibir um perfil de usuário");
            System.out.println("11 - Trocar plano de um usuário");
            System.out.println("12 - Exibir resumo do plano atual");
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
                case 11:
                    System.out.println("Digite o nome do usuário:");
                    String nomePlano = scan.next();
                    User usuarioPlano = plataforma.buscarUsuario(nomePlano);
                    if (usuarioPlano != null) {
                        try {
                            System.out.println("[1] Gratuito");
                            System.out.println("[2] Individual");
                            System.out.println("[3] Familia");
                            int opcaoPlano = Integer.parseInt(scan.next());

                            if (opcaoPlano == 1) {
                                usuarioPlano.assinar(new PlanoGratuito());
                            } else if (opcaoPlano == 2) {
                                System.out.print("Digite o preço mensal: ");
                                double preco = Double.parseDouble(scan.next());
                                usuarioPlano.assinar(new PlanoIndividual(preco));
                            } else if (opcaoPlano == 3) {
                                System.out.print("Digite o preço mensal: ");
                                double preco = Double.parseDouble(scan.next());
                                System.out.print("Digite a quantidade de membros (1 a 6): ");
                                int membros = Integer.parseInt(scan.next());
                                usuarioPlano.assinar(new PlanoFamilia(preco, membros));
                            } else {
                                System.out.println("Opção inválida.");
                                break;
                            }

                            System.out.println("Plano alterado com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro ao alterar plano: " + e.getMessage());
                        }
                    }
                    break;

                case 12:
                    System.out.println("Digite o nome do usuário:");
                    String nomeResumo = scan.next();
                    User usuarioResumo = plataforma.buscarUsuario(nomeResumo);
                    if (usuarioResumo != null) {
                        System.out.println(usuarioResumo.getPlano().resumo());
                        System.out.println("Anúncios: " + (usuarioResumo.getPlano().temAnuncios() ? "sim" : "não"));
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
        plataforma.cadastrarMusica(new Musica("BillieJean", 294, "MichaelJackson", "Thriller"));
        plataforma.cadastrarMusica(new Musica("BeatIt", 258, "MichaelJackson", "Thriller"));
        plataforma.cadastrarMusica(new Musica("Thriller", 357, "MichaelJackson", "Thriller"));
        plataforma.cadastrarMusica(new Musica("SmellsLikeTeenSpirit", 301, "Nirvana", "Nevermind"));
        plataforma.cadastrarMusica(new Musica("ComeAsYouAre", 219, "Nirvana", "Nevermind"));
        plataforma.cadastrarMusica(new Musica("BohemianRhapsody", 354, "Queen", "ANightattheOpera"));
        plataforma.cadastrarMusica(new Musica("WeWillRockYou", 122, "Queen", "NewsoftheWorld"));
        plataforma.cadastrarMusica(new Musica("AnotherOneBitestheDust", 215, "Queen", "TheGame"));
        plataforma.cadastrarMusica(new Musica("Imagine", 187, "JohnLennon", "Imagine"));
        plataforma.cadastrarMusica(new Musica("LetItBe", 243, "TheBeatles", "LetItBe"));
        plataforma.cadastrarMusica(new Musica("HeyJude", 431, "TheBeatles", "PastMasters"));
        plataforma.cadastrarMusica(new Musica("Yesterday", 125, "TheBeatles", "Help!"));
        plataforma.cadastrarMusica(new Musica("HotelCalifornia", 391, "Eagles", "HotelCalifornia"));
        plataforma.cadastrarMusica(new Musica("Wonderwall", 259, "Oasis", "WhatsTheStoryMorningGlory"));
        plataforma.cadastrarMusica(new Musica("DontLookBackinAnger", 289, "Oasis", "WhatsTheStoryMorningGlory"));
        plataforma.cadastrarMusica(new Musica("SweetChildoMine", 356, "GunsNRoses", "AppetiteforDestruction"));
        plataforma.cadastrarMusica(new Musica("ParadiseCity", 409, "GunsNRoses", "AppetiteforDestruction"));
        plataforma.cadastrarMusica(new Musica("BackinBlack", 255, "ACDC", "BackinBlack"));
        plataforma.cadastrarMusica(new Musica("HighwaytoHell", 208, "ACDC", "HighwaytoHell"));
        plataforma.cadastrarMusica(new Musica("StairwaytoHeaven", 482, "LedZeppelin", "LedZeppelinIV"));
        plataforma.cadastrarMusica(new Musica("DreamOn", 267, "Aerosmith", "Aerosmith"));
        plataforma.cadastrarMusica(new Musica("Creep", 238, "Radiohead", "PabloHoney"));
        plataforma.cadastrarMusica(new Musica("KarmaPolice", 263, "Radiohead", "OKComputer"));
        plataforma.cadastrarMusica(new Musica("Clocks", 307, "Coldplay", "ARushofBloodtotheHead"));
        plataforma.cadastrarMusica(new Musica("VivaLaVida", 242, "Coldplay", "VivaLaVidaorDeathandAllHisFriends"));
        plataforma.cadastrarMusica(new Musica("Yellow", 266, "Coldplay", "Parachutes"));
        plataforma.cadastrarMusica(new Musica("ShapeofYou", 234, "EdSheeran", "Divide"));
        plataforma.cadastrarMusica(new Musica("Perfect", 263, "EdSheeran", "Divide"));
        plataforma.cadastrarMusica(new Musica("ThinkingOutLoud", 281, "EdSheeran", "X"));
        plataforma.cadastrarMusica(new Musica("RollingintheDeep", 228, "Adele", "21"));
        plataforma.cadastrarMusica(new Musica("Hello", 295, "Adele", "25"));
        plataforma.cadastrarMusica(new Musica("SomeoneLikeYou", 285, "Adele", "21"));
        plataforma.cadastrarMusica(new Musica("BadGuy", 194, "BillieEilish", "WhenWeAllFallAsleepWhereDoWeGo"));
        plataforma.cadastrarMusica(new Musica("HappierThanEver", 298, "BillieEilish", "HappierThanEver"));
        plataforma.cadastrarMusica(new Musica("BlindingLights", 200, "TheWeeknd", "AfterHours"));
        plataforma.cadastrarMusica(new Musica("SaveYourTears", 215, "TheWeeknd", "AfterHours"));
        plataforma.cadastrarMusica(new Musica("Starboy", 230, "TheWeeknd", "Starboy"));
        plataforma.cadastrarMusica(new Musica("Levitating", 203, "DuaLipa", "FutureNostalgia"));
        plataforma.cadastrarMusica(new Musica("NewRules", 209, "DuaLipa", "DuaLipa"));
        plataforma.cadastrarMusica(new Musica("DontStartNow", 183, "DuaLipa", "FutureNostalgia"));

        Musica m41 = new Musica("PokerFace", 238, "Lady Gaga", "The Fame");
        Musica m42 = new Musica("BadRomance", 295, "Lady Gaga", "The Fame Monster");
        Musica m43 = new Musica("Umbrella", 276, "Rihanna", "Good Girl Gone Bad");
        Musica m44 = new Musica("Diamonds", 225, "Rihanna", "Unapologetic");
        Musica m45 = new Musica("Havana", 217, "Camila Cabello", "Camila");
        Musica m46 = new Musica("Despacito", 229, "Luis Fonsi", "Vida");
        Musica m47 = new Musica("ShapeOfMyHeart", 253, "Sting", "Ten Summoner's Tales");
        Musica m48 = new Musica("Zombie", 306, "The Cranberries", "No Need to Argue");
        Musica m49 = new Musica("EverybodyWantsToRuleTheWorld", 251, "Tears for Fears",
                "Songs from the Big Chair");
        Musica m50 = new Musica("Africa", 295, "Toto", "Toto IV");

        plataforma.cadastrarMusica(m41);
        plataforma.cadastrarMusica(m42);
        plataforma.cadastrarMusica(m43);
        plataforma.cadastrarMusica(m44);
        plataforma.cadastrarMusica(m45);
        plataforma.cadastrarMusica(m46);
        plataforma.cadastrarMusica(m47);
        plataforma.cadastrarMusica(m48);
        plataforma.cadastrarMusica(m49);
        plataforma.cadastrarMusica(m50);

        User user = new User("Beatriz", "biferreira@gmail.com");
        Playlist playlist1 = new Playlist("P1", user);

        playlist1.adicionarMusica(m41);
        playlist1.adicionarMusica(m42);
        playlist1.adicionarMusica(m43);
        playlist1.adicionarMusica(m44);
        playlist1.adicionarMusica(m45);
        playlist1.adicionarMusica(m46);
        playlist1.adicionarMusica(m47);
        playlist1.adicionarMusica(m48);
        playlist1.adicionarMusica(m49);
        playlist1.adicionarMusica(m50);

        plataforma.cadastrarPodcast(new Podcast("FlowPodcast", 7200, "Igor3K", 1));
        plataforma.cadastrarPodcast(new Podcast("Podpah", 5400, "IgaoEMitico", 1));
        plataforma.cadastrarPodcast(new Podcast("NerdCast", 6000, "JovemNerd", 1));
        plataforma.cadastrarPodcast(new Podcast("InteligenciaLtda", 4800, "RogerioVilela", 1));
        plataforma.cadastrarPodcast(new Podcast("CafedaManha", 1800, "FolhadeSP", 1));
        plataforma.cadastrarPodcast(new Podcast("ManoaMano", 3600, "ManoBrown", 1));
        plataforma.cadastrarPodcast(new Podcast("Mamilos", 3600, "Mamilos", 1));
        plataforma.cadastrarPodcast(new Podcast("Braincast", 3000, "B9", 1));
        plataforma.cadastrarPodcast(new Podcast("Tecnocast", 2700, "Tecnoblog", 1));
        plataforma.cadastrarPodcast(new Podcast("RespondendoemVozAlta", 2400, "JoutJout", 1));

    }

    private static String isEmpty(String nome) {
        if (nome.equalsIgnoreCase("null") || nome.equalsIgnoreCase("-") || nome.equalsIgnoreCase(".")) {
            return null;
        }
        return nome;
    }

}
