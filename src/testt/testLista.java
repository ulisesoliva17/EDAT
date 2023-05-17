package testt;
import lineales.dinamicas.Lista;


/**
 *
 * @author ulise
 */
public class testLista {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertar(7,1);
        lista.insertar(6,2);
        lista.insertar(5,3);
        lista.insertar(4,4);
        lista.insertar(3,5);
        lista.insertar(2,6);
        lista.insertar(1,7);
         lista.insertar(1,8);
        System.out.println(lista.toString());
        System.out.println(lista.obtenerMultiplos(4).toString());

//        System.out.println("En la posicion ingresada se encuentra el elemento: "+testLista.recuperar(1));
//        System.out.println("El elemento que usted busca esta en la pos: "+testLista.localizar(9));
        //System.out.println("La lista con los multiplos del numero dado es: "+testLista.obtenerMultiplo(2, testLista).toString());
       // testLista.eliminarApariciones(3);
        //System.out.println(testLista.toString());
       // System.out.println(testLista.obtenerMultiplos(2).toString());
    }
    }
