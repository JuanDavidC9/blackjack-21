package co.blackjack.datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CrupierTest {

    @Test
    void pideCartaConMenosDe17() {
        Crupier crupier = new Crupier();
        crupier.getMano().agregarCarta(new Carta(RangoCarta.K, Palo.TREBOLES));
        crupier.getMano().agregarCarta(new Carta(RangoCarta.SEIS, Palo.TREBOLES));
        assertTrue(crupier.debePedirCarta());
    }

    @Test
    void sePlantaCon17OMas() {
        Crupier crupier = new Crupier();
        crupier.getMano().agregarCarta(new Carta(RangoCarta.K, Palo.TREBOLES));
        crupier.getMano().agregarCarta(new Carta(RangoCarta.SIETE, Palo.TREBOLES));
        assertFalse(crupier.debePedirCarta());
    }
}
