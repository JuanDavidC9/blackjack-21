package co.blackjack.datos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MazoTest {

    private Mazo mazo;

    @BeforeEach
    void setUp() {
        mazo = new Mazo();
    }

    @Test
    void mazoNuevoTiene52Cartas() {
        assertEquals(52, mazo.cantidadCartas());
    }

    @Test
    void repartirCartaReduceElMazo() {
        mazo.repartirCarta();
        assertEquals(51, mazo.cantidadCartas());
    }

    @Test
    void repartirConMazoVacioLanzaExcepcion() {
        for (int i = 0; i < 52; i++) {
            mazo.repartirCarta();
        }
        assertThrows(IllegalStateException.class, () -> mazo.repartirCarta());
    }
}
