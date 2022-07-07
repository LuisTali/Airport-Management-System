package com.company;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static Scanner teclado;

    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        SistManejoAeropuertos controlAeropuertos = new SistManejoAeropuertos();
        int respuesta;
        System.out.println("Ingrese opcion");
        respuesta = teclado.nextInt();
        while (respuesta > 0) {
            switch (respuesta) {
                case 1: //Crea el sistema para controlar Aeropuertos, los añade con sus respectivos atributos y luego los muestra.
                    controlAeropuertos.añadirAeropuerto(new Aeropuerto("51hd", true, 233000.0f, 4500, "IgnacioVolador", "volaconIgnacio@gmail.com", "2235342312", "Tripulantes 1234", "bonito, bueno, lindo", LocalDateTime.of(2000, 11, 21, 3, 34), -18, 234.5f));

                    Aeropuerto aux = controlAeropuertos.devolverPorIndice(0);
                    aux.cargarAviones(new Avion(1, (new Piloto("Max", "Rapido", 23, 1)), 8));
                    aux.cargarAviones(new Avion(2, (new Piloto("Flash", "Verstappen", 32, 2)), 12));
                    aux.cargarEtiquetas("Mision");
                    aux.cargarEtiquetas("Rosario");
                    aux.cargarEtiquetas("Savana");

                    controlAeropuertos.añadirAeropuerto(new Aeropuerto("43fg", true, 345200.0f, 3000, "MarioPlaneador", "planeaconMario@gmail.com", "2237349867", "Mario Bravo 2334", "planeador, bueno, bonito", LocalDateTime.of(2001, 9, 23, 13, 23, 34), 184.5f, -23.4f));

                    aux = controlAeropuertos.devolverPorIndice(1);
                    aux.cargarAviones(new Avion(1, (new Piloto("Tifon", "Hashlack", 31, 1)), 14));
                    aux.cargarEtiquetas("Calor");
                    aux.cargarEtiquetas("Savana");
                    aux.cargarEtiquetas("Mision");

                    controlAeropuertos.añadirAeropuerto(new Aeropuerto("23df", false, 0.0f, 4000, "ObstruidoPlanes", "obstruidosplanes@gmail.com", "2235984576", "Rosario 234", "cerrado, sucio, tirado", LocalDateTime.of(1987, 3, 15, 16, 52, 1), 245.6f, 152.5f));

                    aux = controlAeropuertos.devolverPorIndice(2);
                    aux.cargarAviones(new Avion(1, (new Piloto("Ramon", "Ramirez", 53, 1)), 20));
                    aux.cargarAviones(new Avion(2, (new Piloto("Rios", "Risas", 34, 2)), 10));
                    aux.cargarEtiquetas("Destruido");
                    aux.cargarEtiquetas("Cerrado");
                    break;

                case 2:
                    //Crea el JSON con los aeropuertos y sus atributos.
                    controlAeropuertos.crearJson(controlAeropuertos.getAeropuertos());
                    break;

                case 3:
                    //Crea la clase Generica con el ArrayListGenerico Tags y el ArrayListGenerico Piloto, la carga y la muestra.
                    controlAeropuertos.cargarClaseGen();
                    System.out.println(controlAeropuertos.mostrarClaseGen());
                    break;

                case 4:
                    //Pasa los tags a HashSet Tags y los muestra.
                    controlAeropuertos.pasarTags();
                    System.out.println(controlAeropuertos.mostrarTags());
                    break;

                case 5:
                    //Pasa los aeropuertos con capacidad mayor a la requerida por parametro.
                    System.out.println("\n");
                    System.out.println("Ingrese la capacidad para filtrar aeropuertos");
                    int auxCapacidad = teclado.nextInt();
                    controlAeropuertos.cargarAeropuertosMayor(auxCapacidad);
                    System.out.println(controlAeropuertos.mostrarMayorCapacidad());

                case 6:
                    //Crea y carga el archivo con la info de los aeropuertos y los muestra
                    controlAeropuertos.aeropuertoFile();
                    System.out.println("\nArchivo escrito");

                case 7:
                    //Muestra los aeropuertos
                    System.out.println(controlAeropuertos.mostrar());
                    break;

                case 8:
                    //Carga arreglo de Aeropuerto desde el archivo.
                    controlAeropuertos.aeropuertoReadFile();
            }
            System.out.println("Ingrese opcion");
            respuesta = teclado.nextInt();
        }

        System.out.println(controlAeropuertos.mostrar());
    }
}
