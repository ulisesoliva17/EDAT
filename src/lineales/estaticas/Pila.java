package lineales.estaticas;
import java.util.Arrays;

//Pila Estatica
public class Pila {
 //la cima de la pila
private int tope;
//tamanio es la cantidad de elementos que tendra la pila
private final int tamanio=10;
//Pila como array
private Object datos[];

public Pila(int maxNum){
    //Tope es -1 ya que no hay nada en la pila todavia
    tope=-1;
    //se crea la pila de tipo Objeto y tiene la dimension que le dio el usuario
    datos= new Object [tamanio];
}
public Pila(){
    //Tope es -1 ya que no hay nada en la pila todavia
    tope=-1;
    //se crea la pila de tipo Objeto y tiene la dimension que le dio el usuario
    datos= new Object [tamanio];
}

public boolean esVacia(){
    return tope==-1;
}

public boolean llena(){
    return tope == tamanio-1;
}

public boolean apilar(Object parametro){
    if(!llena()){
        tope++;
        datos[tope]=parametro;
        return true;
    }
    return false;
}

public boolean desapilar(){
        boolean exito;
        if(esVacia()){
            //Error: pila vacia
            exito=false;
        }
        else{
           datos[tope]=null;
            tope--;
            exito=true;
        }
        return exito;
    }

public Object obtenerTope(){
    Object parametro;
    if(!esVacia()){
        parametro = datos[tope];
    }else{
        parametro = null;
    }
    return parametro;
}

 public String toString(){
        String cadena = Arrays.toString(datos);
        return cadena;
    }
 public void vaciar(){
        for (int i = 0; i < this.datos.length; i++) {
            this.datos[i]=null;
        }
    }
 public Pila clone(){
        Pila pilaClonada = new Pila();
        for (int i=0; i<=this.tope;i++){
            pilaClonada.datos[i]= this.datos[i];
        }
        pilaClonada.tope = this.tope;

        //System.out.println("Pila clonada: "+pilaClonada.toString());
        return pilaClonada;
 }
}
