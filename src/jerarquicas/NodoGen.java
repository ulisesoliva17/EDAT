/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas;

/**
 *
 * @author ulise
 */
public class NodoGen {
      private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    
    public NodoGen(Object tipoElem, NodoGen izq,NodoGen Herderecho){
        elem=tipoElem;
        hijoIzquierdo=izq;
        hermanoDerecho=Herderecho;
    }
    public Object getElem(){
        return elem;
    }
    
    public NodoGen getHijoIzquierdo(){
        return hijoIzquierdo;
    }
    public NodoGen getHermanoDerecho(){
        return hermanoDerecho;
    }
    public void setElemento(Object elemento){
        elem=elemento;
    }
    public void setHijoIzquierdo(NodoGen izq){
        hijoIzquierdo=izq;
    }
      public void setHermanoDerecho(NodoGen der){
        hermanoDerecho = der;
    }
}
