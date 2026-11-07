package co.blackjack.operaciones;

import co.blackjack.datos.Carta;
import co.blackjack.datos.Crupier;
import co.blackjack.datos.Jugador;
import co.blackjack.datos.Palo;
import co.blackjack.datos.RangoCarta;
import co.blackjack.datos.ResultadoRonda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReglasTest {

    private Reglas reglas;
    private Jugador jugador;
    private Crupier crupier;

    @BeforeEach
    void setUp() {
        reglas = new Reglas();
        jugador = new Jugador("Ana");
        crupier = new Crupier();
    }

    private void dar(Jugador j, RangoCarta primera, RangoCarta segunda) {
        j.getMano().agregarCarta(new Carta(primera, Palo.PICAS));
        j.getMano().agregarCarta(new Carta(segunda, Palo.PICAS));
    }

    private void dar(Crupier c, RangoCarta primera, RangoCarta segunda) {
        c.getMano().agregarCarta(new Carta(primera, Palo.PICAS));
        c.getMano().agregarCarta(new Carta(segunda, Palo.PICAS));
    }

    @Test
    void jugadorQueSePasaPierde() {
        dar(jugador, RangoCarta.K, RangoCarta.Q);
        jugador.getMano().agregarCarta(new Carta(RangoCarta.CINCO, Palo.PICAS));
        dar(crupier, RangoCarta.K, RangoCarta.SEIS);
        assertEquals(ResultadoRonda.PERDIDA, reglas.determinarResultado(jugador, crupier));
    }

    @Test
    void jugadorGanaSiElCrupierSePasa() {
        dar(jugador, RangoCarta.K, RangoCarta.SEIS);
        dar(crupier, RangoCarta.K, RangoCarta.Q);
        crupier.getMano().agregarCarta(new Carta(RangoCarta.CINCO, Palo.PICAS));
        assertEquals(ResultadoRonda.GANADA, reglas.determinarResultado(jugador, crupier));
    }

    @Test
    void ganaQuienTieneMayorPuntuacion() {
        dar(jugador, RangoCarta.K, RangoCarta.NUEVE);
        dar(crupier, RangoCarta.K, RangoCarta.OCHO);
        assertEquals(ResultadoRonda.GANADA, reglas.determinarResultado(jugador, crupier));
    }

    @Test
    void empateConIgualPuntuacion() {
        dar(jugador, RangoCarta.K, RangoCarta.NUEVE);
        dar(crupier, RangoCarta.Q, RangoCarta.NUEVE);
        assertEquals(ResultadoRonda.EMPATE, reglas.determinarResultado(jugador, crupier));
    }
}
