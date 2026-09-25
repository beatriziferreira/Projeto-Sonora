package SonoraFase05;

import java.util.ArrayList;

public class Episodios {
    private String nome;
    private ArrayList<Podcast> podcasts = new ArrayList<Podcast>();
    private int quantidadePodcasts;
    private User dono;

    public Episodios(String nome, User dono) {
        this.nome = nome;
        this.dono = dono;
        if (this.nome == null) {
            throw new IllegalArgumentException("O nome da playlist não pode ser nulo.");
        }
        if (this.dono == null) {
            throw new IllegalArgumentException("O dono não pode ser nulo.");
        }
    }

    public int getQuantidadepodcasts() {
        return quantidadePodcasts;
    }


    public String getNome() {
        return nome;
    }


    public boolean adicionarpodcast(Podcast podcast) {

        if (podcasts.contains(podcast)) {
            System.out.println("A música já está na playlist.");
            return false;
        }

        podcasts.add(podcast);
        quantidadePodcasts++;
        return true;
    }

    public Podcast getNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= podcasts.size()) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        return podcasts.get(posicao);
    }

    public boolean removerpodcast(int posicao) {
        if (posicao >= 0 && posicao < podcasts.size()) {
            podcasts.remove(posicao);
            quantidadePodcasts--;
            return true;
        }
        throw new IndexOutOfBoundsException("Posição inválida.");
    }

    public int getDuracaoTotal() {
        int duracaoTotal = 0;
        for (int i = 0; i < podcasts.size(); i++) {
            if (podcasts.get(i) != null) {
                duracaoTotal += podcasts.get(i).getDuracaoSegundos();
            }
        }
        return duracaoTotal;
    }

    public void reproduzirTudo() {
        for (int i = 0; i < podcasts.size(); i++) {
            if (podcasts.get(i) != null) {
                podcasts.get(i).reproduzir();
            }
        }
    }

    public void exibirEp() {
        System.out.println(nome);
        System.out.println("Dono: " + dono.getNome());
        System.out.println("Quantidade de podcasts: " + quantidadePodcasts);
        System.out.println("Duração total: " + getDuracaoTotal() + " segundos");
        System.out.println("Podcasts:");
        for (int i = 0; i < podcasts.size(); i++) {
            if (podcasts.get(i) != null) {
                System.out.println((i + 1) + ". " + podcasts.get(i).toString());
            }
        }
    }



}
