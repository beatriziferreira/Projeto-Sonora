package SonoraFase01;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        Plataforma plataforma = new Plataforma();

        do {
            System.out.println("== SONORA ==");
            System.out.println("1 - Cadastrar música manualmente");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Criar playlist e adicionar músicas");
            System.out.println("4 - Buscar música por ID");
            System.out.println("5 - Buscar música por título");
            System.out.println("6 - Reproduzir uma música");
            System.out.println("7 - Listar acervo de músicas");
            System.out.println("8 - Exibir uma playlist");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
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
                    System.out.println("Deseja criar uma playlist (1) ou adicionar músicas a uma playlist existente (2)?");
                    int escolhaPlaylist = scan.nextInt();
                    if (escolhaPlaylist == 1) {
                        System.out.println("Digite o nome da playlist: ");
                        String nomePlaylist = scan.next();

                        System.out.println("Digite o nome do dono da playlist: ");
                        String nomeDono = scan.next();

                        User dono = null;
                        for (int i = 0; i < plataforma.getQuantidadeUsuarios(); i++) {
                            dono = plataforma.getUsuarioNaPosicao(i);
                            if (dono != null && dono.getNome().equalsIgnoreCase(nomeDono)) {
                                break;
                            }
                        } 

                        if (dono == null) {
                            System.out.println("Usuário não encontrado. Crie o usuário antes de criar a playlist.");
                            break;
                        } else {
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
                        Playlist playlist = null;
                        for (int i = 0; i < plataforma.getQuantidadePlaylists(); i++) {
                            playlist = plataforma.getPlaylistNaPosicao(i);
                            if (playlist != null && playlist.getNome().equals(nomePlaylist)) {
                                break;
                            }
                        }

                        if (playlist == null) {
                            System.out.println("Playlist não encontrada.");
                            break;
                        } else {
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
                    int idMusica = scan.nextInt();
                    Musica musicaEncontrada = plataforma.buscarMusica(idMusica);
                    if (musicaEncontrada != null) {
                        System.out.println("Música encontrada: " + musicaEncontrada.getTitulo() + " - " + musicaEncontrada.getArtista());
                    } else {
                        System.out.println("Música não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o título da música: ");
                    String tituloMusica = scan.next();
                    Musica musicaEncontradaTitulo = plataforma.buscarMusica(tituloMusica);
                    if (musicaEncontradaTitulo != null) {
                        System.out.println("Música encontrada: " + musicaEncontradaTitulo.getTitulo() + " - " + musicaEncontradaTitulo.getArtista());
                    } else {
                        System.out.println("Música não encontrada.");
                    }
                    break;
                case 6:
                    // Implementar reprodução de música
                    break;
                case 7:
                    // Implementar listagem do acervo de músicas
                    break;
                case 8:
                    Playlist playlist = null;
                    playlist.exibirPlaylist();
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

    }

}
