package jerarquicas;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

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
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoGen(elemNuevo, null, null);
        } else {
            NodoGen nPadre = buscarNodo(this.raiz, elemPadre);
            if (nPadre != null) {

                if (nPadre.getHijoIzquierdo() == null) {
                    nPadre.setHijoIzquierdo(new NodoGen(elemNuevo, null, null));
                } else {
                    NodoGen hijo = nPadre.getHijoIzquierdo();

                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(new NodoGen(elemNuevo, null, null));
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }
 //---------------------------------------------------------------------------------------------------------------------------------
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
    public Lista listarInorden(){
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
        public Lista listarPreorden() {
            Lista salida = new Lista();
            listarPreordenAux(this.raiz, salida);
            return salida;
        }

       private void listarPreordenAux(NodoGen nodo, Lista lis) {
        if (nodo != null) {
            // VISTA DEL NODO nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);

            // LLAMADOS RECURSIVOS CON LOS OTROS HIJOS DE nodo
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    listarPreordenAux(hijo, lis);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }
       //----------------------------------------------------------------------------------------------------------------------------- 
      public Lista listarPosorden(){
        Lista salida = new Lista();
        listarPosordenAux(this.raiz,salida);
        return salida;
    }
  private void listarPosordenAux(NodoGen nodo, Lista lis) {
        if (nodo != null) {

            // LLAMADOS RECURSIVOS CON LOS OTROS HIJOS DE nodo
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    listarPosordenAux(hijo, lis);
                    hijo = hijo.getHermanoDerecho();
                }
            }

            // VISTA DEL NODO nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }
    }
        //-----------------------------------------------------------------------------------------------------------------------------
               public Lista listarPorNiveles() {
               Lista lis = new Lista();
               Cola q = new Cola();
               NodoGen nodoActual;
               q.poner(this.raiz);
               if (!this.esVacio()) {
                   while (!q.esVacia()) {
                        nodoActual = (NodoGen) q.obtenerInicio();
                        q.sacar();
                        lis.insertar(nodoActual.getElem(), lis.longitud() + 1);

                        if (nodoActual.getHijoIzquierdo() != null) {
                            q.poner(nodoActual.getHijoIzquierdo());
                        }

                        if (nodoActual.getHijoIzquierdo() != null) {
                            NodoGen hijo = nodoActual.getHijoIzquierdo().getHermanoDerecho();
                            while (hijo != null) {
                                q.poner(hijo);
                                hijo = hijo.getHermanoDerecho();
                            }
                        }

                   }
               }

               return lis;
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
      //-----------------------------------------------------------------------------------------------------------------------------------------------
         public boolean equals(ArbolGen arb1) {
            return equalsAux(raiz, arb1.raiz);
            }
         
        private boolean equalsAux(NodoGen nodo1, NodoGen nodo2){
            boolean rta=false;
            if(nodo1==null && nodo2==null)
                rta=true;
            
            
            if(!rta && nodo1!=null && nodo2!=null){
                if(nodo1.getElem().equals(nodo2.getElem())){
                        rta=true;
                }
                 rta=rta&&equalsAux(nodo1.getHijoIzquierdo(),nodo2.getHijoIzquierdo());
                 rta=rta&&equalsAux(nodo1.getHermanoDerecho(),nodo2.getHermanoDerecho());
            }
            return rta;
        }
        //-----------------------------------------------------------------------------------------------------------------------------------------------
        
           public Object padre(Object elemento){
            Object retorno = null;
            if(this.raiz != null){
                if(!this.raiz.getElem().equals(elemento)){
                    retorno = padrePaso(this.raiz, elemento);   
                }
            }
            return retorno;
            }

        private Object padrePaso(NodoGen raiz, Object elemento){
            
            Object retorno = null;
            if(raiz != null){
                NodoGen aux = raiz.getHijoIzquierdo();
                boolean control = true;
                while(control && aux != null){
                    if(aux.getElem().equals(elemento)){
                        retorno = raiz.getElem();
                        control = false;
                    }else{
                        Object retornoHijo = padrePaso(aux, elemento);
                        if(retornoHijo != null){
                            retorno = retornoHijo;
                            control = false;
                        }
                    }
                    aux = aux.getHermanoDerecho();
                }
            }
            return retorno;
        }
     //-----------------------------------------------------------------------------------------------------------------------------------------------
         public int nivel(Object elem) {
        // METODO QUE CALCULA EL NIVEL DE UN DETERMINADO ELEMENTO MEDIANTE UN METODO
        // PRIVADO
        int nivel;
        nivel = buscarNivel(this.raiz, elem, -1);
        return nivel;
    }

    private int buscarNivel(NodoGen nodo, Object buscado, int a) {
        int nivel = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(buscado)) {
                nivel = a + 1;
            } else {

                // LLAMADOS RECURSIVOS CON LOS OTROS HIJOS DE nodo
                if (nodo.getHijoIzquierdo() != null) {
                    NodoGen hijo = nodo.getHijoIzquierdo();
                    while (hijo != null && nivel == -1) {
                        nivel = buscarNivel(hijo, buscado, a + 1);
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
        }
        return nivel;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    public Lista ancestros(Object elemento) {
        Lista ls = new Lista();
        ancestrosAux(this.raiz, elemento, ls);
        return ls;
    }

    private boolean ancestrosAux(NodoGen n, Object elem, Lista ls){
        boolean exito = false;
        if(n != null){
            //si encuentra el elemento retorna true
            if(n.getElem().equals(elem)){
                exito = true;
            }else{
                //si no encontro el elemento, verifica si tiene hijo
                //si n tiene hijo, entonces llama recursivamente
                if(n.getHijoIzquierdo() != null){
                    //si encuentra el elemento en el llamado recursivo con el hijo
                    //insertara n en la lista como ancestro
                    if(ancestrosAux(n.getHijoIzquierdo(), elem, ls)){
                        ls.insertar(n.getElem(), ls.longitud()+1);
                        exito = true;
                    }
                }
                if(n.getHijoIzquierdo() != null){
                    NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                    while(hijo != null){
                        if(ancestrosAux(hijo, elem, ls)){
                            ls.insertar(n.getElem(), ls.longitud()+1);
                            exito = true;
                        }
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
        }

        return exito;
    }
     //-----------------------------------------------------------------------------------------------------------------------------------------------
    
        public int altura() {
            // METODO QUE CALCULA LA ALTURA DEL ARBOL
            return alturaAux(this.raiz);
        }

        private int alturaAux(NodoGen nodo) {
            int aux = -1;
            int res = -1;
            if (nodo != null) {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    aux = alturaAux(hijo);
                    if (aux > res) {
                        res = aux;
                    }
                    hijo = hijo.getHermanoDerecho();
                }
                res++;
            }
            return res;
        }
       //-----------------------------------------------------------------------------------------------------------------------------------------------
            public Lista frontera() {
           // Metodo que devuelve una lista con los elementos de la frontera
           Lista lis = new Lista();
           fronteraAux(this.raiz, lis);
           return lis;
       }

       private void fronteraAux(NodoGen nodo, Lista lis) {
           // Metodo que devuelve una lista con los elementos de la frontera
           if (nodo != null) {
               if (nodo.getHijoIzquierdo() == null) {
                   lis.insertar(nodo.getElem(), lis.longitud() + 1);
               } else if (nodo.getHijoIzquierdo() != null) {
                   // Llamado recursivo con los hijos de nodo
                   NodoGen hijo = nodo.getHijoIzquierdo();
                   while (hijo != null) {
                       fronteraAux(hijo, lis);
                       hijo = hijo.getHermanoDerecho();
                   }
               }
           }
       }
 
       public boolean sonFrontera(Lista unaLista) {
           //Este metodo compara la lista del metodo frontera(que obtiene la lista de las hojas) y la lista pasada por parametro
           //y devolvera verdadero en caso de que esas dos listas sean iguales y falso en caso contrario
            boolean res = false;
            if(unaLista.longitud()!=this.frontera().longitud()){
                res=false;
            }
            if (!unaLista.esVacia()) {
                res = true;
                int puntero = 1; // puntero para recorrer la lista
                boolean seguir = true; // Variable para controlar el ciclo
                Lista frontera = this.frontera(); // Elementos de la frontera
                while (unaLista.recuperar(puntero) != null && seguir) {
                    // Se recorre la lista original
                    if (frontera.localizar(unaLista.recuperar(puntero)) == -1) {
                        // Si el elemento no esta en la frontera. Se sale del ciclo
                        seguir = false;
                        res = false;
                    } else {
                        // Si el elemento esta en la frontera, se elimina de la lista
                        puntero++;
                    }
                }
            }
            return res;
        }
         //-----------------------------------------------------------------------------------------------------------------------------------------------
         public int grado() {
        int grado = -1;
        if (!this.esVacio()) {
            grado = gradoAux(this.raiz);
        }
        return grado;
    }

    private int gradoAux(NodoGen nodo) {
        int gradoMayor = 0;
        int gradoActual = 0;
        int gradoHijo = 0;
        if (nodo != null) {
            // LLAMADOS RECURSIVOS CON LOS OTROS HIJOS DE nodo
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    gradoActual++;
                    gradoHijo = gradoAux(hijo);
                    if (gradoHijo > gradoMayor) {
                        gradoMayor = gradoHijo;
                    }
                    hijo = hijo.getHermanoDerecho();
                    

                }
                if (gradoActual > gradoMayor) {
                    gradoMayor = gradoActual;
                }
            }
        }
        return gradoMayor;
    }

    public int gradoSubarbol(Object elem) {
        int grado = -1;
        if (!this.esVacio()) {
            NodoGen buscado = buscarNodo(this.raiz, elem);
            if (buscado != null) {
                grado = gradoAux(buscado);
            }

        }
        return grado;
    }
  //-----------------------------------------------------------------------------------------------------------------------------------------------
    public boolean verificarCamino(Lista lista){
        boolean rta=false;
        if(!this.esVacio()){
            rta=verificarCaminoAux(raiz,lista);
        }
        return rta;
    }
      //-----------------------------------------------------------------------------------------------------------------------------------------------
      private boolean verificarCaminoAux(NodoGen nodo,Lista ls) {
        boolean correcto=false;
        if(nodo!=null){
            if(nodo.getElem().equals(ls.recuperar(1))){
                //SI el nodo en el que estoy es parte del camino
                ls.eliminar(1);
                if(!ls.esVacia()){
                    correcto=verificarCaminoAux(nodo.getHijoIzquierdo(),ls);
                }
            }else {
                NodoGen hermano = nodo.getHermanoDerecho();
                while(hermano!=null){
                    if(hermano.getElem().equals(ls.recuperar(1))){
                        correcto=verificarCaminoAux(hermano,ls);
                    }
                    hermano = hermano.getHermanoDerecho();
                }
            }
            if(ls.esVacia()){
                correcto=true;
            }
        }
        return correcto;
    }
        //-----------------------------------------------------------------------------------------------------------------------------------------------
      // FORMA RECURSIVA DE ROMI
      public boolean verificarCaminoRomi(Lista ls){
           boolean exito = false;
           if(this.raiz != null){
               exito = verificarCaminoAux(this.raiz, ls, 1);
           }
           return exito;
       }

       private boolean verificarCaminoAux(NodoGen n, Lista ls, int posActual){
           boolean exito = false;
           if(n!=null){
               if(posActual == ls.longitud()){
                    if(n.getElem().equals(ls.recuperar(posActual))){
                       exito = true;
                    }
               }else{
                   if(n.getElem().equals(ls.recuperar(posActual))){
                        exito = verificarCaminoAux(n.getHijoIzquierdo(), ls,posActual+1);
                    }else{
                       exito = verificarCaminoAux(n.getHermanoDerecho(), ls,posActual);
                    }
               }
           }
           return exito;
       }
        //-----------------------------------------------------------------------------------------------------------------------------------------------
           public boolean eliminar(Object buscado){
        return eliminarAux(buscado,raiz.getHijoIzquierdo(),raiz);
        }
//     private boolean eliminarAux(Object buscado, NodoGen nodo, NodoGen padre) {
//    boolean rta = false;
//    if (nodo != null) {
//        // Visita del nodo n
//        if (nodo.getElem().equals(buscado)) {
//            padre.setHijoIzquierdo(nodo.getHermanoDerecho());
//            rta = true;
//        } else {
//            NodoGen hijo = nodo.getHijoIzquierdo();
//            while (hijo != null && !rta) {
//                rta = eliminarAux(buscado, hijo.getHijoIzquierdo(), hijo);
//                hijo = hijo.getHermanoDerecho();
//            }
//        }
//    }
//    return rta;
//}
           private boolean eliminarAux(Object buscado, NodoGen nodo, NodoGen padre) {
                boolean rta = false;
                if (nodo != null) {
                    // Visita del nodo n
                    if (nodo.getElem().equals(buscado)) {
                                if (padre == null) {
                                        // Caso especial: eliminando la raíz del árbol
                                        nodo = null;
                                } else {
                                        // Enlazar el hermano derecho del nodo actual con el nodo anterior
                                        padre.setHijoIzquierdo(nodo.getHermanoDerecho());
                                }
                                        rta = true;
                    } else {
                                NodoGen hijo = nodo.getHijoIzquierdo();
                                NodoGen hermanoAnterior = null;
                                while (hijo != null && !rta) {
                                        rta = eliminarAux(buscado, hijo, nodo);
                                        if (!rta) {
                                            hermanoAnterior = hijo;
                                            hijo = hijo.getHermanoDerecho();
                                        }
                                }
                                if (rta && hermanoAnterior != null) {
                                    // Enlazar el hermano derecho del nodo eliminado con el nodo anterior
                                    hermanoAnterior.setHermanoDerecho(hijo);
                                }
                    }
                }
                return rta;
            }
               //-----------------------------------------------------------------------------------------------------------------------------------------------
            public Lista listarEntreNivelesInOrden(int niv1, int niv2){
            Lista ls = new Lista();
            return listarAuxInOrden(raiz,ls,niv1,niv2,0);
              }
           private Lista listarAuxInOrden(NodoGen nodo, Lista ls, int niv1, int niv2, int nivActual){
               if(nodo!=null){
                   if(nivActual<=niv2){
                   if(nodo.getHijoIzquierdo()!=null){
                       ls=listarAuxInOrden(nodo.getHijoIzquierdo(),ls,niv1,niv2,nivActual+1);
                   }
                   if(nivActual>=niv1){
                       ls.insertar(nodo.getElem(),ls.longitud()+1);
                   }
                   if(nodo.getHijoIzquierdo()!=null){
                       NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                       while (hijo!=null){
                           ls=listarAuxInOrden(hijo,ls,niv1,niv2,nivActual+1);
                           hijo=hijo.getHermanoDerecho();
                       }
                   }
                }
               }
               return ls;
           }
            //-----------------------------------------------------------------------------------------------------------------------------
        public Lista listarEntreNivelesPreOrden(int niv1,int niv2) {
            Lista salida = new Lista();
            listarEntreNivelesPreOrdenAux(raiz, salida,niv1,niv2,0);
            return salida;
        }

         private void listarEntreNivelesPreOrdenAux(NodoGen nodo, Lista lis,int niv1,int niv2, int nivAct) {
             if (nodo != null) {
                 if(nivAct <=niv2){
                 // VISTA DEL NODO nodo
                 if(nivAct>=niv1)
                 lis.insertar(nodo.getElem(), lis.longitud() + 1);

                 // LLAMADOS RECURSIVOS CON LOS OTROS HIJOS DE nodo
                 if (nodo.getHijoIzquierdo() != null) {
                     NodoGen hijo = nodo.getHijoIzquierdo();
                     while (hijo != null) {
                         listarEntreNivelesPreOrdenAux(hijo, lis,niv1,niv2,nivAct+1);
                         hijo = hijo.getHermanoDerecho();
                     }
                    }
                 }
             }
         }
              //----------------------------------------------------------------------------------------------------------------------------- 
          public Lista listarEntreNivelesPosOrden(int niv1,int niv2){
              Lista salida = new Lista();
              listarEntreNivelesPosOrdenAux(this.raiz,salida,niv1,niv2,0);
              return salida;
          }
        private void listarEntreNivelesPosOrdenAux(NodoGen nodo, Lista lis,int niv1,int niv2,int nivAct) {
          if (nodo != null) {
              if(nivAct<=niv2){
              // LLAMADOS RECURSIVOS CON LOS OTROS HIJOS DE nodo
              if (nodo.getHijoIzquierdo() != null) {
                  NodoGen hijo = nodo.getHijoIzquierdo();
                  while (hijo != null) {
                      listarEntreNivelesPosOrdenAux(hijo, lis,niv1,niv2,nivAct+1);
                      hijo = hijo.getHermanoDerecho();
                  }
              }
              // VISTA DEL NODO nodo
              if(nivAct>=niv1)
              lis.insertar(nodo.getElem(), lis.longitud() + 1);
          }
          }
      }
          //----------------------------------------------------------------------------------------------------------------------------- 
          public Lista listarHastaNivelPosOrden(int niv){
              Lista salida = new Lista();
              listarHastaNivelPosOrdenAux(this.raiz,salida,niv,0);
              return salida;
          }
                private void listarHastaNivelPosOrdenAux(NodoGen nodo, Lista lis,int niv,int nivAct) {
                  if (nodo != null) {
                     if(nivAct<=niv){
                      // LLAMADOS RECURSIVOS CON LOS OTROS HIJOS DE nodo
                      if (nodo.getHijoIzquierdo() != null) {
                          NodoGen hijo = nodo.getHijoIzquierdo();
                          while (hijo != null) {
                              listarHastaNivelPosOrdenAux(hijo, lis,niv,nivAct+1);
                              hijo = hijo.getHermanoDerecho();
                          }
                      }

                      // VISTA DEL NODO nodo
                      lis.insertar(nodo.getElem(), lis.longitud() + 1);
                    }
                  }
              }
         //----------------------------------------------------------------------------------------------------------------------------- 
        public Lista listarHastaNivelinOrden(int niv){
            Lista ls = new Lista();
            return listarHastaNivelinOrdenAux(raiz,ls,niv,0);
              }
           private Lista listarHastaNivelinOrdenAux(NodoGen nodo, Lista ls, int niv, int nivActual){
               if(nodo!=null){
                    if(nivActual<=niv){
                      if(nodo.getHijoIzquierdo()!=null){
                          ls=listarHastaNivelinOrdenAux(nodo.getHijoIzquierdo(),ls,niv,nivActual+1);
                      }

                          ls.insertar(nodo.getElem(),ls.longitud()+1);

                      if(nodo.getHijoIzquierdo()!=null){
                          NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                               while (hijo!=null){
                                   ls=listarHastaNivelinOrdenAux(hijo,ls,niv,nivActual+1);
                                   hijo=hijo.getHermanoDerecho();
                               }
                           }
                       }
               }
               return ls;
           }
               //-----------------------------------------------------------------------------------------------------------------------------------------------
             public Lista listarHastaNivPreorden(int niv) {
            Lista salida = new Lista();
            listarHastaNivPreordenAux(raiz, salida,niv,0);
            return salida;
        }

       private void listarHastaNivPreordenAux(NodoGen nodo, Lista lis,int niv,int nivAct) {
        if (nodo != null) {
            if(nivAct<=niv){
            // VISTA DEL NODO nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);

            // LLAMADOS RECURSIVOS CON LOS OTROS HIJOS DE nodo
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    listarHastaNivPreordenAux(hijo, lis,niv,nivAct+1);
                    hijo = hijo.getHermanoDerecho();
                }
              }
            }
        }
    }


}
