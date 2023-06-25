package testt;
import conjuntistas.estaticas.ABB;
import lineales.dinamicas.Lista;

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
        arbol.insertar(7);
        arbol.insertar(15);
        arbol.insertar(25);
         System.out.println(arbol.toString());
        arbol.eliminarMinimo();
        System.out.println(arbol.toString());
        Lista lisss = new Lista();
        lisss=arbol.listarMayorIgual(5);
        System.out.println(lisss.toString());
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
