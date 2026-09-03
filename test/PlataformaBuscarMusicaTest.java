package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import SonoraFase03.Musica;
import SonoraFase03.Plataforma;

public class PlataformaBuscarMusicaTest {

    private Plataforma plataforma;
    private Musica musica1;
    private Musica musica2;

    @BeforeEach
    void preparar() {

        plataforma = new Plataforma();

        musica1 = new Musica("Duvet", "Boa", 204);
        musica2 = new Musica("Fine", "Lemon Demon", 200);

        plataforma.cadastrarMusica(musica1);
        plataforma.cadastrarMusica(musica2);
    }

    @Test
    @DisplayName("Buscar música cadastrada pelo título")
    void buscarPorTitulo() {

        Musica resultado =
            plataforma.buscarMusica("Duvet");

        assertNotNull(resultado);
        assertEquals("Duvet", resultado.getTitulo());
    }

    @Test
    @DisplayName("Buscar música por título inexistente")
    void buscarTituloInexistente() {

        Musica resultado =
            plataforma.buscarMusica("MusicaInexistente");

        assertNull(resultado);
    }

    @Test
    @DisplayName("Buscar música cadastrada pelo ID")
    void buscarPorId() {

        Musica resultado =
            plataforma.buscarMusica(musica1.getId());

        assertNotNull(resultado);
        assertEquals("Duvet", resultado.getTitulo());
    }

    @Test
    @DisplayName("Buscar música por ID inexistente")
    void buscarIdInexistente() {

        Musica resultado =
            plataforma.buscarMusica(9999);

        assertNull(resultado);
    }
}