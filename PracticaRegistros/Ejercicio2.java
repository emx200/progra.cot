
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Emanuel
 */
public class Ejercicio2 {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
      String Titulo;
    String artista;
    int duracion;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio2 MP3= new Ejercicio2();
        
       
        System.out.println("escribe el artista de la cancion ");
        MP3.artista=sc.nextLine();
        
        System.out.println("escribe el titulo de la cancion ");
        MP3.Titulo=sc.nextLine();
        
        System.out.println("escriba la duracion en segundos de la cancion ");
        MP3.duracion=sc.nextInt();
        
        System.out.println("Artista: "+ MP3.artista+
                "\nTitulo: "+MP3.Titulo+
                "\nDuracion: "+MP3.duracion+" segundos");
    }
    
}

