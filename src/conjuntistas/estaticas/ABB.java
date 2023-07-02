package conjuntistas.estaticas;
import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

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
        public Lista listar(){
            Lista lis = new Lista();
            listarAux(raiz,lis);
            return lis;
        }
        private void listarAux(NodoArbol nodo,Lista lis){
            if(nodo!=null){
            //Recorre a sus hijos en in orden
            listarAux(nodo.getIzquierdo(), lis);
                        //Visita la raiz
            lis.insertar(nodo.getElem(),lis.longitud()+1);
            
            listarAux(nodo.getDerecho(), lis);
            }
        }
         //-----------------------------------------------------------------------------------------------------------------------------------------------
     public boolean eliminar(Comparable elemento){
        boolean resultado = true;
        if(!(raiz==null)){
            resultado = eliminarAux(this.raiz, null, elemento);
        }else{
            resultado = false;
        }
        return resultado;
    }
    
    private boolean eliminarAux(NodoArbol n, NodoArbol padre, Comparable elemento){
        boolean exito = false;
        if(n != null){
            if((elemento.compareTo(n.getElem())) == 0){
                
                if(n.getIzquierdo() == null && n.getDerecho() == null){
                    //si n no tiene hijos
                    noTieneHijos(padre, elemento);
                    exito = true;
                    
                }else if((n.getIzquierdo() != null ^ n.getDerecho() != null)){
                    //si n tiene UN hijo
                    tieneUnHijo(n, padre, elemento);
                    exito = true;
                    
                }else{
                    // si n tiene ambos hijos
                    tieneAmbos(n);
                    exito = true;
                 }
                
            }else{
                if(elemento.compareTo(n.getElem())<0){
                    eliminarAux(n.getIzquierdo(), n, elemento);
                }
                if(elemento.compareTo(n.getElem())>0){
                    eliminarAux(n.getDerecho(), n, elemento);
                }
            }
        }
        return exito;
    
    }
    
    private void noTieneHijos(NodoArbol padre, Comparable elemento){
        
        //si no tiene hijos
        if(padre == null){
            //caso especial si el padre es nulo (raiz)
            this.raiz = null;
        }else{    
            if(elemento.compareTo(padre.getIzquierdo().getElem()) == 0){
                //si n es el HI de padre
                padre.setIzquierdo(null);
            }else{
                //si n es HD de padre
                padre.setDerecho(null);
            }
        }
        
    }
    
    private void tieneUnHijo(NodoArbol n, NodoArbol padre, Comparable elemento){
        
        if(n.getIzquierdo() != null){
            //si n tiene HI
            if(padre == null){
                // caso especial si el padre es nulo
                this.raiz.setIzquierdo(n.getIzquierdo());
            }else{
                if(elemento.compareTo(padre.getIzquierdo().getElem()) == 0){
                     //si n es el HI de padre
                    padre.setIzquierdo(n.getIzquierdo());
                }else{
                     //si n es el HD de padre
                    padre.setDerecho(n.getIzquierdo());
                }
            }
        }
        if(n.getDerecho() != null){
            //si n tiene HD
            if(padre == null){
                // caso especial si el padre es nulo
                this.raiz.setDerecho(n.getDerecho());
            }else{
                if(elemento.compareTo(padre.getIzquierdo().getElem()) == 0){
                    //si n es el HI de padre
                    padre.setIzquierdo(n.getDerecho());
                }else{
                    //si n es el HD de padre
                    padre.setDerecho(n.getDerecho());
                }
            }
        }
        
    }
    
    private void tieneAmbos(NodoArbol n){
        
        // si n tiene AMBOS hijos
        NodoArbol aux = n.getIzquierdo(); //tambien podria ser derecho
        if(aux.getDerecho()!=null){
            //si HI del nodo a eliminar tiene descendientes
            while(aux.getDerecho().getDerecho()!=null){ //seria izquierdo si antes optabamos por derecho
                aux = aux.getDerecho();
            } 
            n.setElemento(aux.getDerecho().getElem()); //seteo el elemento del candidato a n
            if(aux.getDerecho().getIzquierdo()!=null){
                // si el candidato tiene HI
                aux.setDerecho(aux.getDerecho().getIzquierdo());
            }else{
                // si el candidato no tiene HI
                aux.setDerecho(null);

            }
        }else{
            //si HI del nodo a eliminar es el candidato
            n.setElemento(aux.getElem());
            //como candidato no tiene HD
            //si no tuviera HI, de igual manera se setea a nulo          
            n.setIzquierdo(aux.getIzquierdo());

        }
        
    }
//    public boolean eliminarMinimo(){
//        boolean rta=false;
//        if(raiz!=null){
//        rta=eliminarMinimoAux(raiz);
//        }
//        return rta;
//    }
   //-----------------------------------------------------------------------------------------------------------------------------------------------
//    private boolean eliminarMinimoAux(NodoArbol nodo){
//        boolean rta=false;
//        if(nodo.getIzquierdo()!=null){
//        while(nodo.getIzquierdo().getIzquierdo()!=null){
//                nodo=nodo.getIzquierdo();
//            }
//            nodo.setIzquierdo(nodo.getIzquierdo().getDerecho());
//            rta=true;
//        }else{
//            raiz=null;
//        }
//        return rta;
//    }
     //-----------------------------------------------------------------------------------------------------------------------------------------------
  private NodoArbol obtenerRaiz(NodoArbol n, Comparable elemento){
        NodoArbol resultado = null;
        if(n!=null){
            if(elemento.compareTo(n.getElem()) == 0){
                resultado = n;
            }else if(elemento.compareTo(n.getElem()) < 0){
                resultado = obtenerRaiz(n.getIzquierdo(), elemento);

            }else{
                resultado = obtenerRaiz(n.getDerecho(), elemento);
            }
        }
        return resultado;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------
      public ABB clonarParteInvertida(Comparable elem){
        ABB elClon = new ABB();
        if(this.raiz!=null){
            NodoArbol raizNueva = obtenerRaiz(this.raiz, elem);
            elClon.raiz = new NodoArbol(raizNueva.getElem(), null, null);
            auxClone(raizNueva, elClon.raiz);
        }
        return elClon;
    }
     //-----------------------------------------------------------------------------------------------------------------------------------------------
      
      private void auxClone(NodoArbol raizO,NodoArbol copia){
          if(raizO!=null){
             
              if (raizO.getIzquierdo()!= null) {
                //copia.setIzquierdo(new NodoArbol(raizO.getIzquierdo().getElem(),null,null));
                copia.setDerecho(new NodoArbol(raizO.getIzquierdo().getElem(),null,null));
              }
           if (raizO.getDerecho()!= null) {
               //copia.setDerecho(new NodoArbol(raizO.getDerecho().getElem(),null,null));
               copia.setIzquierdo(new NodoArbol(raizO.getDerecho().getElem(),null,null));
              }
           
             //Hace el llamado recursivo pero con los dos hijos izquierdo, del original y de la copia
             //los cuales ya son distintos de nulos.
             auxClone(raizO.getIzquierdo(),copia.getDerecho());
             auxClone(raizO.getDerecho(),copia.getIzquierdo());
             
          }
      }
           //-----------------------------------------------------------------------------------------------------------------------------------------------
      public void eliminarMinimo(){
          eliminarMinimoAux(raiz);
      }
      
//      private void eliminarMinimoAux(NodoArbol nodo){
//          if(nodo!=null){
//              while(nodo.getIzquierdo().getIzquierdo()!=null){
//                  nodo=nodo.getIzquierdo();
//              }
//              if(nodo.getIzquierdo().getIzquierdo()==null){
//                  nodo.setIzquierdo(nodo.getIzquierdo().getDerecho());
//              }
//          }
//      }
      private void eliminarMinimoAux(NodoArbol nodo){
          NodoArbol aux= nodo.getIzquierdo();
          if(aux!=null){
              if(aux.getIzquierdo()!=null){
                  while(aux.getIzquierdo().getIzquierdo()!=null){
                      aux=aux.getIzquierdo();
                  }
                  aux.setIzquierdo(aux.getIzquierdo().getDerecho());
              }else{
                  nodo.setIzquierdo(nodo.getIzquierdo().getDerecho());
              }
          }
      }
  //-----------------------------------------------------------------------------------------------------------------------------------------------
       public Lista listarRango(Comparable min, Comparable max) {
        Lista ls = new Lista();
        if (raiz!=null) {
            listarRangoAux(this.raiz,min,max, ls);
        }
        return ls;
    }
    private void listarRangoAux(NodoArbol nodo,Comparable minimo, Comparable maximo, Lista lista) {
        if (nodo != null) {
            Comparable elemento = (Comparable) nodo.getElem();
            if (elemento.compareTo(maximo) < 0) {
                listarRangoAux(nodo.getDerecho(), minimo, maximo, lista);
                System.out.println(elemento.compareTo(maximo) < 0);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
                lista.insertar(elemento, 1);
            }
            if (elemento.compareTo(minimo) > 0) {
                listarRangoAux(nodo.getIzquierdo(), minimo, maximo, lista);
            }
        }

    }
      //-----------------------------------------------------------------------------------------------------------------------------------------------
   public Lista listarMayorIgual(Comparable elem) {
        Lista ls = new Lista();
        if (raiz != null) {
            listarMayorAux(raiz, elem, ls);
        }
        return ls;
    }
    private void listarMayorAux(NodoArbol n, Comparable elem, Lista ls) {
        if (n != null) {
            listarMayorAux(n.getDerecho(), elem, ls);
            if (elem.compareTo(n.getElem()) <= 0) {
                ls.insertar(n.getElem(), ls.longitud()+1);
            }
            if (elem.compareTo(n.getElem()) < 0) {
                listarMayorAux(n.getIzquierdo(), elem, ls);
            }
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------
     private boolean eliminarelemAnteriorAux(NodoArbol nodo){
        boolean rta=false;
        NodoArbol hijo;
       
        if(nodo!=null){
            if(nodo.getIzquierdo()!=null){
                 hijo=nodo.getIzquierdo();
                 if(hijo.getDerecho()!=null){
                        while(hijo.getDerecho().getDerecho()!=null){
                            hijo=hijo.getDerecho();
                        }
                        NodoArbol nodito=hijo.getDerecho().getIzquierdo();
                        hijo.setDerecho(nodito);
                        rta=true;
                }else {
                nodo.setIzquierdo(nodo.getIzquierdo().getIzquierdo());
                rta=true;
            }
         }
        }
        return rta;
    }
        //-----------------------------------------------------------------------------------------------------------------------------------------------
    public boolean eliminarElemAnterior(Comparable elem){
        NodoArbol nuevaRaiz;
        nuevaRaiz= obtenerRaiz(raiz, elem);
        boolean rta=false;
        if(nuevaRaiz!=null){
            rta=eliminarelemAnteriorAux(nuevaRaiz);
        }else{
            rta=false;
        }
        return rta;
    }
         //-----------------------------------------------------------------------------------------------------------------------------------------------
        private NodoArbol candidatoIzq(NodoArbol raiz){
            NodoArbol candiIzq=null;
            if(raiz!=null){
                if(raiz.getIzquierdo()!=null){
                    NodoArbol hijo= raiz.getIzquierdo();
                    if(hijo.getDerecho()!=null){
                        while(hijo.getDerecho()!=null){
                            hijo=hijo.getDerecho();
                        }
                        candiIzq=hijo;
                    }else{
                    while(hijo.getIzquierdo()!=null){
                        hijo=hijo.getIzquierdo();
                    }
                    candiIzq=hijo;
                }
            }
        }
            return candiIzq;
    }
          //-----------------------------------------------------------------------------------------------------------------------------------------------
        private NodoArbol candidatoDere(NodoArbol raiz){
            NodoArbol candiIzq=null;
            if(raiz!=null){
                if(raiz.getDerecho()!=null){
                    NodoArbol hijo= raiz.getDerecho();
                    if(hijo.getIzquierdo()!=null){
                        while(hijo.getIzquierdo()!=null){
                            hijo=hijo.getIzquierdo();
                        }
                        candiIzq=hijo;
                    }else{
                    while(hijo.getDerecho()!=null){
                        hijo=hijo.getDerecho();
                    }
                    candiIzq=hijo;
                }
            }
        }
            return candiIzq;
    }
        public Comparable mejorCandidato(Comparable elem){
            NodoArbol nuevaRaiz = obtenerRaiz(this.raiz, elem);
            NodoArbol candidatoDerecho= candidatoDere(nuevaRaiz);
            NodoArbol candidatoIzquierdo= candidatoIzq(nuevaRaiz);
            Comparable rta = null;
            if(candidatoDerecho!=null && candidatoIzquierdo!=null){
                int resta1= (int) candidatoDerecho.getElem()-(int)elem;
                 int resta2=(int)elem- (int) candidatoDerecho.getElem();
                 if(resta1<resta2){
                     rta=(Comparable) candidatoDerecho.getElem();
                 }else{
                     rta=(Comparable) candidatoIzquierdo.getElem();
                 }
            }
            if(candidatoDerecho==null&& candidatoIzquierdo!=null){
                rta=(Comparable) candidatoIzquierdo.getElem();
            }
            if(candidatoDerecho!=null&& candidatoIzquierdo==null){
                rta=(Comparable) candidatoDerecho.getElem();
            }
            if(candidatoDerecho==null && candidatoIzquierdo==null){
                rta=-1;
            }
            if(nuevaRaiz==null){
                rta=0;
            }
            return rta;
        }
}


