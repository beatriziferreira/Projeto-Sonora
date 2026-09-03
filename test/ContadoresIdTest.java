package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import SonoraFase03.Musica;
import SonoraFase03.User;

public class ContadoresIdTest {

    @Test
    @DisplayName("IDs de músicas devem ser sequenciais")
    void idsMusicasSequenciais() {

        Musica musica1 =
            new Musica("MusicaA", "ArtistaA", 200);

        Musica musica2 =
            new Musica("MusicaB", "ArtistaB", 200);

        Musica musica3 =
            new Musica("MusicaC", "ArtistaC", 200);

        assertEquals(
            musica1.getId() + 1,
            musica2.getId()
        );

        assertEquals(
            musica2.getId() + 1,
            musica3.getId()
        );
    }

    @Test
    @DisplayName("Criar uma música deve aumentar o ID em um")
    void idMusicaAumentaUm() {

        Musica musica1 =
            new Musica("MusicaA", "ArtistaA", 200);

        Musica musica2 =
            new Musica("MusicaB", "ArtistaB", 200);

        assertEquals(
            musica1.getId() + 1,
            musica2.getId()
        );
    }

    @Test
    @DisplayName("IDs de músicas e usuários são independentes")
    void idsIndependentes() {

        Musica musica =
            new Musica("Duvet", "Boa", 204);

        User usuario =
            new User("Beatriz", "bea@gmail.com");

        assertNotEquals(
            musica.getId(),
            usuario.getId()
        );
    }

    @Test
    @DisplayName("Criar usuário não altera a sequência de IDs das músicas")
    void usuarioNaoAlteraIdMusica() {

        Musica musica1 =
            new Musica("MusicaA", "ArtistaA", 200);

        new User("Beatriz", "bea@gmail.com");

        Musica musica2 =
            new Musica("MusicaB", "ArtistaB", 200);

        assertEquals(
            musica1.getId() + 1,
            musica2.getId()
        );
    }
}
