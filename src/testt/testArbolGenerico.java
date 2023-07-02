package testt;
import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author ulise
 */
public class testArbolGenerico {
    public static void main(String[] args) {
        ArbolGen arbol = new ArbolGen();
        arbol.insertar('A',null);
        arbol.insertar('H','A');
        arbol.insertar('B','A');
        arbol.insertar('Z','A');
        arbol.insertar('D','H');
        arbol.insertar('Q','H');
         arbol.insertar('T','H');
        arbol.insertar('F','Z');
        arbol.insertar('C','Z');
        arbol.insertar('J','Z');
        System.out.println(arbol.toString());
        System.out.println("--------------------------------------------");
        arbol.insertarPos('H', 'N', 3);
        System.out.println(arbol.toString());
//         arbol.insertar(1, null);
//         arbol.insertar(2, 1);
//         arbol.insertar(3, 1);
//         arbol.insertar(4, 1);
//         arbol.insertar(5, 2);
//         arbol.insertar(6, 2);
//         arbol.insertar(7, 4);
//         arbol.insertar(8, 4);
//         arbol.insertar(9, 4);
//         arbol.insertar(8, 4);
//         arbol.insertar(10, 5);
//         arbol.insertar(12, 5);
//         System.out.println(arbol.esSobrino(2, 7));
        
        
    }
    
}
