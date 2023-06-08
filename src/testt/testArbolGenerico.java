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
        arbol.insertar(1,null);
        arbol.insertar(2,1);
        arbol.insertar(3,1);
        arbol.insertar(6,2);
        arbol.insertar(7,2);
        arbol.insertar(9,6);
        arbol.insertar(10,9);
        System.out.println("");
            System.out.println("\n");
         //Entre Niveles inOrden
         Lista lista4=new Lista();
         lista4=arbol.listarEntreNivelesInOrden(1, 3);
         System.out.println("Entre niveles inOrden");
         System.out.println(lista4.toString());
         System.out.println("\n");
         //Entre Niveles pre orden
         Lista lista5=new Lista();
         lista5=arbol.listarEntreNivelesPreOrden(2,4);
         System.out.println("Entre niveles PreOrden");
         System.out.println(lista5.toString());
         System.out.println("\n");
         //Entre Niveles pos Orden
         Lista lista6=new Lista();
         lista6=arbol.listarEntreNivelesPosOrden(1,4);
         System.out.println("Entre niveles PosOrden");
         System.out.println(lista6.toString());
         System.out.println("\n");
//         //hasta nivel posOrden
//         Lista lista7=new Lista();
//         lista7=arbol.listarHastaNivelPosOrden(2);
//         System.out.println("Hasta Nivel PosOrden");
//         System.out.println(lista7.toString());
//         System.out.println("\n");
//         //hasta nivel posOrden
//         Lista lista8=new Lista();
//         lista8=arbol.listarHastaNivelinOrden(3);
//         System.out.println("Hasta Nivel InOrden");
//         System.out.println(lista8.toString());
        //------------------------------------
//        Lista lista1=new Lista();
//        lista1.insertar(1, 1);
//        lista1.insertar(4, 2);
//        lista1.insertar(10, 3);
//        lista1.insertar(78, 10);
//        System.out.println(arbol.verificarCamino(lista1));
        
//        //------------------------------------
//        Lista lista2=new Lista();
//        lista1.insertar(19, 1);
//        lista1.insertar(12, 2);
//        lista1.insertar(11, 3);
//        lista1.insertar(10, 4);
//        lista1.insertar(9, 5);
//        lista1.insertar(8, 6);
//        lista1.insertar(7, 7);
//        lista1.insertar(6, 8);
//        lista1.insertar(5, 9);
//        //------------------------------------
//        
//         Lista lista3=new Lista();
//        lista1.insertar(19, 1);
//        lista1.insertar(12, 2);
//        //------------------------------------
//        if(arbol.sonFrontera(lista1)==true){
//            //Debe devolver que son hojas
//            System.out.println("La lista ingresada por parametro son Hojas");
//        }else{
//            System.out.println("La lista ingresada por parametro NO son Hojas");
//        }
//        if(arbol.sonFrontera(lista2)==true){
//            //Debe devolver que NO son hojas
//            System.out.println("La lista ingresada por parametro son Hojas");
//        }else{
//            System.out.println("La lista ingresada por parametro NO son Hojas");
//        }
//        if(arbol.sonFrontera(lista3)==true){
//             //Debe devolver que NO son hojas
//            System.out.println("La lista ingresada por parametro son Hojas");
//        }else{
//            System.out.println("La lista ingresada por parametro NO son Hojas");
//        }
//        
//        //=================
//        ArbolGen arbol2 = new ArbolGen();
//        arbol2.insertar(1,null);
//        arbol2.insertar(2,1);
//        arbol2.insertar(3,1);
//        arbol2.insertar(4,1);
//        arbol2.insertar(5,2);
//        arbol2.insertar(6,2);
//        arbol2.insertar(7,2);
//        arbol2.insertar(8,3);
//        arbol2.insertar(9,3);
//        arbol2.insertar(10,4);
//        arbol2.insertar(11,4);
//        arbol2.insertar(12,4);
//        arbol2.insertar(13,4);
//        if(arbol.equals(arbol2)==true){
//            //Debe devolver que son iguales
//            System.out.println("Los arboles son iguales"); 
//        }else{
//            System.out.println("Los arboles NO son iguales");
//        }
//        
//        ArbolGen arbol3 = new ArbolGen();
//        arbol2.insertar(1,null);
//        arbol2.insertar(2,1);
//        arbol2.insertar(3,1);
//        if(arbol.equals(arbol3)==true){
//            //Debe devolver que no son iguales
//            System.out.println("Los arboles son iguales"); 
//        }else{
//            System.out.println("Los arboles NO son iguales");
//        }
        
    }
    
}
