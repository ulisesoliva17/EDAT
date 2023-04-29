/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testt;

import lineales.estaticas.Cola;


public class tesColaE {

    public static void main(String[] args) {

        Cola unaCola = new Cola();
        for (int i = 1; i < 8; i++) {
            unaCola.poner(i);
        }

        System.out.println("cola original: " + unaCola.toString());
        System.out.println("frnte: " + unaCola.obtenerInicio());
        System.out.println("pudo sacar? " + unaCola.sacar());
        System.out.println("nuevo frente: " + unaCola.obtenerInicio());
        System.out.println("cadena sin el frente: " + unaCola.toString());
        System.out.println("esta vacia?: " + unaCola.esVacia());
        System.out.println("Cola original:" + unaCola.toString());
        System.out.println("Cola clonada: " + (unaCola.clone()).toString());
        System.out.println(unaCola.esVacia());
        System.out.println(unaCola.clone().esVacia());
    }
}
