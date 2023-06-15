/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    import java.util.Scanner;
/**
 *
 * @author Emanuel
 */
public class chatgpt {

    public static void main(String[] args) {
        String[][] tablaNombres = new String[5][4];
        
        // Pedir al usuario que ingrese nombres para llenar la tabla
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Ingrese un nombre para la fila " + (i+1) + ", columna " + (j+1) + ": ");
                tablaNombres[i][j] = sc.next();
            }
        }
        
        // Imprimir la tabla en la consola
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tablaNombres[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


