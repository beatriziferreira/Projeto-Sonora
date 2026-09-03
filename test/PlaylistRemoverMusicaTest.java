package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import SonoraFase03.Musica;
import SonoraFase03.Playlist;
import SonoraFase03.User;

public class PlaylistRemoverMusicaTest {

    private Playlist playlist;
    private Musica musica1;
    private Musica musica2;
    private Musica musica3;

    @BeforeEach
    void preparar() {

        User usuario = new User("Beatriz", "bea@gmail.com");

        playlist = new Playlist("MinhaPlaylist", usuario);

        musica1 = new Musica("Duvet", "Boa", 204);
        musica2 = new Musica("Fine", "Lemon Demon", 200);
        musica3 = new Musica("PerfectSystem", "Oingo Boingo", 226);

        playlist.adicionarMusica(musica1);
        playlist.adicionarMusica(musica2);
        playlist.adicionarMusica(musica3);
    }

    @Test
    @DisplayName("Remover uma música de uma posição válida")
    void removerPrimeiraMusica() {

        boolean resultado = playlist.removerMusica(0);

        assertTrue(resultado);
        assertEquals(2, playlist.getQuantidadeMusicas());

        assertEquals(
            "Fine",
            playlist.getNaPosicao(0).getTitulo()
        );
    }

    @Test
    @DisplayName("Remover uma música do meio da playlist")
    void removerMusicaDoMeio() {

        boolean resultado = playlist.removerMusica(1);

        assertTrue(resultado);
        assertEquals(2, playlist.getQuantidadeMusicas());

        assertEquals(
            "PerfectSystem",
            playlist.getNaPosicao(1).getTitulo()
        );
    }

    @Test
    @DisplayName("Tentar remover usando índice negativo")
    void removerIndiceNegativo() {

        assertThrows(
            IndexOutOfBoundsException.class,
            () -> playlist.removerMusica(-1)
        );
    }

    @Test
    @DisplayName("Tentar remover usando índice além da quantidade")
    void removerIndiceInvalido() {

        assertThrows(
            IndexOutOfBoundsException.class,
            () -> playlist.removerMusica(3)
        );
    }
}