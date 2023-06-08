
package lineales.dinamicas;

/**
 *
 * @author ulise
 */
public class Lista {
    private Nodo cabecera;
    
    
    //-------------------------------------------------------------------------------------------------------------------------------------------
    
    
    public  Lista(){
        cabecera=null;
    }
    
     //-------------------------------------------------------------------------------------------------------------------------------------------
    
    public boolean insertar(Object nuevoElem, int pos){
        //Insertar el elemento nuevo en la posicion pos
        //Detecta y reporta error posicion invalida
        boolean exito=true;
        if(pos<1 || pos>longitud() + 1){
            exito=false;
        }else{
            if(pos==1){
                //Crea un nuevo nodo y se enlaza en la cabezera
                cabecera = new Nodo(nuevoElem,cabecera);
            }else{
                //Avanza hasta el elemento en la posicion pos-1
                Nodo aux= cabecera;
                int i=1;
                while(i<pos-1){
                    aux= aux.getEnlace();
                    i++;
                }
                //crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElem,aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        return exito;
    }


    
        //-------------------------------------------------------------------------------------------------------------------------------------------
        public int longitud(){
            Nodo aux= cabecera;
            int contador=0;
            while(aux!=null){
                aux=aux.getEnlace();
                contador++;
            }
            return contador;
        }
        
        //-------------------------------------------------------------------------------------------------------------------------------------------
        public void vaciar(){
            cabecera.setEnlace(null);
        }
       //-------------------------------------------------------------------------------------------------------------------------------------------
        public boolean esVacia(){
            boolean rta=false;
            Nodo aux=cabecera;
            if(cabecera==null){
                rta=true;
            }
            return rta;
        }
       //-------------------------------------------------------------------------------------------------------------------------------------------
    
        public boolean eliminar( int pos){
        //Detecta y reporta error posicion invalida
        boolean exito=true;
        if(pos<1 || pos>longitud() + 1){
            exito=false;
        }else{
            if(pos==1){
                cabecera= cabecera.getEnlace();
                //Ahora cabecera tendra el nodo sucedor y se borra el que tenia.
            }else{
                //Avanza hasta el elemento en la posicion pos-1
                Nodo aux= cabecera;
                int i=1;
                while(i<pos-1){
                    aux= aux.getEnlace();
                    i++;
                }
                // setea el enlace del Nodo anterior a borrar, dejandolo en null.
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        return exito;
    }
         //-------------------------------------------------------------------------------------------------------------------------------------------
   public String toString(){
        String retorno = "Lista Vacia";
        //evaluamos que la lista no este vacia
        if(this.cabecera != null){
            retorno = "[";
            Nodo aux = this.cabecera;
            
            while(aux != null){
                retorno = retorno + aux.getInformacion().toString();
                if(aux.getEnlace() != null){
                    retorno += ",";
                }
                aux = aux.getEnlace();
            }
            
            retorno += "]";
        }
        return retorno;
    }     
    
       //-------------------------------------------------------------------------------------------------------------------------------------------
   
      public Object recuperar(int pos){
        Object devolver=null;
        Nodo aux = this.cabecera;
        if((pos<0)||(pos>longitud())){
            devolver=null;
        }else{
            int i=1;
            while ((i!=pos)&&(aux!=null)){
                aux=aux.getEnlace();
                i++;
            }//Me muevo hasta aux=pos
            if(aux!=null){
                devolver=aux.getInformacion();
            }
        }
        return devolver;
    }
           //-------------------------------------------------------------------------------------------------------------------------------------------
        public int localizar(Object elem){
            Nodo puntero=cabecera;
            Nodo aux;
            int pos=-1;
            int contador=1;
            if(cabecera==null){
                pos=-1;
            }else{
                    while(!elem.equals(puntero.getInformacion()) && puntero.getEnlace()!=null){
                        puntero= puntero.getEnlace();
                        contador++;
                    }
            }
                if(elem.equals(puntero.getInformacion())){
                    pos= contador;
                }
                return pos;
        }
        
         //-------------------------------------------------------------------------------------------------------------------------------------------
        
//        public Lista obtenerMultiplo(int num,Lista listaActual){
//            Lista q = listaActual;
//            Lista retorno= new Lista();
//            Nodo aux= listaActual.cabecera;
//            int contador1=1, contador2=1;
//            if(q.cabecera!=null){
//                while(aux!=null){
//                    if(contador2 % num==0){
//                        Nodo nuevo = new Nodo(aux.getInformacion(),aux.getEnlace());
//                        retorno.insertar(nuevo.getInformacion(), contador1);
//                        contador1++;
//                    }
//                    aux=aux.getEnlace();
//                    contador2++;
//                }
//            }
//            return retorno;
//        }
        
         //-------------------------------------------------------------------------------------------------------------------------------------------
        
//        public Lista obtenerMultiplo(int num,Lista listaActual){
//            Lista q = listaActual;
//            Lista retorno= new Lista();
//            Nodo aux= listaActual.cabecera;
//            Nodo aux2=null;
//            int contador1=1, contador2=1;
//            if(q.cabecera!=null){
//                while(aux!=null){
//                    if(contador2 % num==0){
//                         Nodo nuevo = new Nodo(aux.getInformacion(),null);
//                        if(retorno.cabecera==null){
//                            retorno.cabecera= nuevo;
//                            aux2= retorno.cabecera;
//                        }else{
//                            aux2.setEnlace(nuevo);
//                            aux2=aux2.getEnlace();
//                        }
//                        contador1++;
//                    }
//                    aux=aux.getEnlace();
//                    contador2++;
//                    
//                }
//            }
//            return retorno;
//        }
         //-------------------------------------------------------------------------------------------------------------------------------------------
            // DEBEMOS DEVOLVER UNA NUEVA LISTA. POR ESO CREAMOS DENTRO DEL METODO UNA NUEVA LISTA
            private Lista obtenerMultiplosAux(int num) {
                Lista retorno = new Lista();
                Nodo aux = cabecera;
                Nodo aux2 = null;
                int contador = 1;
                if (cabecera != null) {
                    while (aux != null) {
                        if (contador % num == 0) {
                            Nodo nuevo = new Nodo(aux.getInformacion(), null);
                            if (retorno.cabecera == null) {
                                retorno.cabecera = nuevo;
                                aux2 = retorno.cabecera;
                            } else {
                                aux2.setEnlace(nuevo);
                                aux2 = aux2.getEnlace();
                            }
                        }
                        aux = aux.getEnlace();
                        contador++;
                    }
                }
                return retorno;
            }

            public Lista obtenerMultiplos(int num) {
                return obtenerMultiplosAux(num);
                
            }

    // Resto de operaciones del TDA Lista
        

        
         //-------------------------------------------------------------------------------------------------------------------------------------------
//        public Lista eliminarApariciones (Object x, Lista listaActual){
//            Lista q = listaActual;
//            Nodo puntero= q.cabecera;
//            int contador1=1;
//            while(puntero !=null){
//               if (puntero.getInformacion().equals(x)) {
//                    q.eliminar(contador1);
//                    puntero = q.cabecera;
//                    contador1 = 1;
//                } else {
//                    contador1++;
//                    puntero = puntero.getEnlace();
//                }
//            }
//            return q;
//        }
     //-------------------------------------------------------------------------------------------------------------------------------------------
  
                //DEVUELVE VOID PORQUE SOLO MODIFICO LA LISTA DEL TDA.
            public void eliminarApariciones(Object x) {
                cabecera = eliminarAparicionesAux(x, cabecera);
            }
                //DEBEMOS MODIFICAR LA LISTA DEL TDA, POR ESO NO DEVOLVEMOS UNA NUEVA LISTA, SOLO
            //DEVOLVEMOS LA CABECERA MODIFICADA
            private Nodo eliminarAparicionesAux(Object x, Nodo cabe) {
                Nodo aux = cabe;
                Nodo aux2 = null;
                int contadorEliminados = 0;
                while (aux != null) {
                    if (aux.getInformacion().equals(x)) {
                        contadorEliminados++;
                        if (contadorEliminados == 1) {
                            cabe = cabe.getEnlace();
                            aux2 = cabe;
                        } else {
                            aux2.setEnlace(aux.getEnlace());
                        }
                    } else {
                        aux2 = aux;
                    }
                    aux = aux.getEnlace();
                }
                return cabe;
            }
             //-------------------------------------------------------------------------------------------------------------------------------------------
//            public void agregarElem(Object k, int x){
//                cabecera=agregarElemAux(k, x);
//            }
//            
//             //-------------------------------------------------------------------------------------------------------------------------------------------
//            private Nodo agregarElemAux(Object k, int x){
//                Nodo aux1=cabecera;
//                Nodo nuevo = new Nodo(k,null);
//                int cont1=1;
//                int cont2=1;
//                while(aux1!=null){
//                    if(cont1==1){
//                        nuevo.setEnlace(cabecera);
//                        cabecera=nuevo;
//                        aux1=cabecera;
//                        cont1+=x-1;
//                       // cont1++;
//                    }else{
//                        cont2++;
//                        if(cont2%x==0){
//                            nuevo.setEnlace(aux1.getEnlace());
//                            aux1.setEnlace(nuevo);
//                            aux1=aux1.getEnlace();
//                        }
//                        aux1=aux1.getEnlace();
//                    }
//                    cont1++;
//                }
//                return cabecera;
//            }
                      public void agregarElemento(Object nuevo, int x) {
    Nodo actual = cabecera;
    int contador = 0;

    // Agregar el elemento nuevo en la posición 1
    Nodo nodoNuevo = new Nodo(nuevo);
    nodoNuevo.setEnlace(actual);
    cabecera = nodoNuevo;
    
    actual = actual.getEnlace();
    contador++;

    // Recorrer la lista y agregar el elemento nuevo cada x+1 posiciones
    while (actual != null) {
        if ((contador+1) % (x+1) == 0) {
            Nodo nodoNuevo2 = new Nodo(nuevo);
            nodoNuevo2.setEnlace(actual);
            actual = nodoNuevo2;
        }
        
        contador++;
        actual = actual.getEnlace();
    }
}




            
            
            
            
            
            
            
            
        }


                     //-------------------------------------------------------------------------------------------------------------------------------------------
//        private Lista eliminarAparicionesAux (Object x, Lista listaActual){
//            Lista q = listaActual;
//            Nodo puntero= q.cabecera;
//            Nodo aux2=null;
//            int contador1=1;
//            int contadorEliminados=0;
//             while (puntero != null) {
//                    if (puntero.getInformacion().equals(x)) {
//                                contadorEliminados++;
//                                if (contadorEliminados == 1) {
//                                    q.cabecera = q.cabecera.getEnlace();
//                                    aux2 = q.cabecera;
//                                } else {
//                                    aux2.setEnlace(aux2.getEnlace().getEnlace());
//                                }
//                        } else {
//                                aux2 = puntero;
//                        }
//                                puntero = puntero.getEnlace();
//                }
//            return q;
//        }
     //-------------------------------------------------------------------------------------------------------------------------------------------

    


