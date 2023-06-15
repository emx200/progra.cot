
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Emanuel
 */

import java.util.Scanner;

public class ejercicioA {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int num1;
        int num2;         
        
        System.out.println("ingrese un numero" );
        
        num1 = sc.nextInt();
        
        System.out.println("ingrese un numero" );
        
        num2 = sc.nextInt();
        
        if (num1 == num2){
            
           System.out.println("los 2 numeros son iguales ");  
        }
        else if (num1 > num2){
            System.out.println(" el primer numero es mayor al segundo");
        }
        else {
            System.out.println(" el segundo numero es mayor");
        }
        
        int sum=num1+num2;
        
        System.out.println("La suma de los dos numeros es de "+sum);
    }
    
}

