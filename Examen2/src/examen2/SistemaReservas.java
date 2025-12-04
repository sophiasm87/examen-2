/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2;

import javax.swing.JOptionPane;

/**
 *
 * @author sophi
 */
public class SistemaReservas {
    private Asiento[][] asientos;
    private double recaudacionTotal;
    private int totalAsientos;

    public SistemaReservas() {
        asientos = new Asiento[5][4]; 
        totalAsientos = 20;
        recaudacionTotal = 0;
        cargarAvion();
    }

    private void cargarAvion() {
       

        for (int f = 0; f < 5; f++) {
            for (int c = 0; c < 4; c++) {

                String codigo = (f + 1) + letra(c);
                String clase;
                double precio;

                if (f == 0) {
                    clase = "Primera";
                    precio = 800;
                } else if (f == 1 || f == 2) {
                    clase = "Business";
                    precio = 500;
                } else {
                    clase = "Economica";
                    precio = 300;
                }

                asientos[f][c] = new Asiento(codigo, clase, precio);
            }
        }
    }

    private String letra(int col) {
        if (col == 0) {
            return "A";
        } else if (col == 1) {
            return "B";
        } else if (col == 2) {
            return "C";
        } else {
            return "D";
        }
    }

   
    public void verMapa() {
        String texto = "MAPA DEL AVIÓN\n\n";

        for (int f = 0; f < 5; f++) {
            texto = texto + "Fila " + (f + 1) + ":\n";
            for (int c = 0; c < 4; c++) {
                texto = texto + asientos[f][c].getLineaMapa() + "\n";
            }
            texto = texto + "\n";
        }

        JOptionPane.showMessageDialog(null, texto);
    }

 
    private Asiento elegirAsiento() {

        String sf = JOptionPane.showInputDialog("Digite la fila (1-5):");
        if (sf == null) {
            return null;
        }

        int fila = Integer.parseInt(sf);

        if (fila < 1 || fila > 5) {
            return null;
        }

        String sl = JOptionPane.showInputDialog("Digite la letra del asiento (A-D):");
        if (sl == null) {
            return null;
        }

        sl = sl.toUpperCase();
        int col = -1;

        if (sl.equals("A")) {
            col = 0;
        } else if (sl.equals("B")) {
            col = 1;
        } else if (sl.equals("C")) {
            col = 2;
        } else if (sl.equals("D")) {
            col = 3;
        }

        if (col == -1) {
            return null;
        }

        return asientos[fila - 1][col];
    }

    
    private Pasajero pedirPasajero() {

        String n = JOptionPane.showInputDialog("Nombre del pasajero:");
        if (n == null) {
            return null;
        }

        String p = JOptionPane.showInputDialog("Pasaporte:");
        if (p == null) {
            return null;
        }

        String na = JOptionPane.showInputDialog("Nacionalidad:");
        if (na == null) {
            return null;
        }

        Pasajero pasajero = new Pasajero(n, p, na);
        return pasajero;
    }

  
    public void reservar() {

        Asiento a = elegirAsiento();
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Asiento no válido.");
            return;
        }

        if (!a.getEstado().equals("Libre")) {
            JOptionPane.showMessageDialog(null, "El asiento está ocupado.");
            return;
        }

        Pasajero pa = pedirPasajero();
        if (pa == null) {
            return;
        }

        a.setPasajero(pa);
        a.setEstado("Ocupado");
        recaudacionTotal = recaudacionTotal + a.getPrecioBase();

        JOptionPane.showMessageDialog(null, "Reserva realizada correctamente.");
    }

   
    public void reservarDescuento() {

        Asiento a = elegirAsiento();
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Asiento no válido.");
            return;
        }

        if (!a.getEstado().equals("Libre")) {
            JOptionPane.showMessageDialog(null, "El asiento está ocupado.");
            return;
        }

        Pasajero pa = pedirPasajero();
        if (pa == null) {
            return;
        }

        double base = a.getPrecioBase();
        double descuento;

        if (a.getClase().equals("Primera")) {
            descuento = 0.15;
        } else if (a.getClase().equals("Business")) {
            descuento = 0.10;
        } else {
            descuento = 0.05;
        }

        double precioFinal = base - (base * descuento);

        a.setPasajero(pa);
        a.setEstado("Ocupado");
        recaudacionTotal = recaudacionTotal + precioFinal;

        String msg = "Reserva con descuento realizada.\n";
        msg = msg + "Precio base: " + base + "\n";
        msg = msg + "Precio final: " + precioFinal;

        JOptionPane.showMessageDialog(null, msg);
    }

    
    public void consultar() {

        Asiento a = elegirAsiento();
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Asiento no válido.");
            return;
        }

        if (a.getPasajero() == null) {
            JOptionPane.showMessageDialog(null, "No hay pasajero en ese asiento.");
            return;
        }

        String info = "Asiento " + a.getCodigo() + "\n\n";
        info = info + a.getPasajero().getInfo();
        info = info + "Clase: " + a.getClase() + "\n";
        info = info + "Estado: " + a.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

 
    public void resumen() {

        int libres = 0;
        int ocupados = 0;

        for (int f = 0; f < 5; f++) {
            for (int c = 0; c < 4; c++) {
                if (asientos[f][c].getEstado().equals("Libre")) {
                    libres = libres + 1;
                } else {
                    ocupados = ocupados + 1;
                }
            }
        }

        double porcentaje = (ocupados * 100.0) / totalAsientos;

        String msg = "RESUMEN DEL VUELO\n\n";
        msg = msg + "Recaudación total: " + recaudacionTotal + "\n";
        msg = msg + "Asientos ocupados: " + ocupados + "\n";
        msg = msg + "Asientos libres: " + libres + "\n";
        msg = msg + "Porcentaje de ocupación: " + porcentaje + "%\n";

        JOptionPane.showMessageDialog(null, msg);
    }
}
