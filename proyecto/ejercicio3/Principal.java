/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author ema
 */
public class Principal {

    public static void main(String[] args) {
        int menu = 0;
        int edad = 0;
        Pilas pila = new Pilas();

        do {
            try {
                menu = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Opciones de edades\n\n"
                                + "1. ensenar pila\n"
                                + "2. digitar una nueva edad\n"
                                + "3. desapilar una edad\n"
                                + "4. salir\n\n"));

                
                
                
                switch (menu) {
                    case 1:
                        pila.mostrarPila();
                        break;

                        
                        
                    case 2:
                        edad = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "digite la edad para poner en la pila"));
                        pila.push(edad);
                        break;

                        
                        
                        
                        
                        
                    case 3:
                        if (!pila.pilaVacia()) {
                            JOptionPane.showMessageDialog(null, "se desapiló la edad: " + pila.pop());
                        } else {
                            JOptionPane.showMessageDialog(null, " pila vacía");
                        }
                        break;

                        
                        
                    case 4:
                        menu = 4;
                        break;

                        
                        
                        
                        
                    default:
                        JOptionPane.showMessageDialog(null, "esta opcion no está disponible");
                }
            } catch (NumberFormatException e) {
 
         
         
         
         
            }
        } while (menu != 4);
    }
}


