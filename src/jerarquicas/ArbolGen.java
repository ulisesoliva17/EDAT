package jerarquicas;
import lineales.dinamicas.Lista;

/**
 *
 * @author ulise
 */
public class ArbolGen {
    private NodoGen raiz;
    public ArbolGen(){
        raiz=null;
    }
      //-----------------------------------------------------------------------------------------------------------------------------
    public boolean insertar(Object elemNuevo, Object elemPadre) {
        // METODO QUE BUSCA UN ELEMENTO PADRE Y AGREGA UN elemNuevo COMO HIJO
        boolean exito = false;
        NodoGen encontrado, nuevo;
        if (raiz==null) {
            this.raiz = new NodoGen(elemNuevo, null, null); // SI EL ARBOL ESTA VACIO LO INGRESA EN LA RAIZ
            exito = true;
        } else {
            encontrado = buscarNodo(this.raiz, elemPadre); // SI EL ARBOL TIENE ALGUN ELEMENTO, BUSCA EL elemPadre
            if (encontrado != null) { // SI ENCUENTRA EL elemPadre
                if (encontrado.getHijoIzquierdo() != null) { // Y TIENE HIJOS
                    nuevo = new NodoGen(elemNuevo, null, encontrado.getHijoIzquierdo());
                    encontrado.setHijoIzquierdo(nuevo); // INSERTA EL elemNueo como primer hijo del elemPadre
                    exito = true;
                } else {
                    encontrado.setHijoIzquierdo(new NodoGen(elemNuevo, null, null));
                    exito = true;
                }
            }
        }
        return exito;
    }
  //-----------------------------------------------------------------------------------------------------------------------------
    private NodoGen buscarNodo(NodoGen nodo, Object buscado) {
        // METODO QUE BUSCA UN DETERMINADO ELEMENTO EN EL ARBOL GENERICO
        NodoGen encontrado = null;
        if (nodo != null) {
            if (nodo.getElem().equals(buscado)) {
                // SI EL BUSCADO ES nodo, LO DEVUELVE
                encontrado = nodo;
            } else {
                // NO ES EL BUSCADO: BUSCA PRIMERO EL HERMANO DERECHO
                encontrado = buscarNodo(nodo.getHermanoDerecho(), buscado);
                // SI NO LO ENCUENTRA EN EL HERMANO DERECHO, BUSCA EN HIJO IZQUIERDO
                if (encontrado == null) {
                    encontrado = buscarNodo(nodo.getHijoIzquierdo(), buscado);
                }

            }

        }
        return encontrado;
    }
   //-----------------------------------------------------------------------------------------------------------------------------
    public Lista listarInOrden(){
        Lista salida= new Lista();
        listarInordenAux(raiz,salida);
        return salida;
    }
    private void listarInordenAux(NodoGen n, Lista ls){
        if(n!=null){
            //Llamado recursivo con primer hijo de n
            if(n.getHijoIzquierdo()!=null){
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }
            //Visita del nodo n
            ls.insertar(n.getElem(), ls.longitud()+1);
            
            //Llamados recursivos con los otros hijos de n 
            if(n.getHijoIzquierdo()!=null){
                NodoGen hijo= n.getHijoIzquierdo().getHermanoDerecho();
                while(hijo!=null){
                    listarInordenAux(hijo, ls);
                    hijo= hijo.getHermanoDerecho();
                }
            }
        }
    }
     //-----------------------------------------------------------------------------------------------------------------------------
    public boolean esVacio (){
        return raiz==null;
    }
      //-----------------------------------------------------------------------------------------------------------------------------
    public void vaciar(){
        raiz=null;
    }
    //-----------------------------------------------------------------------------------------------------------------------------
    public Lista listarPreOrden(){
        Lista salida= new Lista();
        listarPreordenAux(raiz,salida);
        return salida;
    }
    private void listarPreordenAux(NodoGen n, Lista ls){
        if(n!=null){
            //Visita del nodo n
            ls.insertar(n.getElem(), ls.longitud()+1);
            
            //Llamado recursivo con primer hijo de n
            if(n.getHijoIzquierdo()!=null){
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }
        
            //Llamados recursivos con los otros hijos de n 
            if(n.getHijoIzquierdo()!=null){
                NodoGen hijo= n.getHijoIzquierdo().getHermanoDerecho();
                while(hijo!=null){
                    listarInordenAux(hijo, ls);
                    hijo= hijo.getHermanoDerecho();
                }
            }
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------
    
    public String toString(){
        return toStringAux(raiz);
    }
    private String toStringAux(NodoGen n){
        String s=" ";
        if(n!=null){
            //Visita del nodo n
            s+= n.getElem().toString()+"-->";
            NodoGen hijo= n.getHijoIzquierdo();
            while(hijo!=null){
                s+=hijo.getElem().toString()+", ";
                hijo= hijo.getHermanoDerecho();
            }
            //Comienza recorrido de los hijos de n llamando recursivamente
            //para que cada hijo agregue su subcadena a la general
            hijo= n.getHijoIzquierdo();
            while(hijo!=null){
                s+='\n'+toStringAux(hijo);
                hijo= hijo.getHermanoDerecho();
            }
        }
        return s;
    }
      //-----------------------------------------------------------------------------------------------------------------------------
       public boolean pertenece(Object buscado){
        return perteneceAux(buscado,raiz);
        }
       
        private boolean perteneceAux(Object buscado, NodoGen n) {
            boolean rta = false;
            if (n != null) {
                // Visita del nodo n
                if (n.getElem().equals(buscado)) {
                    rta = true;
                } else {
                    NodoGen hijo = n.getHijoIzquierdo();
                    while (hijo != null && !rta) {
                        rta = perteneceAux(buscado, hijo);
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
            return rta;
        }
      //-----------------------------------------------------------------------------------------------------------------------------
       public ArbolGen clone(){
        ArbolGen clon = new ArbolGen();
        if(raiz != null){
            clon.raiz = new NodoGen(raiz.getElem(), null, null);
            auxClone(raiz, clon.raiz);
        }
        return clon;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
        private void auxClone(NodoGen nodo1,NodoGen nodo2) {
        //Entran dos nodo, un nodo raiz, y una copia de la raiz
        if (nodo1 != null && nodo2 != null) {
            //SI ambos son distintos de nulos, entonces:
            if (nodo1.getHijoIzquierdo()!= null) {
                //Al nodo copia de la raiz, se le asigna a su hijo izquierdo(que se inicializo en el publico con null) 
                // un nuevo nodo con el hijo izquierdo del nodo raiz original
               nodo2.setHijoIzquierdo(new NodoGen(nodo1.getHijoIzquierdo().getElem(),null,null));
              }
            
             if (nodo1.getHermanoDerecho()!= null) {
               nodo2.setHermanoDerecho(new NodoGen(nodo1.getHermanoDerecho().getElem(),null,null));
              }
             //Hace el llamado recursivo pero con los dos hijos izquierdo, del original y de la copia
             //los cuales ya son distintos de nulos.
             auxClone(nodo1.getHijoIzquierdo(),nodo2.getHijoIzquierdo());
             auxClone(nodo1.getHermanoDerecho(),nodo2.getHermanoDerecho());
              
            }
        }
}
