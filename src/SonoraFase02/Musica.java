package SonoraFase02;

public class Musica {
    private static int contador = 0;
    private int id;
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private int reproducoes;

    public Musica(String titulo, String artista, int duracaoSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        contador++;
        id = contador;
        if (this.titulo == null){
            throw new IllegalArgumentException("O título não pode ser nulo.");
        }
        if (this.artista == null){
            throw new IllegalArgumentException("O artista não pode ser nulo.");
        }
        if (this.duracaoSegundos <= 0){
            throw new IllegalArgumentException("Duração inválida. A duração não pode ser menor ou igual a 0.");}
    }
    public int getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getArtista() {
        return artista;
    }


    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }


    public int getReproducoes() {
        return reproducoes;
    }

    public void reproduzir() {
        reproducoes++;
    }


    public String getDuracaoFormatada() {
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }


}
