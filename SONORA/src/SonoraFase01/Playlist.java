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
        }
        return false;
    }
    public Musica getNaPosicao(int posicao) {
        if (posicao >= 0 && posicao < quantidadeMusicas) {
            return musicas[posicao];
        }
        return null;
    }
}
