package co.blackjack.datos;

public class Jugador extends Participante {
    private boolean plantado;

    public Jugador(String nombre) {
        super(nombre);
        this.plantado = false;
    }

    public void plantarse() {
        plantado = true;
    }

    @Override
    public boolean debePedirCarta() {
        return !plantado && !getMano().supera21();
    }
}
