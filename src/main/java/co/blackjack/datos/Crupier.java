package co.blackjack.datos;

public class Crupier extends Participante {

    public Crupier() {
        super("Crupier");
    }

    @Override
    public boolean debePedirCarta() {
        return obtenerPuntuacion() < 17;
    }
}
