package testt;
import conjuntistas.estaticas.ABB;
import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

/**
 *
 * @author ulise
 */
public class testABB {
    public static void main(String[] args) {
        ABB arbol = new ABB();
        arbol.insertar(15);
        arbol.insertar(9);
        arbol.insertar(6);
        arbol.insertar(14);
        arbol.insertar(13);
        arbol.insertar(20);
        arbol.insertar(17);
        arbol.insertar(64);
        arbol.insertar(26);
        arbol.insertar(72);
        System.out.println(arbol.mejorCandidato(103).toString());
//         System.out.println(arbol.toString());
//        arbol.eliminarMinimo();
//        System.out.println(arbol.toString());
//        Lista lisss = new Lista();
//        lisss=arbol.listarMayorIgual(5);
//        System.out.println(lisss.toString());
        // System.out.println(arbol.toString());
        //arbol.eliminarElemAnterior(30);
         //System.out.println(arbol.toString());
//         ABB arbol2 = new ABB();
//         arbol2= arbol.clonarParteInvertida(5);
//         System.out.println(arbol2.toString());
        
//        System.out.println(arbol.toString());
//        System.out.println(arbol.minimoElem());
//        System.out.println(arbol.maximoElem());
//       Lista lis = new Lista();
//       //lis = arbol.listar();
//        //System.out.println(lis.toString());
//        //arbol.eliminar(20);
//        //System.out.println(arbol.toString());
//        arbol.eliminarMinimo();
//        System.out.println(arbol.toString());
    }
}
