package SonoraFase03;

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
            if (musicas[i] != null && musicas[i].getTitulo().equalsIgnoreCase(titulo)) {
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

    public User buscarUsuario (String dono) {
        for (int i = 0; i < playlists.length; i++) {
            if (usuarios[i] != null && usuarios[i].getNome().equalsIgnoreCase(dono)) {
                return usuarios[i];
            }
        }
        System.out.println("Usuário não encontrado. Crie o usuário antes de criar a playlist.");
        return null;
    }
 

    public int getQuantidadeMusicas() {
        int quantidadeMusicas = 0;
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null) {
                quantidadeMusicas++;
            }
        }
        return quantidadeMusicas;

    }

    public boolean cadastrarPlaylist(Playlist playlist) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i] == null) {
                playlists[i] = playlist;
                return true;
            }
            else if (playlist == null) {
                return false;
            }
        }
        System.out.println("A plataforma está cheia.");
        return false;
    }
    

   public Playlist buscarPlaylist (String nomePlaylist) {
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i] != null && playlists[i].getNome().equalsIgnoreCase(nomePlaylist)) {
                return playlists[i];
            }
        }
        System.out.println("Playlist não encontrada.");
        return null;
    }

   public void getMusicas() {
    for (int i = 0; i < getQuantidadeMusicas(); i++ ){
        if (musicas[i] != null) {
            System.out.println((i + 1) + ". " + musicas[i].getTitulo() + " - " + musicas[i].getArtista() + " (" + musicas[i].getDuracaoFormatada() + ")");
        }
        }
   }

    
}





