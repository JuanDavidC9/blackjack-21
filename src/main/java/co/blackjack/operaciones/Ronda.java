package co.blackjack.operaciones;

import co.blackjack.datos.Crupier;
import co.blackjack.datos.Jugador;
import co.blackjack.datos.Mazo;
import co.blackjack.datos.ResultadoRonda;
import lombok.Getter;

public class Ronda {
    private final Jugador jugador;
    private final Crupier crupier;
    private final Mazo mazo;
    private final Reglas reglas;

    @Getter
    private ResultadoRonda resultado;

    public Ronda(Jugador jugador, Crupier crupier, Mazo mazo) {
        this.jugador = jugador;
        this.crupier = crupier;
        this.mazo = mazo;
        this.reglas = new Reglas();
    }

    public void repartirCartasIniciales() {
        jugador.pedirCarta(mazo);
        crupier.pedirCarta(mazo);
        jugador.pedirCarta(mazo);
        crupier.pedirCarta(mazo);
    }

    public void jugadorPideCarta() {
        if (jugador.debePedirCarta()) {
            jugador.pedirCarta(mazo);
        }
    }

    public void jugadorSePlanta() {
        jugador.plantarse();
    }

    public void turnoCrupier() {
        while (crupier.debePedirCarta()) {
            crupier.pedirCarta(mazo);
        }
    }

    public ResultadoRonda determinarResultado() {
        resultado = reglas.determinarResultado(jugador, crupier);
        return resultado;
    }
}
