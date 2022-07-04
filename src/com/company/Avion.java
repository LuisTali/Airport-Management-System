package com.company;

public class Avion {
    private int ID;
    private Piloto piloto;
    private int capacidad;

    public Avion(int id, Piloto piloto, int capacidad) {
        ID = id;
        this.piloto = piloto;
        this.capacidad = capacidad;
    }

    public int getID() {
        return ID;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "ID Avion: " + getID() + ", Capacidad: " + getCapacidad() + ", Piloto: " + getPiloto().getNombre();
    }
}
