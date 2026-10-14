package SonoraFase07;

import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Conteudo> conteudos = new ArrayList<>();
    private User dono;

    public Playlist(String nome, User dono) {
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("O nome da playlist não pode ser nulo ou vazio.");
        if (dono == null) throw new IllegalArgumentException("O dono não pode ser nulo.");
        this.nome = nome;
        this.dono = dono;
    }
    public String getNome() { return nome; }
    public User getDono() { return dono; }
    public int getQuantidadeMusicas() { return conteudos.size(); }
    public ArrayList<Conteudo> getConteudos() { return new ArrayList<>(conteudos); }
    public boolean adicionarConteudo(Conteudo conteudo) {
        if (conteudo == null) throw new IllegalArgumentException("O conteúdo não pode ser nulo.");
        if (conteudos.contains(conteudo)) { System.out.println("O conteúdo já está na playlist."); return false; }
        conteudos.add(conteudo);
        return true;
    }
    public boolean adicionarMusica(Musica musica) { return adicionarConteudo(musica); }
    public boolean adicionarPodcast(Podcast podcast) { return adicionarConteudo(podcast); }
    public Conteudo getNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= conteudos.size()) throw new IndexOutOfBoundsException("Posição inválida.");
        return conteudos.get(posicao);
    }
    public boolean removerMusica(int posicao) {
        if (posicao >= 0 && posicao < conteudos.size()) { conteudos.remove(posicao); return true; }
        throw new IndexOutOfBoundsException("Posição inválida.");
    }
    public int getDuracaoTotal() {
        int total = 0;
        for (Conteudo c : conteudos) if (c != null) total += c.getDuracaoSegundos();
        return total;
    }
    public int getDuracaoTotalSegundos() { return getDuracaoTotal(); }
    public void reproduzirTudo() {
        for (Conteudo c : conteudos) if (c != null) c.reproduzir();
    }
    public void exibirPlaylist() {
        System.out.println("Playlist: " + nome);
        System.out.println("Dono: " + dono.getNome());
        System.out.println("Quantidade de conteúdos: " + conteudos.size());
        System.out.println("Duração total: " + getDuracaoTotal() + " segundos");
        for (int i = 0; i < conteudos.size(); i++) System.out.println((i + 1) + ". " + conteudos.get(i));
    }
}
