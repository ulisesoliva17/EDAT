package conjuntistas.estaticas;
import jerarquicas.NodoArbol;

/**
 *
 * @author ulise
 */
public class ABB {
    private NodoArbol raiz;
    
    
    public ABB(){
    raiz=null;
    }
    
    //Todos los hijos izquierdo son menores que la raiz y todos los hijos derechos son mayores que la raiz
    public boolean pertenece(Comparable elem){
        return perteneceAux(elem,raiz);
    }
    private boolean perteneceAux(Comparable elem, NodoArbol nodo){
        boolean rta=false;
        if(nodo!=null && !rta){
            if(elem.compareTo(nodo.getElem())==0){
                rta=true;
            }else{
                    //sI el ELEM es menor, busca el subarbol Izquierdo
                    if(elem.compareTo(nodo.getElem())<0)
                    rta=perteneceAux(elem,nodo.getIzquierdo());
                    
                    
                    //sI el ELEM es mayor, busca el subarbol derecho
                    if(elem.compareTo(nodo.getElem())>0)
                    rta=perteneceAux(elem,nodo.getDerecho());     
            }
        }
        return rta;
    }
    //----------------------------------------------------------------------------------------------------------------------------------
    public boolean insertar (Comparable elem){
        boolean rta=true;
        if(raiz==null){
            raiz=new NodoArbol(elem,null,null);
        }else{
            rta=insertarAux(elem,raiz);
        }
        return rta;
    }
    
   //---------------------------------------------------------------------------------------------------------------------------------- 
    private boolean insertarAux(Comparable elem, NodoArbol nodo){
        boolean rta=true;
        
            if(elem.compareTo(nodo.getElem())==0){
                rta=false;
            }else{
                    //sI el ELEM es menor, busca el subarbol Izquierdo
                    if(elem.compareTo(nodo.getElem())<0){
                        if(nodo.getIzquierdo()!=null){
                                   rta=insertarAux(elem,nodo.getIzquierdo());
                        }else{
                            nodo.setIzquierdo(new NodoArbol(elem,null,null));
                        }
                  }
                    if(elem.compareTo(nodo.getElem())>0){
                        if(nodo.getDerecho()!=null){
                                   rta=insertarAux(elem,nodo.getDerecho());
                        }else{
                            nodo.setDerecho(new NodoArbol(elem,null,null));
                        }
                        
                    }
            }  
        return rta;
    }
 //-------------------------------------------------------------------------------------------------------------------------------------
       public String toString() {
        String mensaje=" ";
        if(raiz==null){    
            mensaje="Arbol Vacio";
        }else{
            mensaje= toStringAux(raiz);
        }
        return mensaje;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    private String toStringAux(NodoArbol nodo) {
        String mensaje = "";
        if (nodo != null) {
            mensaje =  " \n "+" Nodo:  "+ nodo.getElem() +mensaje + " \n " ;
            if (nodo.getIzquierdo() != null) {
                mensaje = mensaje + (" HI: "+nodo.getIzquierdo().getElem());
            } else {
                mensaje = mensaje +" HI: - " ;
            }
            if (nodo.getDerecho() != null) {
                mensaje = mensaje + (" HD: "+nodo.getDerecho().getElem());
            } else {
                mensaje = mensaje+" HD: - ";
            }
        }
        if(nodo.getIzquierdo()!=null){
            mensaje= mensaje+ toStringAux(nodo.getIzquierdo());
        }
        if(nodo.getDerecho()!=null){
            mensaje= mensaje+ toStringAux(nodo.getDerecho());
        }
        
        return mensaje;
    }
     //-----------------------------------------------------------------------------------------------------------------------------------------------
    public Comparable minimoElem(){
        Comparable min;
        if(raiz==null){
            min=null;
        }else{
            min = minimoElemAux(raiz);
        }
        return min;
    }
      //-----------------------------------------------------------------------------------------------------------------------------------------------
    private Comparable minimoElemAux(NodoArbol nodo){
        Comparable min=null;
        if(nodo.getIzquierdo()!=null){
            min=minimoElemAux(nodo.getIzquierdo());
        }else{
            min=(Comparable) nodo.getElem();
        }
        return min;
    }
         //-----------------------------------------------------------------------------------------------------------------------------------------------
    public Comparable maximoElem(){
        Comparable max;
        if(raiz==null){
            max=null;
        }else{
            max = maximoElemAux(raiz);
        }
        return max;
    }
      //-----------------------------------------------------------------------------------------------------------------------------------------------
    private Comparable maximoElemAux(NodoArbol nodo){
        Comparable max=null;
        if(nodo.getDerecho()!=null){
            max=maximoElemAux(nodo.getDerecho());
        }else{
            max=(Comparable) nodo.getElem();
        }
        return max;
    }
      //-----------------------------------------------------------------------------------------------------------------------------------------------
    public boolean vacio(){
        return raiz==null;
    }
     //-----------------------------------------------------------------------------------------------------------------------------------------------
    
}
