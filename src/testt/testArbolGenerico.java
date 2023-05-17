package testt;
import jerarquicas.ArbolGen;

/**
 *
 * @author ulise
 */
public class testArbolGenerico {
    public static void main(String[] args) {
        ArbolGen arbol = new ArbolGen();
        arbol.insertar(1,null);
        arbol.insertar(2,1);
        arbol.insertar(3,1);
        arbol.insertar(4,1);
        arbol.insertar(5,2);
        arbol.insertar(6,2);
        arbol.insertar(7,2);
        arbol.insertar(8,3);
        arbol.insertar(9,3);
        arbol.insertar(10,4);
        arbol.insertar(11,4);
        arbol.insertar(12,4);
        arbol.insertar(13,4);
        System.out.println(arbol.toString());
//        System.out.println(arbol.listarPreOrden());
//        System.out.println(arbol.pertenece(13));
        ArbolGen arbol2 = new ArbolGen();
        arbol2= arbol.clone();
        System.out.println(arbol2.toString());
    }
    
}
