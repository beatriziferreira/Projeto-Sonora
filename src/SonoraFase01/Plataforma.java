package SonoraFase01;

public class Plataforma {
    private User[] usuarios = new User[500];
    private Musica[] musicas = new Musica[500];
    private Playlist[] playlists = new Playlist[500];

    public boolean cadastrarUsuario(User usuario) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = usuario;
                return true;
            }
            else if (usuario == null) {
                return false;
            }
        }
        System.out.println("A plataforma está cheia.");
        return false;
    }

    public boolean cadastrarMusica(Musica musica) {
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] == null) {
                musicas[i] = musica;
                return true;
            }
            else if (musica == null) {
                return false;
            }
        }
        System.out.println("A plataforma está cheia.");
        return false;
    }

    public Musica buscarMusica (int id) {
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null && musicas[i].getId() == id) {
                return musicas[i];
            }
        }
        System.out.println("Música não encontrada.");
        return null;
    }

    public Musica buscarMusica (String titulo) {
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null && musicas[i].getTitulo().equals(titulo)) {
                return musicas[i];
            }
        }
        System.out.println("Música não encontrada.");
        return null;
    }

    public int getQuantidadeUsuarios() {
        int quantidade = 0;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public User getUsuarioNaPosicao(int posicao) {
        if (posicao >= 0 && posicao < usuarios.length) {
            return usuarios[posicao];
        }
        System.out.println("Posição inválida.");
        return null;}

    public int getQuantidadeMusicas() {
        int quantidadeMusicas = 0;
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null) {
                quantidadeMusicas++;
            }
        }
        return quantidadeMusicas;

    }

    public int getQuantidadePlaylists() {
        int quantidadePlaylists = 0;
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i] != null) {
                quantidadePlaylists++;
            }
        }
        return quantidadePlaylists;
    }

    public Playlist getPlaylistNaPosicao(int posicao) {
        if (posicao >= 0 && posicao < playlists.length) {
            return playlists[posicao];
        }
        System.out.println("Posição inválida.");
        return null;
    }

    public boolean cadastrarPlaylist(Playlist playlist) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i] == null) {
                playlists[i] = playlist;
                return true;
            }
            else if (playlists == null) {
                return false;
            }
        }
        System.out.println("A plataforma está cheia.");
        return false;
    }


}





