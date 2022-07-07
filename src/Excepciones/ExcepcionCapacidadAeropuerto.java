package Excepciones;

public class ExcepcionCapacidadAeropuerto extends Exception{
    private int capacidad;

    public ExcepcionCapacidadAeropuerto(String message, int capacidad) {
        super(message);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
