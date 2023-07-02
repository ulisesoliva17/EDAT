
package testt;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
        


 // @author ulise
public class testColaD {


    public static void main(String[] args) {
        Cola colaaa= new Cola();
        colaaa.poner("A");
        colaaa.poner("B");
        colaaa.poner("C");
        colaaa.poner("#");
        colaaa.poner("D");
        colaaa.poner("E");
        colaaa.poner("F");
        colaaa.poner("#");
        colaaa.poner("J");
        System.out.println(colaaa.toString());
        Cola cola2= genera(colaaa);
        System.out.println(cola2.toString());
    }
        private static void ponerEnColaNueva(Pila temp1, Cola temp2, Cola res){

        while(!temp1.esVacia()){
            res.poner(temp1.obtenerTope());
            temp1.desapilar();
        }
        while(!temp2.esVacia()){
            res.poner(temp2.obtenerInicio());
            temp2.sacar();
        }
        res.poner("#");
    }
        
    public static Cola genera(Cola c1){
        Cola res=new Cola();
        Pila temp1=new Pila();
        Cola temp2=new Cola();
        while(!c1.esVacia()){
            Object elemento= c1.obtenerInicio();
            if(!elemento.equals("#")){
                res.poner(elemento);//aprovecha para ir poniendo los elementos
                temp1.apilar(elemento);
                temp2.poner(elemento);
            }else{
                ponerEnColaNueva(temp1,temp2, res);
            }
            c1.sacar();
        }
        if(!temp1.esVacia()){
            ponerEnColaNueva(temp1,temp2,res);
        }
        return res;
    }
    

}
