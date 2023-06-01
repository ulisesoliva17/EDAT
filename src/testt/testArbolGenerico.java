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
        //------------------------------------
        Lista lista1=new Lista();
        lista1.insertar(10, 1);
        lista1.insertar(12, 2);
        lista1.insertar(11, 3);
        lista1.insertar(13, 4);
        lista1.insertar(9, 5);
        lista1.insertar(8, 6);
        lista1.insertar(7, 7);
        lista1.insertar(6, 8);
        lista1.insertar(5, 9);
        //------------------------------------
        Lista lista2=new Lista();
        lista1.insertar(19, 1);
        lista1.insertar(12, 2);
        lista1.insertar(11, 3);
        lista1.insertar(10, 4);
        lista1.insertar(9, 5);
        lista1.insertar(8, 6);
        lista1.insertar(7, 7);
        lista1.insertar(6, 8);
        lista1.insertar(5, 9);
        //------------------------------------
        
         Lista lista3=new Lista();
        lista1.insertar(19, 1);
        lista1.insertar(12, 2);
        //------------------------------------
        if(arbol.sonFrontera(lista1)==true){
            //Debe devolver que son hojas
            System.out.println("La lista ingresada por parametro son Hojas");
        }else{
            System.out.println("La lista ingresada por parametro NO son Hojas");
        }
        if(arbol.sonFrontera(lista2)==true){
            //Debe devolver que NO son hojas
            System.out.println("La lista ingresada por parametro son Hojas");
        }else{
            System.out.println("La lista ingresada por parametro NO son Hojas");
        }
        if(arbol.sonFrontera(lista3)==true){
             //Debe devolver que NO son hojas
            System.out.println("La lista ingresada por parametro son Hojas");
        }else{
            System.out.println("La lista ingresada por parametro NO son Hojas");
        }
        
        //=================
        ArbolGen arbol2 = new ArbolGen();
        arbol2.insertar(1,null);
        arbol2.insertar(2,1);
        arbol2.insertar(3,1);
        arbol2.insertar(4,1);
        arbol2.insertar(5,2);
        arbol2.insertar(6,2);
        arbol2.insertar(7,2);
        arbol2.insertar(8,3);
        arbol2.insertar(9,3);
        arbol2.insertar(10,4);
        arbol2.insertar(11,4);
        arbol2.insertar(12,4);
        arbol2.insertar(13,4);
        if(arbol.equals(arbol2)==true){
            //Debe devolver que son iguales
            System.out.println("Los arboles son iguales"); 
        }else{
            System.out.println("Los arboles NO son iguales");
        }
        
        ArbolGen arbol3 = new ArbolGen();
        arbol2.insertar(1,null);
        arbol2.insertar(2,1);
        arbol2.insertar(3,1);
        if(arbol.equals(arbol3)==true){
            //Debe devolver que no son iguales
            System.out.println("Los arboles son iguales"); 
        }else{
            System.out.println("Los arboles NO son iguales");
        }
        
    }
    
}
