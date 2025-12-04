/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2;

/**
 *
 * @author sophi
 */
public class Pasajero {
    private String nombre;
    private String pasaporte;
    private String nacionalidad;

    public Pasajero(String nombre, String pasaporte, String nacionalidad) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getInfo() {
        String texto = "";
        texto = texto + "Nombre: " + nombre + "\n";
        texto = texto + "Pasaporte: " + pasaporte + "\n";
        texto = texto + "Nacionalidad: " + nacionalidad + "\n";
        return texto;
    }
}

