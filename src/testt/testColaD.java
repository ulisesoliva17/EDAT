
package testt;

import lineales.dinamicas.Cola;


 // @author ulise
public class testColaD {


    public static void main(String[] args) {
        Cola colaaa= new Cola();
        colaaa.poner("{");
        colaaa.poner("[");
        colaaa.poner("(");
        colaaa.poner(")");
        colaaa.poner("]");
        colaaa.poner("}");
        System.out.println(colaaa.toString());
        System.out.println(colaaa.verificarBalanceo(colaaa));
    }

}
