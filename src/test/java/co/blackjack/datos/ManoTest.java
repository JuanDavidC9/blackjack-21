package co.blackjack.datos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManoTest {

    private Mano mano;

    @BeforeEach
    void setUp() {
        mano = new Mano();
    }

    @Test
    void sumaCartasNumericas() {
        mano.agregarCarta(new Carta(RangoCarta.CINCO, Palo.PICAS));
        mano.agregarCarta(new Carta(RangoCarta.SIETE, Palo.PICAS));
        assertEquals(12, mano.calcularPuntuacion());
    }

    @Test
    void asVale11SiNoSePasaDe21() {
        mano.agregarCarta(new Carta(RangoCarta.AS, Palo.PICAS));
        mano.agregarCarta(new Carta(RangoCarta.K, Palo.PICAS));
        assertEquals(21, mano.calcularPuntuacion());
    }

    @Test
    void asVale1SiSePasaDe21() {
        mano.agregarCarta(new Carta(RangoCarta.AS, Palo.PICAS));
        mano.agregarCarta(new Carta(RangoCarta.CINCO, Palo.PICAS));
        mano.agregarCarta(new Carta(RangoCarta.K, Palo.PICAS));
        assertEquals(16, mano.calcularPuntuacion());
    }

    @Test
    void detectaCuandoSePasaDe21() {
        mano.agregarCarta(new Carta(RangoCarta.K, Palo.PICAS));
        mano.agregarCarta(new Carta(RangoCarta.Q, Palo.PICAS));
        assertFalse(mano.supera21());
        mano.agregarCarta(new Carta(RangoCarta.CINCO, Palo.PICAS));
        assertTrue(mano.supera21());
    }
}
