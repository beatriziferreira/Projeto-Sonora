package SonoraFase07;

public class Anuncio implements Faturavel, Reproduzivel {
    private String anunciante;
    private String titulo;
    private int duracaoSegundos;
    private double valorPorMilImpressoes;
    private int impressoes;

    public Anuncio(String anunciante, String titulo, int duracaoSegundos, double valorPorMilImpressoes) {
        if (anunciante == null || anunciante.trim().isEmpty()) throw new IllegalArgumentException("Anunciante é obrigatório.");
        if (titulo == null || titulo.trim().isEmpty()) throw new IllegalArgumentException("Título é obrigatório.");
        if (duracaoSegundos <= 0) throw new IllegalArgumentException("A duração deve ser maior que zero.");
        if (valorPorMilImpressoes <= 0) throw new IllegalArgumentException("O valor por mil impressões deve ser maior que zero.");
        this.anunciante = anunciante;
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.valorPorMilImpressoes = valorPorMilImpressoes;
    }
    public String getAnunciante() { return anunciante; }
    public String getTitulo() { return titulo; }
    @Override
    public int getDuracaoSegundos() { return duracaoSegundos; }
    public double getValorPorMilImpressoes() { return valorPorMilImpressoes; }
    public int getImpressoes() { return impressoes; }
    @Override
    public void reproduzir() {
        impressoes++;
        System.out.println("[Anuncio] " + titulo + " - oferecimento de " + anunciante + ".");
    }
    public double calcularValorVeiculacao() { return impressoes / 1000.0 * valorPorMilImpressoes; }
    @Override
    public double calcularMensalidade() { return calcularValorVeiculacao(); }
}
