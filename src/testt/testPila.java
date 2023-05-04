package testt;

import java.util.Scanner;
import lineales.estaticas.Pila;

public class testPila {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pila pila = new Pila(3);
        int i=0;
        pila.apilar(5);
        pila.apilar(3);
        pila.apilar(6);
        pila.apilar(2);
        pila.apilar(3);
        pila.apilar(4);
        pila.apilar(5);
        pila.apilar(9);
        pila.apilar(78);
        System.out.println(pila.toString());
        System.out.println();
    }
}

