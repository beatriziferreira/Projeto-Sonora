package SonoraFase07;

public class Podcast extends Conteudo {
    private String apresentador;
    private int numEpisodio;

    public Podcast(String titulo, int duracaoSegundos, String apresentador, int episodio) {
        super(titulo, duracaoSegundos);
        setApresentador(apresentador);
        setNumEpisodio(episodio);
    }
    public int getNumEpisodio() { return numEpisodio; }
    public void setNumEpisodio(int numEpisodio) {
        if (numEpisodio <= 0) throw new IllegalArgumentException("Insira um número de episódio válido.");
        this.numEpisodio = numEpisodio;
    }
    public String getApresentador() { return apresentador; }
    public void setApresentador(String apresentador) {
        if (apresentador == null || apresentador.trim().isEmpty()) throw new IllegalArgumentException("O apresentador não pode ser nulo ou vazio.");
        this.apresentador = apresentador;
    }
    @Override
    public String getCreditos() { return "episódio " + numEpisodio + " - " + apresentador; }
    @Override
    public String toString() { return super.toString() + " - " + apresentador + " (" + numEpisodio + ")"; }
}
