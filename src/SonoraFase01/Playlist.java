package SonoraFase01;

public class Playlist {
    private String nome;
    private Musica[] musicas = new Musica[100];
    private int quantidadeMusicas;
    private User dono;
    

    public Playlist(String nome , User dono) {
        this.nome = nome;
        this.dono = dono;
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

        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] == null) {
                musicas[i] = musica;
                quantidadeMusicas++;
                return true;
            }
            else if (musicas[i].getTitulo().equals(musica.getTitulo()) && musicas[i].getArtista().equals(musica.getArtista())) {
                System.out.println("A música já está na playlist.");
                return false;
            }
            else if (quantidadeMusicas >= musicas.length) {
                System.out.println("A playlist está cheia.");
                return false;
            }
        }
        return false;
    }

    public Musica getNaPosicao(int posicao) {
        if (posicao >= 0 && posicao < quantidadeMusicas) {
            return musicas[posicao];
        }
        System.out.println("Posição inválida.");
        return null;
    }

    public boolean removerMusica(int posicao) {
        if (posicao >= 0 && posicao < quantidadeMusicas) {
            musicas[posicao] = null;
            musicas[posicao] = musicas[quantidadeMusicas - 1];
            quantidadeMusicas--;
            return true;
        }
        System.out.println("Posição inválida.");
        return false;
    }

    public int getDuracaoTotal() {
        int duracaoTotal = 0;
        for (int i = 0; i < quantidadeMusicas; i++) {
            if (musicas[i] != null) {
                duracaoTotal += musicas[i].getDuracaoSegundos();
            }
        }
        return duracaoTotal;
    }

    public void reproduzirTudo() {
        for (int i = 0; i < quantidadeMusicas; i++) {
            if (musicas[i] != null) {
                musicas[i].reproduzir();
            }
        }
    }

    public void exibirPlaylist() {
        System.out.println("Playlist: " + nome);
        System.out.println("Dono: " + dono.getNome());
        System.out.println("Quantidade de músicas: " + quantidadeMusicas);
        System.out.println("Duração total: " + getDuracaoTotal() + " segundos");
        System.out.println("Músicas:");
        for (int i = 0; i < quantidadeMusicas; i++) {
            if (musicas[i] != null) {
                System.out.println((i + 1) + ". " + musicas[i].getTitulo() + " - " + musicas[i].getArtista() +
                        " (" + musicas[i].getDuracaoFormatada() + ")");
            }
        }
    }
}
  


