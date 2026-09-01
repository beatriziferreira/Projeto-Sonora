package SonoraFase01;

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
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título da música: ");
                    String titulo = scan.next();

                    System.out.print("Digite o artista da música: ");
                    String artista = scan.next();

                    System.out.print("Digite a duração da música (em segundos): ");
                    int duracao = scan.nextInt();

                    Musica novaMusica = new Musica(titulo, artista, duracao);
                    if (plataforma.cadastrarMusica(novaMusica)) {
                        System.out.println("Música cadastrada com sucesso!");
                    } else {
                        System.out.println("Falha ao cadastrar a música.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scan.next();

                    System.out.print("Digite o e-mail do usuário: ");
                    String email = scan.next();

                    User novoUsuario = new User(nome, email);

                    if (plataforma.cadastrarUsuario(novoUsuario)) {
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("Falha ao cadastrar o usuário.");
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

                        if (dono != null && dono.getNome().equalsIgnoreCase(nomeDono)) {
                            Playlist playlist = new Playlist(nomePlaylist, dono);
                            if (plataforma.cadastrarPlaylist(playlist)) {
                                System.out.println("Playlist criada com sucesso!");
                            } else {
                                System.out.println("Falha ao criar a playlist.");
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
                                } else {
                                    System.out.println("Falha ao adicionar a música à playlist.");
                                }
                            }
                        }

                    }
                    break;
                case 4:
                    System.out.print("Digite o ID da música: ");
                    int id = scan.nextInt();
                    Musica musicaEncontrada = plataforma.buscarMusica(id);
                    if (musicaEncontrada != null) {
                        System.out.println("Música encontrada: " + musicaEncontrada.getTitulo() + " - "
                                + musicaEncontrada.getArtista());
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
                    System.out.println( "Informe a música que deseja reproduzir: " );
                    String nomeMusica = scan.next();
                    Musica musicaReproduzir = plataforma.buscarMusica(nomeMusica);
                    if (musicaReproduzir != null){
                        musicaReproduzir.reproduzir();
                        System.out.println("Reproduzindo " + musicaReproduzir.getTitulo() + " - " + musicaReproduzir.getArtista() + " (" +  musicaReproduzir.getDuracaoFormatada() + ")");
                        System.out.println("Reproduções totais de " + musicaReproduzir.getTitulo() + " na plataforma: " + musicaReproduzir.getReproducoes());
                    }
                    break;
                case 7:
                    System.out.println( "=== ACERVO DE MÚSICAS DA PLATAFORMA ===" );
                    plataforma.getMusicas();
                    break;
                case 8:
                    System.out.println("Digite o nome da playlist: ");
                    String nomePlaylist = scan.next();
<<<<<<< HEAD
                    Playlist playlist = null;
                    for (int i = 0; i < plataforma.getQuantidadePlaylists(); i++) {
                        playlist = plataforma.getPlaylistNaPosicao(i);
                        if (playlist != null && playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                            playlist.exibirPlaylist();
                            break;
                        } else if (playlist == null) {
                        System.out.println("Playlist não encontrada.");
=======
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
                                System.out.print("Digite a posição da música em sua playlist ");
                                int musicaExcluidaPos = scan.nextInt();
                                Musica musicaExcluida = playlist.getNaPosicao(musicaExcluidaPos - 1);

                                if (musicaExcluida != null){
                                System.out.println("Deseja remover a música " + musicaExcluida.getTitulo() + "? (S/n):");
                                String removerMus = scan.next();

                                    if (removerMus.equalsIgnoreCase("S")){
                                        if (playlist.removerMusica(musicaExcluidaPos - 1));{
                                        System.out.println("Música excluída com sucesso!");}
                                    } else if (removerMus.equalsIgnoreCase("N")){
                                        System.out.println("A música não foi removida.");
                                    } else {
                                        System.out.println("Opção inválida.");
                                    }
                                }

                                break;
                            case 3:
                                Musica playlistNula = playlist.getNaPosicao(0);
                                if (playlistNula != null){
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

>>>>>>> 9b052dd2c4a1cf65591807557582991b793af5d1
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

    }

    

}
