package SonoraFase07;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();
        popularExemplos(plataforma);
        int opcao = -1;

        do {
            System.out.println("\n== SONORA ==");
            System.out.println("1 - Cadastrar música ou podcast");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Criar playlist");
            System.out.println("4 - Adicionar conteúdo a playlist");
            System.out.println("5 - Buscar conteúdo por ID");
            System.out.println("6 - Buscar conteúdo por título");
            System.out.println("7 - Reproduzir conteúdo");
            System.out.println("8 - Listar acervo");
            System.out.println("9 - Gerenciar playlist");
            System.out.println("10 - Seguir usuário");
            System.out.println("11 - Exibir perfil");
            System.out.println("12 - Trocar plano");
            System.out.println("13 - Resumo do plano");
            System.out.println("14 - Cadastrar anúncio");
            System.out.println("15 - Adicionar podcast a playlist");
            System.out.println("16 - Tocar playlist para usuário");
            System.out.println("17 - Listar episódios por apresentador");
            System.out.println("18 - Exibir receita mensal");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scan.next());
                switch (opcao) {
                    case 1: {
                        System.out.print("Música (1) ou podcast (2)? ");
                        int tipo = Integer.parseInt(scan.next());
                        System.out.print("Título: "); String titulo = scan.next();
                        System.out.print("Duração em segundos: "); int duracao = Integer.parseInt(scan.next());
                        if (tipo == 1) {
                            System.out.print("Artista: "); String artista = scan.next();
                            System.out.print("Álbum: "); String album = scan.next();
                            plataforma.cadastrarMusica(new Musica(titulo, duracao, artista, album));
                        } else if (tipo == 2) {
                            System.out.print("Apresentador: "); String apresentador = scan.next();
                            System.out.print("Número do episódio: "); int ep = Integer.parseInt(scan.next());
                            plataforma.cadastrarPodcast(new Podcast(titulo, duracao, apresentador, ep));
                        } else throw new IllegalArgumentException("Tipo inválido.");
                        System.out.println("Conteúdo cadastrado.");
                        break;
                    }
                    case 2: {
                        System.out.print("Nome: "); String nome = scan.next();
                        System.out.print("E-mail: "); String email = scan.next();
                        plataforma.cadastrarUsuario(new User(nome, email));
                        System.out.println("Usuário cadastrado.");
                        break;
                    }
                    case 3: {
                        System.out.print("Nome da playlist: "); String nome = scan.next();
                        System.out.print("Dono da playlist: "); String donoNome = scan.next();
                        User dono = plataforma.buscarUsuario(donoNome);
                        if (dono != null) { plataforma.cadastrarPlaylist(new Playlist(nome, dono)); System.out.println("Playlist criada."); }
                        break;
                    }
                    case 4:
                    case 15: {
                        System.out.print("Nome da playlist: "); Playlist p = plataforma.buscarPlaylist(scan.next());
                        if (p == null) break;
                        System.out.print("Título do conteúdo: "); Conteudo c = plataforma.buscarConteudo(scan.next());
                        if (c == null) { System.out.println("Conteúdo não encontrado."); break; }
                        p.adicionarConteudo(c);
                        System.out.println("Conteúdo adicionado.");
                        break;
                    }
                    case 5: {
                        System.out.print("ID: "); int id = Integer.parseInt(scan.next());
                        boolean achou = false;
                        for (Conteudo c : plataforma.getAcervo()) if (c.getId() == id) { System.out.println(c); achou = true; }
                        if (!achou) System.out.println("Conteúdo não encontrado.");
                        break;
                    }
                    case 6: {
                        System.out.print("Título: "); Conteudo c = plataforma.buscarConteudo(scan.next());
                        System.out.println(c == null ? "Conteúdo não encontrado." : c);
                        break;
                    }
                    case 7: {
                        System.out.print("Título: "); Conteudo c = plataforma.buscarConteudo(scan.next());
                        if (c != null) c.reproduzir(); else System.out.println("Conteúdo não encontrado.");
                        break;
                    }
                    case 8:
                        System.out.println("=== ACERVO ===");
                        for (Conteudo c : plataforma.getAcervo()) System.out.println(c);
                        break;
                    case 9: {
                        System.out.print("Nome da playlist: "); Playlist p = plataforma.buscarPlaylist(scan.next());
                        if (p == null) break;
                        p.exibirPlaylist();
                        System.out.println("1 - Remover item | 2 - Reproduzir playlist");
                        int op = Integer.parseInt(scan.next());
                        if (op == 1) {
                            System.out.print("Posição do item: "); int pos = Integer.parseInt(scan.next());
                            p.removerMusica(pos - 1);
                            System.out.println("Item removido.");
                        } else if (op == 2) p.reproduzirTudo();
                        else System.out.println("Opção inválida.");
                        break;
                    }
                    case 10: {
                        System.out.print("Seu usuário: "); User u = plataforma.buscarUsuario(scan.next());
                        System.out.print("Usuário para seguir: "); User outro = plataforma.buscarUsuario(scan.next());
                        if (u != null && outro != null) u.seguir(outro);
                        break;
                    }
                    case 11: {
                        System.out.print("Usuário: "); User u = plataforma.buscarUsuario(scan.next());
                        if (u != null) u.exibirPerfil(u);
                        break;
                    }
                    case 12: {
                        System.out.print("Usuário: "); User u = plataforma.buscarUsuario(scan.next());
                        if (u == null) break;
                        System.out.println("1 - Gratuito | 2 - Individual | 3 - Família");
                        int plano = Integer.parseInt(scan.next());
                        if (plano == 1) u.assinar(new PlanoGratuito());
                        else if (plano == 2) {
                            System.out.print("Preço mensal: "); u.assinar(new PlanoIndividual(Double.parseDouble(scan.next())));
                        } else if (plano == 3) {
                            System.out.print("Preço mensal: "); double preco = Double.parseDouble(scan.next());
                            System.out.print("Quantidade de membros (1 a 6): "); int membros = Integer.parseInt(scan.next());
                            u.assinar(new PlanoFamilia(preco, membros));
                        } else throw new IllegalArgumentException("Plano inválido.");
                        System.out.println("Plano alterado.");
                        break;
                    }
                    case 13: {
                        System.out.print("Usuário: "); User u = plataforma.buscarUsuario(scan.next());
                        if (u != null) {
                            System.out.println(u.getPlano().resumo());
                            System.out.println("Anúncios: " + (u.getPlano().temAnuncios() ? "sim" : "não"));
                        }
                        break;
                    }
                    case 14: {
                        System.out.print("Anunciante: "); String anunciante = scan.next();
                        System.out.print("Título do anúncio: "); String titulo = scan.next();
                        System.out.print("Duração em segundos: "); int duracao = Integer.parseInt(scan.next());
                        System.out.print("Valor por mil impressões: "); double valor = Double.parseDouble(scan.next());
                        plataforma.cadastrarAnuncio(new Anuncio(anunciante, titulo, duracao, valor));
                        System.out.println("Anúncio cadastrado.");
                        break;
                    }
                    case 16: {
                        System.out.print("Usuário ouvinte: "); User u = plataforma.buscarUsuario(scan.next());
                        System.out.print("Playlist: "); Playlist p = plataforma.buscarPlaylist(scan.next());
                        if (u != null && p != null) {
                            System.out.printf("Receita antes: R$ %.2f%n", plataforma.calcularReceitaMensal());
                            plataforma.tocarPlaylist(u, p);
                            System.out.printf("Receita depois: R$ %.2f%n", plataforma.calcularReceitaMensal());
                        }
                        break;
                    }
                    case 17:
                        System.out.print("Apresentador: "); plataforma.listarEpisodiosDe(scan.next());
                        break;
                    case 18:
                        System.out.printf("Receita mensal: R$ %.2f%n", plataforma.calcularReceitaMensal());
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: digite um número no formato correto.");
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Não foi possível concluir a operação. Verifique os dados informados.");
            }
        } while (opcao != 0);
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
        plataforma.cadastrarUsuario(user);
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

        plataforma.cadastrarPlaylist(playlist1);
        plataforma.cadastrarAnuncio(new Anuncio("TorrefacaoSerrana", "CafedaSerra", 15, 25.0));
        plataforma.cadastrarAnuncio(new Anuncio("LojaCentral", "OfertasdaSemana", 20, 18.0));


    }
}
