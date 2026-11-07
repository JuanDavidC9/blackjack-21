package co.blackjack.datos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private final List<Carta> cartas = new ArrayList<>();

    public Mazo() {
        for (Palo palo : Palo.values()) {
            for (RangoCarta rango : RangoCarta.values()) {
                cartas.add(new Carta(rango, palo));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta repartirCarta() {
        if (cartas.isEmpty()) {
            throw new IllegalStateException("El mazo no tiene cartas");
        }
        return cartas.remove(0);
    }

    public int cantidadCartas() {
        return cartas.size();
    }
}
