
package testt;

import lineales.dinamicas.Cola;


 // @author ulise
public class testColaD {


    public static void main(String[] args) {
        // 
        Cola colaaa= new Cola();
        colaaa.poner(4);
        colaaa.poner(3);
        colaaa.poner(0);
        colaaa.poner(9);
        System.out.println(colaaa.toString());
        colaaa.sacar();
        System.out.println(colaaa.toString());
        Cola clon= new Cola();
        clon= colaaa.clone();
        System.out.println(clon.toString());
//        colaaa.mostrarCola();
//        colaaa.sacar();
//        colaaa.mostrarCola();
//        System.out.println(colaaa.obtenerInicio());
//        Cola clon = new Cola();
//        colaaa.clone().mostrarCola();
        
    }

}
