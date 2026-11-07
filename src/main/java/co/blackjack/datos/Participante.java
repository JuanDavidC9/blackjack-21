package co.blackjack.datos;

import lombok.Getter;

@Getter
public abstract class Participante {
    private final String nombre;
    private final Mano mano;

    public Participante(String nombre) {
        this.nombre = nombre;
        this.mano = new Mano();
    }

    public void pedirCarta(Mazo mazo) {
        mano.agregarCarta(mazo.repartirCarta());
    }

    public int obtenerPuntuacion() {
        return mano.calcularPuntuacion();
    }

    public abstract boolean debePedirCarta();
}
