package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import SonoraFase03.Musica;
import SonoraFase03.Playlist;
import SonoraFase03.User;

public class AdicionarMusicaTest {

    private Playlist playlist;
    private User usuario;
    private Musica musica1;
    private Musica musica2;

    @BeforeEach
    void preparar() {
        usuario = new User("Beatriz", "bea@gmail.com");
        playlist = new Playlist("MinhaPlaylist", usuario);

        musica1 = new Musica("Duvet", "Boa", 204);
        musica2 = new Musica("Fine", "Lemon Demon", 200);
    }

    @Test
    @DisplayName("Adicionar uma música em uma playlist com espaço disponível")
    void adicionarMusicaComEspaco() {
        boolean resultado = playlist.adicionarMusica(musica1);

        assertTrue(resultado);
        assertEquals(1, playlist.getQuantidadeMusicas());
    }

    @Test
    @DisplayName("Adicionar várias músicas em uma playlist com espaço disponível")
    void adicionarVariasMusicas() {
        boolean resultado1 = playlist.adicionarMusica(musica1);
        boolean resultado2 = playlist.adicionarMusica(musica2);

        assertTrue(resultado1);
        assertTrue(resultado2);
        assertEquals(2, playlist.getQuantidadeMusicas());
    }

    @Test
    @DisplayName("Tentar adicionar uma música que já está na playlist")
    void adicionarMusicaDuplicada() {
        playlist.adicionarMusica(musica1);

        boolean resultado = playlist.adicionarMusica(musica1);

        assertFalse(resultado);
        assertEquals(1, playlist.getQuantidadeMusicas());
    }

    @Test
    @DisplayName("Tentar adicionar uma música quando a playlist está cheia")
    void adicionarMusicaPlaylistCheia() {

        for (int i = 0; i < 100; i++) {
            Musica musica = new Musica(
                "Musica" + i,
                "Artista" + i,
                200
            );

            assertTrue(playlist.adicionarMusica(musica));
        }

        Musica musica101 = new Musica(
            "Musica101",
            "Artista101",
            200
        );

        boolean resultado = playlist.adicionarMusica(musica101);

        assertFalse(resultado);
        assertEquals(100, playlist.getQuantidadeMusicas());
    }
}