package SonoraFase05;

public class Podcast extends Conteudo  {
    private String apresentador;
    private int numEpisodio;

    public Podcast (String titulo, int duracaoSegundos,String apresentador, int episodio) {
        super(titulo, duracaoSegundos);
        this.apresentador = apresentador;
        this.numEpisodio = episodio;

        if (this.apresentador == null){
            throw new IllegalArgumentException("O apresentador não pode ser nulo.");
        }
        if (this.numEpisodio <= 0){
            throw new IllegalArgumentException("Insira um número válido");
        }
    }


    public int getNumEpisodio() {
        return numEpisodio;
    }


    public void setNumEpisodio(int numEpisodio) {
        this.numEpisodio = numEpisodio;
    }


    public String getApresentador() {
        return apresentador;
    }


    public void setApresentador(String apresentador) {
        this.apresentador = apresentador;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + apresentador + " (" + numEpisodio + ")";
    }


}
