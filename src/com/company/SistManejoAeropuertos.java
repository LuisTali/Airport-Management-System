package com.company;

import Excepciones.ExcepcionCapacidadAeropuerto;
import org.json.JSONArray;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class SistManejoAeropuertos {
    private ArrayList<Aeropuerto> aeropuertos;
    private ArrayList<Aeropuerto> aeropuertosMayorCapacidad;
    private ClaseTagsPiloto claseG;
    private HashSet<Etiqueta> tags;

    public SistManejoAeropuertos() {
        aeropuertos = new ArrayList<>();
        aeropuertosMayorCapacidad = new ArrayList<>();
        claseG = new ClaseTagsPiloto();
        tags = new HashSet<>();
    }

    public void cargarAeropuertosMayor(int capacidadAux){
        if (aeropuertosMayorCapacidad != null)
            aeropuertosMayorCapacidad.clear();
        for (Aeropuerto a : aeropuertos){
            try {
                cargarAeropuertosMayorCapacidad(a,capacidadAux);
            } catch (ExcepcionCapacidadAeropuerto e) {
                e.printStackTrace();
            }
        }
    }

    public void cargarAeropuertosMayorCapacidad(Aeropuerto a,int capacidadAux) throws ExcepcionCapacidadAeropuerto {
            if (a.getCapacidad() > capacidadAux) aeropuertosMayorCapacidad.add(a);
            else {
                throw new ExcepcionCapacidadAeropuerto("Capacidad de aeropuerto inferior a la deseada, Capacidad actual del Aeropuerto: " + a.getCapacidad(), a.getCapacidad());
            }

    }

    public void añadirAeropuerto(Aeropuerto a) {
        aeropuertos.add(a);
    }

    public Aeropuerto devolverPorIndice(int i) {
        return aeropuertos.get(i);
    }

    public void crearJson(ArrayList<Aeropuerto> aeropuertos) {
        JsonUtiles.grabar(new JSONArray(aeropuertos));
    }

    public ArrayList<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }

    public String mostrarMayorCapacidad() {
        StringBuilder buffer = new StringBuilder();
        for (Aeropuerto a : aeropuertosMayorCapacidad) {
            buffer.append(a.mostrarAeropuerto());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public void cargarClaseGen() {
        for (Aeropuerto a : aeropuertos) {
            ArrayList<String> aux = a.getEtiquetas();
            ArrayList<Avion> auxA = a.getAviones();
            for (Avion avion : auxA) {
                Piloto auxP = avion.getPiloto();
                claseG.añadirPiloto(new Piloto(auxP.getNombre(), auxP.getApellido(), auxP.getEdad(), auxP.getIdAvion()));
            }
            for (String tag : aux)
                claseG.añadirTag(tag);
        }
    }

    public String mostrarClaseGen() {
        return claseG.toString();
    }

    public void pasarTags() {
        for (Aeropuerto a : aeropuertos) {
            ArrayList<String> auxT = a.getEtiquetas();
            for (int i = 0; i < auxT.size(); i++) {
                Etiqueta aux = new Etiqueta(auxT.get(i));
                boolean flag = true;
                if (!(auxT.contains(aux))) tags.add(aux);
            }
        }
    }

    public void aeropuertoFile(){
        try {
            File file1 = new File("Data/Aeropuertos.bin");
            createFolder(file1);
            FileOutputStream fO = new FileOutputStream(file1);
            ObjectOutputStream oO = new ObjectOutputStream(fO);
            for (Aeropuerto a : aeropuertos){
                oO.writeObject(a);
            }
            oO.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFolder(File document) {
        File folder;
        folder = document.getParentFile();
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public void aeropuertoReadFile(){
        try {
            File file1 = new File("Data/Aeropuertos.bin");
            FileInputStream fI = new FileInputStream(file1);
            ObjectInputStream oI = new ObjectInputStream(fI);
            int lectura = 1;
            while (lectura == 1){
                Aeropuerto aux = (Aeropuerto) oI.readObject();
                añadirAeropuerto(aux);
            }
            oI.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public String mostrarTags() {
        StringBuilder buffer = new StringBuilder();
        for (Etiqueta e : tags) {
            buffer.append(e.toString());
            buffer.append(", ");
        }
        return buffer.toString();
    }

    public String mostrar() {
        StringBuilder buffer = new StringBuilder();
        for (Aeropuerto a : aeropuertos) {
            buffer.append(a.mostrarAeropuerto());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
