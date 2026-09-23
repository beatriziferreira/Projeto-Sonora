package SonoraFase05;

public class Conteudo {
    private static int contador = 0;
    private int id;
    private String titulo;
    private int duracaoSegundos;
    private int reproducoes;

    public Conteudo(String titulo, int duracaoSegundos) {
        this.id = ++contador;
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
        if (this.titulo == null){
            throw new IllegalArgumentException("O título não pode ser nulo.");
        }
        if (this.duracaoSegundos <= 0){
            throw new IllegalArgumentException("Duração inválida. A duração não pode ser menor ou igual a 0.");}
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
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

    @Override
    public String toString() {
        return "[" + getId() + "] " + titulo + " (" + getDuracaoFormatada() + ")";
    }
}
