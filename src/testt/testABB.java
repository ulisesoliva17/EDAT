package testt;
import conjuntistas.estaticas.ABB;

/**
 *
 * @author ulise
 */
public class testABB {
    public static void main(String[] args) {
        ABB arbol = new ABB();
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(20);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(15);
        arbol.insertar(25);
        System.out.println(arbol.toString());
        System.out.println(arbol.minimoElem());
        System.out.println(arbol.maximoElem());
    }
}