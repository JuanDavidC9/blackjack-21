package co.blackjack.datos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartaTest {

    @Test
    void cartaGuardaRangoYPalo() {
        Carta carta = new Carta(RangoCarta.AS, Palo.PICAS);
        assertEquals(RangoCarta.AS, carta.getRango());
        assertEquals(Palo.PICAS, carta.getPalo());
    }

    @Test
    void figurasValenDiez() {
        assertEquals(10, RangoCarta.K.getValor());
    }
}