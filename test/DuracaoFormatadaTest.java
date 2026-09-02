package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import SonoraFase03.Musica;

public class DuracaoFormatadaTest {

    @DisplayName("Duração com minutos e segundos")
    @Test 
    public void testDuracaoFormatadaMinutosSegundos() {
        Musica musica = new Musica("Nome da Musica", "Nome do Artista", 125);
        String duracaoFormatada = musica.getDuracaoFormatada();
        assertEquals("02:05", duracaoFormatada);
    }

    @DisplayName("Duração redonda em minutos")
    @Test 
    public void testDuracaoFormatadaMinutosRedondos() {
        Musica musica = new Musica("Nome da Musica", "Nome do Artista", 90);
        String duracaoFormatada = musica.getDuracaoFormatada();
        assertEquals("01:30", duracaoFormatada);
    }

    @DisplayName("Menos de um minuto, com zero a esquerda")
    @Test 
    public void testDuracaoFormatadaMenosDeUmMinuto() {
        Musica musica = new Musica("Nome da Musica", "Nome do Artista", 5);
        String duracaoFormatada = musica.getDuracaoFormatada();
        assertEquals("00:05", duracaoFormatada);
    }

    @DisplayName("Dois dígitos nos minutos")
    @Test 
    public void testDuracaoFormatadaDoisDigitosMinutos() {
        Musica musica = new Musica("Nome da Musica", "Nome do Artista", 600);
        String duracaoFormatada = musica.getDuracaoFormatada();
        assertEquals("10:00", duracaoFormatada);
    }

    @DisplayName("Valor logo abaixo de dez minutos")
    @Test 
    public void testDuracaoFormatadaMenosDezMinutos() {
        Musica musica = new Musica("Nome da Musica", "Nome do Artista", 599);
        String duracaoFormatada = musica.getDuracaoFormatada();
        assertEquals("09:59", duracaoFormatada);
    }

    

    






    




}
