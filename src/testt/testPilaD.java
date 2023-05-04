package testt;

import java.util.Scanner;
import javax.swing.JOptionPane;
import lineales.dinamicas.Pila;

public class testPilaD {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                Pila pila = new Pila();
                pila.apilar(5);
                pila.apilar(3);
                pila.apilar(6);
                pila.apilar(0);
                pila.apilar(9);
                pila.apilar(1);
                System.out.println(pila.toString());
                pila.desapilar();
                System.out.println(pila.toString());
                System.out.println(pila.clonar().toString());
    }
}
