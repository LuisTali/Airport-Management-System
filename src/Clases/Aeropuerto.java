package Clases;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Aeropuerto implements Serializable {
    private String _id;
    private boolean activo;
    private double balance;
    private int capacidad;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String acercaDe;
    private LocalDateTime fechaInicio;
    private double longitud;
    private double latitud;
    private ArrayList<String> etiquetas;
    private ArrayList<Avion> aviones;

    public Aeropuerto(String _id, boolean activo, double balance, int capacidad, String nombre, String email, String telefono, String direccion, String acercaDe, LocalDateTime fechaInicio, double longitud, double latitud) {
        this._id = _id;
        this.activo = activo;
        this.balance = balance;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.acercaDe = acercaDe;
        this.fechaInicio = fechaInicio;
        this.longitud = longitud;
        this.latitud = latitud;
        aviones = new ArrayList<>();
        etiquetas = new ArrayList<>();
    }

    public void cargarAviones(Avion a){
        aviones.add(a);
    }

    public void cargarEtiquetas(String e){
        etiquetas.add(e);
    }

    public String get_id() {
        return _id;
    }

    public boolean isActivo() {
        return activo;
    }

    public double getBalance() {
        return balance;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public String getFechaInicio() {
        return fechaInicio.toString();
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setAviones(ArrayList<Avion> aviones) {
        this.aviones = aviones;
    }

    public String mostrarAeropuerto(){
        return "Nombre: " + getNombre() + ", Balance: $" + getBalance() + ", Capacidad:" + getCapacidad() + ", Latitud: " + getLatitud() + ", Longitud: " + getLongitud() + ", Aviones: " + getAviones().toString() + ", Fecha de inicio: " + getFechaInicio();
    }
}
