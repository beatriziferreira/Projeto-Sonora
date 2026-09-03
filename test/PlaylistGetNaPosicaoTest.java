package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import SonoraFase03.Musica;
import SonoraFase03.Playlist;
import SonoraFase03.User;


public class PlaylistGetNaPosicaoTest {

    private Playlist playlist;
    private Musica musica1;
    private Musica musica2;

    @BeforeEach
    void preparar() {

        User usuario = new User("Beatriz", "bea@gmail.com");

        playlist = new Playlist("MinhaPlaylist", usuario);

        musica1 = new Musica("Duvet", "Boa", 204);
        musica2 = new Musica("Fine", "Lemon Demon", 200);

        playlist.adicionarMusica(musica1);
        playlist.adicionarMusica(musica2);
    }

    @Test
    @DisplayName("Buscar uma música em uma posição válida")
    void buscarPosicaoValida() {

        Musica resultado = playlist.getNaPosicao(0);

        assertNotNull(resultado);
        assertEquals("Duvet", resultado.getTitulo());
    }

    @Test
    @DisplayName("Buscar uma posição com índice negativo")
    void buscarIndiceNegativo() {

        assertThrows(
            IndexOutOfBoundsException.class,
            () -> playlist.getNaPosicao(-1)
        );
    }

    @Test
    @DisplayName("Buscar uma posição além da quantidade de músicas")
    void buscarIndiceMaiorQueQuantidade() {

        assertThrows(
            IndexOutOfBoundsException.class,
            () -> playlist.getNaPosicao(2)
        );
    }

    @Test
    @DisplayName("Buscar a última música da playlist")
    void buscarUltimaMusica() {

        Musica resultado = playlist.getNaPosicao(1);

        assertNotNull(resultado);
        assertEquals("Fine", resultado.getTitulo());
    }
}