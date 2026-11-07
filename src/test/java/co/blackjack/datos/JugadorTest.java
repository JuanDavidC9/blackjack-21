package co.blackjack.datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JugadorTest {

    @Test
    void pedirCartaLaAgregaALaMano() {
        Jugador jugador = new Jugador("Ana");
        jugador.pedirCarta(new Mazo());
        assertEquals(1, jugador.getMano().cantidadCartas());
    }

    @Test
    void jugadorPlantadoYaNoPideCarta() {
        Jugador jugador = new Jugador("Ana");
        assertTrue(jugador.debePedirCarta());
        jugador.plantarse();
        assertFalse(jugador.debePedirCarta());
    }
}
