package SonoraFase05;

import java.util.ArrayList;

public class Playlist {
    private String nome;
    private ArrayList<Musica> musicas = new ArrayList<Musica>();
    private int quantidadeMusicas;
    private User dono;

    public Playlist(String nome, User dono) {
        this.nome = nome;
        this.dono = dono;
        if (this.nome == null) {
            throw new IllegalArgumentException("O nome da playlist não pode ser nulo.");
        }
        if (this.dono == null) {
            throw new IllegalArgumentException("O dono não pode ser nulo.");
        }
    }

    public String getNome() {
        return nome;
    }

    public User getDono() {
        return dono;
    }

    public int getQuantidadeMusicas() {
        return quantidadeMusicas;
    }

    public boolean adicionarMusica(Musica musica) {

        if (musicas.contains(musica)) {
            System.out.println("A música já está na playlist.");
            return false;
        }

        musicas.add(musica);
        quantidadeMusicas++;
        return true;
    }

    public Musica getNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= musicas.size()) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        return musicas.get(posicao);
    }

    public boolean removerMusica(int posicao) {
        if (posicao >= 0 && posicao < musicas.size()) {
            musicas.remove(posicao);
            quantidadeMusicas--;
            return true;
        }
        throw new IndexOutOfBoundsException("Posição inválida.");
    }

    public int getDuracaoTotal() {
        int duracaoTotal = 0;
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i) != null) {
                duracaoTotal += musicas.get(i).getDuracaoSegundos();
            }
        }
        return duracaoTotal;
    }

    public void reproduzirTudo() {
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i) != null) {
                musicas.get(i).reproduzir();
            }
        }
    }

    public void exibirPlaylist() {
        System.out.println("Playlist: " + nome);
        System.out.println("Dono: " + dono.getNome());
        System.out.println("Quantidade de músicas: " + quantidadeMusicas);
        System.out.println("Duração total: " + getDuracaoTotal() + " segundos");
        System.out.println("Músicas:");
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i) != null) {
                System.out.println((i + 1) + ". " + musicas.get(i).getTitulo() + " - " + musicas.get(i).getArtista() +
                        " (" + musicas.get(i).getDuracaoFormatada() + ") [Reproduções totais: "
                        + musicas.get(i).getReproducoes() + "]");
            }
        }
    }
}
