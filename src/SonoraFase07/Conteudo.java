package SonoraFase07;

public abstract class Conteudo implements Reproduzivel {
    private static int contador = 0;
    private int id;
    private String titulo;
    private int duracaoSegundos;
    private int reproducoes;

    public Conteudo(String titulo, int duracaoSegundos) {
        this.id = ++contador;
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
    }

    public int getId() { return id; }
    protected void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty())
            throw new IllegalArgumentException("O título não pode ser nulo ou vazio.");
        this.titulo = titulo;
    }
    @Override
    public int getDuracaoSegundos() { return duracaoSegundos; }
    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0)
            throw new IllegalArgumentException("A duração deve ser maior que zero.");
        this.duracaoSegundos = duracaoSegundos;
    }
    public int getReproducoes() { return reproducoes; }

    @Override
    public final void reproduzir() {
        reproducoes++;
        System.out.println("Reproduzindo: " + getTitulo() + " - " + getCreditos());
    }

    public abstract String getCreditos();

    @Override
    public String toString() {
        return titulo + " (" + getDuracaoFormatada() + ")";
    }
}
