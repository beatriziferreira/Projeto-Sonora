package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import SonoraFase03.Musica;

public class MusicaReproduzirTest {

    private Musica musica;

    @BeforeEach
    void preparar() {
        musica = new Musica(
            "Duvet",
            "Boa",
            204
        );
    }

    @Test
    @DisplayName("Reproduzir uma música uma vez")
    void reproduzirUmaVez() {

        musica.reproduzir();

        assertEquals(1, musica.getReproducoes());
    }

    @Test
    @DisplayName("Reproduzir uma música duas vezes")
    void reproduzirDuasVezes() {

        musica.reproduzir();
        musica.reproduzir();

        assertEquals(2, musica.getReproducoes());
    }

    @Test
    @DisplayName("Reproduzir uma música várias vezes")
    void reproduzirCincoVezes() {

        musica.reproduzir();
        musica.reproduzir();
        musica.reproduzir();
        musica.reproduzir();
        musica.reproduzir();

        assertEquals(5, musica.getReproducoes());
    }

    @Test
    @DisplayName("Cada reprodução aumenta o contador exatamente em um")
    void contadorAumentaUmPorReproducao() {

        assertEquals(0, musica.getReproducoes());

        musica.reproduzir();
        assertEquals(1, musica.getReproducoes());

        musica.reproduzir();
        assertEquals(2, musica.getReproducoes());

        musica.reproduzir();
        assertEquals(3, musica.getReproducoes());
    }
}