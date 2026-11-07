package co.blackjack.datos;
import lombok.Getter;

@Getter
public class Carta {
    private final RangoCarta rango;
    private final Palo palo;

    public Carta(RangoCarta rango, Palo palo) {
        this.rango = rango;
        this.palo = palo;
    }
}

