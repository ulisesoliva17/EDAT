package testt;

import java.util.Scanner;
import javax.swing.JOptionPane;
import lineales.dinamicas.Pila;

public class testPilaD {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Object nodo=0;
        boolean nuevoElementoBoolean=true;
        Object elemento;
         Pila Pila = new Pila();
         Pila pila2= new Pila();
        do{
            nodo = JOptionPane.showInputDialog(null,"Por favor ingrese un valor para cargar a la pila");
            System.out.println("Ingrese un valor");
            Pila.apilar(nodo);
            System.out.println("Desea cargar un nuevo valor para la pila?");
            nuevoElementoBoolean = sc.nextBoolean();
            if(nuevoElementoBoolean){
                nodo = JOptionPane.showInputDialog(null,"Por favor ingrese otro un valor para cargar a la pila");
                Pila.apilar(nodo);
            }else{
                nuevoElementoBoolean =false;
            }
        }while(nuevoElementoBoolean);
        Pila.mostrarPila();
        pila2= Pila.clonar();
        pila2.mostrarPila();
       // pila.desapilar();
        
        //pila.vaciarTotalPila();
       // pila.mostrarPila();
    }
}
