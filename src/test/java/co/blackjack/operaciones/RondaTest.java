package co.blackjack.operaciones;

import co.blackjack.datos.Crupier;
import co.blackjack.datos.Jugador;
import co.blackjack.datos.Mazo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RondaTest {

    private Jugador jugador;
    private Crupier crupier;
    private Ronda ronda;

    @BeforeEach
    void setUp() {
        jugador = new Jugador("Ana");
        crupier = new Crupier();
        ronda = new Ronda(jugador, crupier, new Mazo());
    }

    @Test
    void repartirCartasInicialesDaDosCartasACadaUno() {
        ronda.repartirCartasIniciales();
        assertEquals(2, jugador.getMano().cantidadCartas());
        assertEquals(2, crupier.getMano().cantidadCartas());
    }

    @Test
    void jugadorQueSePlantaYaNoPideCarta() {
        ronda.repartirCartasIniciales();
        ronda.jugadorSePlanta();
        ronda.jugadorPideCarta();
        assertEquals(2, jugador.getMano().cantidadCartas());
        assertFalse(jugador.debePedirCarta());
    }

    @Test
    void turnoCrupierTerminaConAlMenos17() {
        ronda.repartirCartasIniciales();
        ronda.turnoCrupier();
        assertTrue(crupier.obtenerPuntuacion() >= 17);
        assertNotNull(ronda.determinarResultado());
    }
}
