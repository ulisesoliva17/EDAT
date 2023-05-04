
package testt;

import lineales.dinamicas.Cola;


 // @author ulise
public class testColaD {


    public static void main(String[] args) {
        // 
        Cola colaaa= new Cola();
//        colaaa.poner("{");
//        colaaa.poner("5");
//        colaaa.poner("+");
//        colaaa.poner("[");
//        colaaa.poner("8");
//        colaaa.poner("*");
//         colaaa.poner("9");
//         colaaa.poner("-");
//        colaaa.poner("(");
//        colaaa.poner("4");
//        colaaa.poner("/");
//        colaaa.poner("2");
//        colaaa.poner(")");
//        colaaa.poner("+");
//        colaaa.poner("7");
//        colaaa.poner("]");
//        colaaa.poner("-");
//        colaaa.poner("1");
//        colaaa.poner("}");
        //colaaa.poner("{");
        colaaa.poner("{");
        colaaa.poner("[");
        colaaa.poner("(");
        colaaa.poner(")");
        colaaa.poner("]");
        colaaa.poner("}");
        System.out.println(colaaa.toString());
        System.out.println(colaaa.verificarBalanceo(colaaa));
//        colaaa.sacar();
//        System.out.println(colaaa.toString());
//        Cola clon= new Cola();
//        clon= colaaa.clone();
//        System.out.println(clon.toString());
//        colaaa.mostrarCola();
//        colaaa.sacar();
//        colaaa.mostrarCola();
//        System.out.println(colaaa.obtenerInicio());
//        Cola clon = new Cola();
//        colaaa.clone().mostrarCola();
        
    }

}
