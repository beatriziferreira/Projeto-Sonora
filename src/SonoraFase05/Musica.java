package SonoraFase05;

public class Musica extends Conteudo {
    private String album;
    private String artista;
    

    public Musica(String titulo, int duracaoSegundos,String artista, String album) {
        super(titulo, duracaoSegundos);
        this.artista = artista;
        this.album = album;

        if (this.artista == null){
            throw new IllegalArgumentException("O artista não pode ser nulo.");
        }
        if (this.album == null){
            throw new IllegalArgumentException("O álbum não pode ser nulo.");
        }
    }


    public String getAlbum() {
        return album;
    }


    public void setAlbum(String album) {
        this.album = album;
    }


    public String getArtista() {
        return artista;
    }


    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + artista + " (" + album + ")";
    }



}
