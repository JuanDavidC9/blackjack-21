package co.blackjack.datos;

import lombok.Getter;

@Getter
public enum RangoCarta {
    AS(11), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7),
    OCHO(8), NUEVE(9), DIEZ(10), J(10), Q(10), K(10);

    private final int valor;

    RangoCarta(int valor) {
        this.valor = valor;
    }
}
