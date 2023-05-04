package jerarquicas;
import lineales.dinamicas.Lista;

public class ArbolBin {
 
    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }
    
//-----------------------------------------------------------------------------------------------------------------------------------------------
    
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
    
  //-----------------------------------------------------------------------------------------------------------------------------------------------
    
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
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    public Object obtenerPadre(Object padre){
        Object resultado=null;
        if(raiz==null){
            resultado=null;
        }else{
           resultado = obtenerPadre(padre, raiz);
        }
        return resultado;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
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
            
//-----------------------------------------------------------------------------------------------------------------------------------------------
        public ArbolBin clone(){
        ArbolBin clon = new ArbolBin();
        if(raiz != null){
            clon.raiz = new NodoArbol(raiz.getElem(), null, null);
            auxClone(raiz, clon.raiz);
        }
        return clon;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    
        private void auxClone(NodoArbol nodo1,NodoArbol nodo2) {
        //Entran dos nodo, un nodo raiz, y una copia de la raiz
        if (nodo1 != null && nodo2 != null) {
            //SI ambos son distintos de nulos, entonces:
            if (nodo1.getIzquierdo() != null) {
                //Al nodo copia de la raiz, se le asigna a su hijo izquierdo(que se inicializo en el publico con null) 
                // un nuevo nodo con el hijo izquierdo del nodo raiz original
               nodo2.setIzquierdo(new NodoArbol(nodo1.getIzquierdo().getElem(),null,null));
              }
            
             if (nodo1.getDerecho()!= null) {
               nodo2.setDerecho(new NodoArbol(nodo1.getDerecho().getElem(),null,null));
              }
             //Hace el llamado recursivo pero con los dos hijos izquierdo, del original y de la copia
             //los cuales ya son distintos de nulos.
             auxClone(nodo1.getIzquierdo(),nodo2.getIzquierdo());
             auxClone(nodo1.getDerecho(),nodo2.getDerecho());
              
            }
        }
          //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    
        private void auxCloneInvertido(NodoArbol nodo1,NodoArbol nodo2) {
        //Entran dos nodo, un nodo raiz, y una copia de la raiz
        if (nodo1 != null && nodo2 != null) {
             //SI ambos son distintos de nulos, entonces:
            if (nodo1.getIzquierdo() != null) {
                //Al nodo copia de la raiz, se le asigna a su hijo izquierdo(que se inicializo en el publico con null) 
                // un nuevo nodo con el hijo izquierdo del nodo raiz original
               nodo2.setIzquierdo(new NodoArbol(nodo1.getIzquierdo().getElem(),null,null));
              }
            
             if (nodo1.getDerecho()!= null) {
               nodo2.setDerecho(new NodoArbol(nodo1.getDerecho().getElem(),null,null));
              }
             //Hace el llamado recursivo pero con los dos hijos izquierdo, del original y de la copia
             //los cuales ya son distintos de nulos.
             auxClone(nodo1.getIzquierdo(),nodo2.getIzquierdo());
             auxClone(nodo1.getDerecho(),nodo2.getDerecho());
              
            }
        }

        //-----------------------------------------------------------------------------------------------------------------------------------------------
        public ArbolBin cloneInvertido(){
        ArbolBin clon = new ArbolBin();
        if(raiz != null){
            clon.raiz = new NodoArbol(raiz.getElem(), null, null);
            auxCloneInvertido(raiz, clon.raiz);
        }
        return clon;
        }
//-----------------------------------------------------------------------------------------------------------------------------------------------
        public Lista listarPreOrder(){
            Lista lis = new Lista();
            listarPreOrdenAux(raiz,lis);
            return lis;
        }
        private void listarPreOrdenAux(NodoArbol nodo,Lista lis){
            
            if(nodo!=null){
             //Visita el elemento en el nodo
            lis.insertar(nodo.getElem(),lis.longitud()+1);
            
            //Recorre a sus hijos en pre orden
            listarPreOrdenAux(nodo.getIzquierdo(), lis);
            listarPreOrdenAux(nodo.getDerecho(), lis);
            }
        }
        //-----------------------------------------------------------------------------------------------------------------------------------------------
        public Lista listarPosOrder(){
            Lista lis = new Lista();
            listarPosOrdenAux(raiz,lis);
            return lis;
        }
        private void listarPosOrdenAux(NodoArbol nodo,Lista lis){
            
            //Recorre a sus hijos en pos orden
            listarPreOrdenAux(nodo.getIzquierdo(), lis);
            listarPreOrdenAux(nodo.getDerecho(), lis);
            //Visita la raiz
            lis.insertar(nodo.getElem(),lis.longitud()+1);
        }
         //-----------------------------------------------------------------------------------------------------------------------------------------------
        public Lista listarInOrder(){
            Lista lis = new Lista();
            listarInOrdenAux(raiz,lis);
            return lis;
        }
        private void listarInOrdenAux(NodoArbol nodo,Lista lis){
            
            //Recorre a sus hijos en pos orden
            listarPreOrdenAux(nodo.getIzquierdo(), lis);
                        //Visita la raiz
            lis.insertar(nodo.getElem(),lis.longitud()+1);
            
            listarPreOrdenAux(nodo.getDerecho(), lis);
        }
        
           //-----------------------------------------------------------------------------------------------------------------------------------------------
        public int altura1 (){
            int alt=0;
            NodoArbol aux=raiz;
            alt= alturaAux1(aux);
            return alt;
        }
        
        private int alturaAux1(NodoArbol nodo){
            if (nodo == null) {
                return -1; // si el nodo es nulo, la altura es -1
            } else {
                int alturaIzquierda = alturaAux1(nodo.getIzquierdo()); // altura del subárbol izquierdo
                int alturaDerecha = alturaAux1(nodo.getDerecho()); // altura del subárbol derecho
                return 1 + Math.max(alturaIzquierda, alturaDerecha); // altura del nodo actual es 1 más el máximo de las alturas de sus subárboles
            }
        }
    //-----------------------------------------------------------------------------------------------------------------------------------------------    
        public int altura2() {
         return alturaAu2(raiz);
         }

    // FORMA 1 DE CALCULAR ALTURA
        private int alturaAu2(NodoArbol nodo) {
            if (nodo == null) {
                // Si el nodo es nulo, entonces la altura es 0.
                return 0;
            } else {
                // Calcula la altura de los subárboles izquierdo y derecho
                int alturaIzquierda = alturaAu2(nodo.getIzquierdo());
                int alturaDerecha = alturaAu2(nodo.getDerecho());

                // La altura del árbol es el máximo entre las alturas de los subárboles más uno.
                int alturaMaxima;
                if(alturaIzquierda > alturaDerecha){
                    alturaMaxima=alturaIzquierda;
                }else{
                    alturaMaxima=alturaDerecha;
                }
                return alturaMaxima + 1;
            }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------


        public int altura3() {
            //Este modulo devuelve la altura del arbol que lo llama
            int altura;
            if (raiz==null) {
                altura = 0;
            } else {
                altura = determinarAltura(raiz, 0, 0);
            }
            return altura+1;
        }

        private int determinarAltura(NodoArbol nodoAct, int nivelAct, int altMax) {
            if (nodoAct.getIzquierdo()!= null) {
                if (nivelAct + 1 > altMax) {
                    altMax = nivelAct + 1;
                }
                altMax = determinarAltura(nodoAct.getIzquierdo(), nivelAct + 1, altMax);
            }
            if (nodoAct.getDerecho()!= null) {
                if (nivelAct + 1 > altMax) {
                    altMax = nivelAct + 1;
                }
                altMax = determinarAltura(nodoAct.getDerecho(), nivelAct + 1, altMax);
            }
            return altMax;
        }
        //-----------------------------------------------------------------------------------------------------------------------------------------------
        
        public int nivel(Object buscado){
            int nivel=-1;
            return nivelAux(buscado, raiz, nivel);
        }
        
        private int nivelAux (Object buscado, NodoArbol nodo, int nivel){
            int encontrado=-1;
            if(nodo!=null){
                if(nodo.getElem().equals(buscado)){
                    encontrado= nivel+1;
                }else if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                // Si llegamos a una hoja encontrado se asigna con -1 y se retorna
                encontrado = -1;
                
                }else if (nodo.getIzquierdo() != null) {
                encontrado = nivelAux(buscado,nodo.getIzquierdo(), nivel + 1);
            }

            if (nodo.getDerecho() != null && encontrado == -1) {
                encontrado = nivelAux(buscado,nodo.getDerecho(), nivel + 1);
            }
                 
            }
            return encontrado;

        }
        public boolean pertenece(Object buscado){
            boolean resp=false;
            return perteneceAux(raiz, buscado);
        }
        private boolean perteneceAux(NodoArbol nodo, Object buscado){
            boolean rta=false;
            if(nodo!=null){
                if(nodo.getElem().equals(buscado)){
                    rta=true;
                }else{
                    if(nodo.getIzquierdo()!=null  && (buscado.equals(nodo.getIzquierdo().getElem()))){
                        rta=true;
                    }
                    if(nodo.getDerecho()!=null  && (buscado.equals(nodo.getDerecho().getElem()))){
                        rta=true;
                    }
                }
                if(rta==false){
                    rta=perteneceAux(nodo.getIzquierdo(),buscado);
                }
                if(rta==false){
                    rta=perteneceAux(nodo.getDerecho(),buscado);
                }
            }
            
            return rta;
        }
        
        
   } //FIN
