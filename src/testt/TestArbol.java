
package testt;

 // @author ulise

import jerarquicas.ArbolBin;



public class TestArbol {


    public static void main(String[] args) {
         ArbolBin arbol = new ArbolBin();
        //que el nodo padre este creado antes de hacer los hijos!!!!
        arbol.insertar(1, null, 'i');
        arbol.insertar(2, 1, 'i');
        arbol.insertar(4, 2, 'i');
        arbol.insertar(5, 2, 'd');
        arbol.insertar(6, 4, 'd');
        arbol.insertar(3, 1, 'd');
        arbol.insertar(7, 3, 'i');
        arbol.insertar(8, 3, 'd');
        arbol.insertar(9, 8, 'i');
        System.out.println(arbol.toString());
       System.out.println(arbol.obtenerPadre(9));
        System.out.println(arbol.clone().toString());
    }

}
