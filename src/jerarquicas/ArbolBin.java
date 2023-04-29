
package jerarquicas;

public class ArbolBin {
 
    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = true;
        if (this.raiz == null) { //para cuando esta vacio asi hace que eso sea la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre); //si el arbol no esta vacio(raiz no nula), busca el nodo padre
            if (nPadre != null) {  //si el nodo padre existe y el lugar no esta ocupado lo pone, si no, da error
                if ((lugar == 'I' || lugar == 'i') && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else if ((lugar == 'D' || lugar == 'd') && nPadre.getDerecho() == null) {
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }
    
    public String toString() {
        String mensaje=" ";
        if(raiz==null){    
            mensaje="Arbol Vacio";
        }else{
            mensaje= toStringAux(raiz);
        }
        return mensaje;
    }

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

    //para obtener el nodo segun un elemento q busques
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        // METODO PRIVADO que busca un elemento y devuelve el nodo que lo contiene. Si no se encuentra el buscado devueve null
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) { //si el elemento buscado es n, lo devuelve
                resultado = n;
            } else { //si no era, busca primero por el izquierdo
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                if (resultado == null) { //si tampoco era, finalmente busca por el derecho
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }
    
    
    public Object obtenerPadre(Object padre){
        Object resultado=null;
        if(raiz==null){
            resultado=null;
        }else{
           resultado = obtenerPadre(padre, raiz);
        }
        return resultado;
    }
    
    private Object obtenerPadre(Object elem, NodoArbol nodo ){
        Object padre=null;
       if(nodo!=null){
                    if((nodo.getIzquierdo()!=null) && (elem.equals(nodo.getIzquierdo().getElem()))){
                        //System.out.println(nodo.getElem());
                        padre=nodo.getElem();
                    }
                    if((nodo.getDerecho()!=null) && (elem.equals(nodo.getDerecho().getElem()))){
                        padre=nodo.getElem();
                    }
                    
               if(padre==null)
               padre= obtenerPadre(elem, nodo.getIzquierdo());
                
                if(padre==null )
               padre= obtenerPadre(elem, nodo.getDerecho());
                
        }
       return padre;  
    
    }
    
    
        private void auxClone(NodoArbol nodo1,NodoArbol nodo2) {
        
        if (nodo1 != null && nodo2 != null) {
            
            if (nodo1.getIzquierdo() != null) {
               nodo2.setIzquierdo(new NodoArbol(nodo1.getIzquierdo().getElem(),null,null));
              }
            
             if (nodo1.getDerecho()!= null) {
               nodo2.setDerecho(new NodoArbol(nodo1.getDerecho().getElem(),null,null));
              }
             
             auxClone(nodo1.getIzquierdo(),nodo2.getIzquierdo());
             auxClone(nodo1.getDerecho(),nodo2.getDerecho());
              
            }
        }
        
        
        public ArbolBin clone(){
        ArbolBin clon = new ArbolBin();
        if(raiz != null){
            clon.raiz = new NodoArbol(raiz.getElem(), null, null);
            auxClone(raiz, clon.raiz);
        }
        
        return clon;
    }
    
    }
