package test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import SonoraFase03.Musica;

public class MusicaTest {

    @DisplayName("Título vazio deve ser rejeitado")
    @Test
    public void testMusicaNomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Musica(null, "Nome do Artista", 200);
        });
    } 

    @DisplayName("Duração negativa deve ser rejeitada")
    @Test
    public void testDuracaoNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Musica("Nome da Musica", "Nome do Artista", -200);
        });
    }

    @DisplayName("Duração zero deve ser rejeitada")
    @Test
    public void testDuracaoZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Musica("Nome da Musica", "Nome do Artista", 0);
        });
    }

    @DisplayName("Artista nulo deve ser rejeitado")
    @Test
    public void testArtistaNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Musica("Nome da Musica", null, 0);
        });
    }

    @DisplayName("Dados validos criam a música ")
    @Test
    public void testMusicaValida() {
        new Musica("Nome da Musica", "Nome do Artista", 200);
    }

    @DisplayName("Dados validos criam a música com id maior que zero ")
    @Test
    public void testMusicaValidaID() {
        assertEquals(1, new Musica("Nome da Musica", "Nome do Artista", 200).getId());
    }
}

   
    


         


