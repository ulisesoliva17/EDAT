package testt;
import lineales.dinamicas.Lista;


/**
 *
 * @author ulise
 */
public class testLista {
    public static void main(String[] args) {
        Lista testLista = new Lista();
        System.out.println(testLista.insertar(9, 1));
        System.out.println(testLista.insertar(4, 2));
        System.out.println(testLista.insertar(5, 3));
        System.out.println(testLista.insertar(34, 4));
         System.out.println(testLista.insertar(34, 5));
          System.out.println(testLista.insertar(34, 6));
           System.out.println(testLista.insertar(34, 7));
        System.out.println(testLista.toString());
        System.out.println("En la posicion ingresada se encuentra el elemento: "+testLista.recuperar(1));
        System.out.println("El elemento que usted busca esta en la pos: "+testLista.localizar(9));
    }
    }
