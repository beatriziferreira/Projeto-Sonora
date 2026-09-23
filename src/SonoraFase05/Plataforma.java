package SonoraFase05;
import java.util.ArrayList;

public class Plataforma {
    private ArrayList<User> usuarios = new ArrayList<User>();
    private ArrayList<Musica> musicas = new ArrayList<Musica>();
    private ArrayList<Playlist> playlists = new ArrayList<Playlist>();

    public boolean cadastrarUsuario(User usuario) {
        usuarios.add(usuario);
        return true;
    }
    

    public boolean cadastrarMusica(Musica musica) {
        musicas.add(musica);
        return true;
    }

    public Musica buscarMusica (int id) {
        for (Musica musica : musicas) {
            if (musica != null && musica.getId() == id) {
                return musica;
            }
        }
        System.out.println("Música não encontrada.");
        return null;
    }

    public Musica buscarMusica (String titulo) {
        for (Musica musica : musicas) {
            if (musica != null && musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        System.out.println("Música não encontrada.");
        return null;
    }


    public User buscarUsuario (String dono) {
        for (User usuario : usuarios) {
            if (usuario != null && usuario.getNome().equalsIgnoreCase(dono)) {
                return usuario;
            }
        }
        System.out.println("Usuário não encontrado. Crie o usuário antes de realizar esta ação.");
        return null;
    }
 

    public int getQuantidadeMusicas() {
        int quantidadeMusicas = 0;
        for (Musica musica : musicas) {
            if (musica != null) {
                quantidadeMusicas++;
            }
        }
        return quantidadeMusicas;

    }

    public boolean cadastrarPlaylist(Playlist playlist) {
        playlists.add(playlist);
        return true;
    } 
    

   public Playlist buscarPlaylist (String nomePlaylist) {
        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getNome().equalsIgnoreCase(nomePlaylist)) {
                return playlists.get(i);
            }
        }
        System.out.println("Playlist não encontrada.");
        return null;
    }

   public void getMusicas() {
        for (int i = 0; i < musicas.size(); i++ ){
            if (musicas.get(i) != null) {
                System.out.println((i + 1) + ". " + musicas.get(i).getTitulo() + " - " + musicas.get(i).getArtista() + " (" + musicas.get(i).getDuracaoFormatada() + ")");
            }
        }
   }

    
}





