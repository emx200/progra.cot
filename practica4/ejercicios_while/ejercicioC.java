  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_while;

/**
 *
 * @author Emanuel
 */

import java.util.Scanner;

public class ejercicioC {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in); 
        
        int num;
                
        int suma = 0;
                
        int numi = 1;
        
        double porcen;
                
        System.out.println("escriba un numero");
        num = sc.nextInt();
        
        suma = num;
        
        while (num!=0){
        
        System.out.println("escriba un numero");
        num = sc.nextInt();
        
        suma+=num;
        
        numi++;
        
    }
    
        porcen = suma/numi;
        
        System.out.println("la suma de todos los numeros es de " + suma);
        
        System.out.println("el total de los numeros ingresados es de " + numi);
        
        System.out.println("el porcentaje de los numeros ingresados es de " + porcen);
        
}
    
}