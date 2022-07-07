package com.company;

import java.io.Serializable;

public class Piloto extends Persona implements Serializable {

    private int idAvion;

    public Piloto(String nombre, String apellido, int edad, int idAvion) {
        super(nombre, apellido, edad);
        this.idAvion = idAvion;
    }

    public int getIdAvion(){
        return idAvion;
    }

    @Override
    public String toString() {
        return getNombre() + ", " + getApellido() + ", Edad: " + getEdad() + ",\n";
    }
}
