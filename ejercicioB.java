/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Emanuel
 */

import java.util.Scanner;


public class ejercicioB {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int num1;
        
        System.out.println("Escriba un numero");
        num1 = sc.nextInt();
        
    
      if (num1 %2 == 0){ 
          System.out.println("El numero es par");
      
    }
      else{
          System.out.println("El numero es impar");
          
      }
      
      num1 *=2;
        System.out.println("el doble del numero es " + num1);
      
        
  }
    
}
