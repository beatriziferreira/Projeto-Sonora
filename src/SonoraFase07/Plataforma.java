package SonoraFase07;

import java.util.ArrayList;

public class Plataforma {
    private ArrayList<User> usuarios = new ArrayList<>();
    private ArrayList<Conteudo> acervo = new ArrayList<>();
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private ArrayList<Anuncio> anuncios = new ArrayList<>();

    public boolean cadastrarUsuario(User usuario) {
        if (usuario == null) throw new IllegalArgumentException("Usuário inválido.");
        usuarios.add(usuario); return true;
    }
    public boolean cadastrarMusica(Musica musica) { return cadastrarConteudo(musica); }
    public boolean cadastrarPodcast(Podcast podcast) { return cadastrarConteudo(podcast); }
    public boolean cadastrarConteudo(Conteudo conteudo) {
        if (conteudo == null) throw new IllegalArgumentException("Conteúdo inválido.");
        acervo.add(conteudo); return true;
    }
    public boolean cadastrarAnuncio(Anuncio anuncio) {
        if (anuncio == null) throw new IllegalArgumentException("Anúncio inválido.");
        anuncios.add(anuncio); return true;
    }
    public ArrayList<Anuncio> getAnuncios() { return new ArrayList<>(anuncios); }
    public ArrayList<User> getUsuarios() { return new ArrayList<>(usuarios); }
    public ArrayList<Conteudo> getAcervo() { return new ArrayList<>(acervo); }

    public Musica buscarMusica(int id) {
        for (Conteudo c : acervo) if (c instanceof Musica && c.getId() == id) return (Musica)c;
        System.out.println("Música não encontrada."); return null;
    }
    public Musica buscarMusica(String titulo) {
        for (Conteudo c : acervo) if (c instanceof Musica && c.getTitulo().equalsIgnoreCase(titulo)) return (Musica)c;
        System.out.println("Música não encontrada."); return null;
    }
    public Podcast buscarPodcast(int id) {
        for (Conteudo c : acervo) if (c instanceof Podcast && c.getId() == id) return (Podcast)c;
        System.out.println("Podcast não encontrado."); return null;
    }
    public Podcast buscarPodcast(String titulo) {
        for (Conteudo c : acervo) if (c instanceof Podcast && c.getTitulo().equalsIgnoreCase(titulo)) return (Podcast)c;
        System.out.println("Podcast não encontrado."); return null;
    }
    public Conteudo buscarConteudo(String titulo) {
        for (Conteudo c : acervo) if (c.getTitulo().equalsIgnoreCase(titulo)) return c;
        return null;
    }
    public User buscarUsuario(String nome) {
        for (User u : usuarios) if (u.getNome().equalsIgnoreCase(nome)) return u;
        System.out.println("Usuário não encontrado. Crie o usuário antes de realizar esta ação."); return null;
    }
    public int getQuantidadeMusicas() {
        int n = 0; for (Conteudo c : acervo) if (c instanceof Musica) n++; return n;
    }
    public int getQuantidadePodcasts() {
        int n = 0; for (Conteudo c : acervo) if (c instanceof Podcast) n++; return n;
    }
    public boolean cadastrarPlaylist(Playlist playlist) {
        if (playlist == null) throw new IllegalArgumentException("Playlist inválida.");
        playlists.add(playlist); return true;
    }
    public Playlist buscarPlaylist(String nome) {
        for (Playlist p : playlists) if (p.getNome().equalsIgnoreCase(nome)) return p;
        System.out.println("Playlist não encontrada."); return null;
    }
    public void getMusicas() {
        for (Conteudo c : acervo) if (c instanceof Musica) System.out.println(c);
    }
    public void getPodcasts() {
        for (Conteudo c : acervo) if (c instanceof Podcast) System.out.println(c);
    }
    public double calcularReceitaMensal() {
        ArrayList<Faturavel> cobrancas = new ArrayList<>();
        for (User u : usuarios) cobrancas.add(u.getPlano());
        cobrancas.addAll(anuncios);
        double total = 0;
        for (Faturavel f : cobrancas) total += f.calcularMensalidade();
        return total;
    }
    public void listarEpisodiosDe(String apresentador) {
        boolean encontrou = false;
        for (Conteudo c : acervo) {
            if (c instanceof Podcast) {
                Podcast p = (Podcast)c;
                if (p.getApresentador().equalsIgnoreCase(apresentador)) {
                    System.out.println(p);
                    encontrou = true;
                }
            }
        }
        if (!encontrou) System.out.println("Nenhum episódio encontrado para esse apresentador.");
    }
    public void tocarPlaylist(User ouvinte, Playlist playlist) {
        if (ouvinte == null || playlist == null) throw new IllegalArgumentException("Usuário e playlist são obrigatórios.");
        ArrayList<Reproduzivel> fila = new ArrayList<>();
        ArrayList<Conteudo> itens = playlist.getConteudos();
        boolean comAnuncios = ouvinte.getPlano().temAnuncios() && !anuncios.isEmpty();
        int indiceAnuncio = 0;
        for (int i = 0; i < itens.size(); i++) {
            fila.add(itens.get(i));
            if (comAnuncios && (i + 1) % 2 == 0 && i < itens.size() - 1) {
                fila.add(anuncios.get(indiceAnuncio));
                indiceAnuncio = (indiceAnuncio + 1) % anuncios.size();
            }
        }
        for (Reproduzivel item : fila) {
            System.out.println("Duração: " + item.getDuracaoFormatada());
            item.reproduzir();
        }
    }
}
