/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2;

import javax.swing.JOptionPane;

/**
 *
 * @author sophi
 */
public class Examen2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();
        int opcion = 0;

        do {
            String menu = "SISTEMA DE RESERVAS\n\n"
                    + "1. Ver mapa del avión\n"
                    + "2. Reservar asiento\n"
                    + "3. Reservar con descuento\n"
                    + "4. Consultar pasajero por asiento\n"
                    + "5. Ver resumen del vuelo\n"
                    + "6. Salir\n\n"
                    + "Digite una opción:";

            String texto = JOptionPane.showInputDialog(menu);

            if (texto == null) {
                opcion = 6;
            } else if (texto.length() == 0) {
                opcion = 0;
            } else {
                opcion = Integer.parseInt(texto); 
            }

            if (opcion == 1) {
                sistema.verMapa();
            } else if (opcion == 2) {
                sistema.reservar();
            } else if (opcion == 3) {
                sistema.reservarDescuento();
            } else if (opcion == 4) {
                sistema.consultar();
            } else if (opcion == 5) {
                sistema.resumen();
            } else if (opcion == 6) {
                JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (opcion != 6);
    }
}
