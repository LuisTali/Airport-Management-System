package com.company;

public class ClaseTagsPiloto {
    private ArrayListGenerico<String> tags;
    private ArrayListGenerico<Piloto> pilotos;

    public ClaseTagsPiloto() {
        tags = new ArrayListGenerico<>();
        pilotos = new ArrayListGenerico<>();
    }


    public void añadirTag(String t){
        tags.añadir(t);
    }

    public void añadirPiloto(Piloto p){
        pilotos.añadir(p);
    }

    @Override
    public String toString() {
        return "ClaseGenerica: " +
                "\n Tags: " + tags.toString() +
                "\n Pilotos: \n " + pilotos.toString();
    }
}
