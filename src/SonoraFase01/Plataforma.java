package SonoraFase01;

public class Plataforma {
    User[] usuarios = new User[500];
    Musica[] musicas = new Musica[500];

    public boolean cadastrarUsuario(User usuario) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = usuario;
                return true;
            }
            else if (usuario == null) {
                System.out.println("Usuário inválido.");
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
                System.out.println("Música inválida.");
                return false;
            }
        }
        System.out.println("A plataforma está cheia.");
        return false;
    }

    public Musica buscarMusicaPorId (int id) {
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

     public int getQuantidadeMusicas() {
        int quantidadeMusicas = 0;
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null) {
                quantidadeMusicas++;
            }
        }
        return quantidadeMusicas;
    }
}





