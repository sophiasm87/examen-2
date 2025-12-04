/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2;

/**
 *
 * @author sophi
 */
public class Asiento {
    private String codigo;      
    private String clase;      
    private double precioBase;
    private String estado;     
    private Pasajero pasajero; 

    public Asiento(String codigo, String clase, double precioBase) {
        this.codigo = codigo;
        this.clase = clase;
        this.precioBase = precioBase;
        this.estado = "Libre";
        this.pasajero = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getClase() {
        return clase;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero nuevoPasajero) {
        this.pasajero = nuevoPasajero;
    }

    public String getLineaMapa() {
        String texto = "";
        texto = texto + codigo;
        texto = texto + " - Clase: " + clase;
        texto = texto + " - Estado: " + estado;
        texto = texto + " - Precio: " + precioBase;
        return texto;
    }
}


