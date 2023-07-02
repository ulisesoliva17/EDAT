
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
                //Crea un nuevo nodo y se enlaza con la cabezera
               Nodo nuevo = new Nodo(nuevoElem,null);
               nuevo.setEnlace(cabecera);
               cabecera=nuevo;
            }else{
                //Avanza hasta el elemento en la posicion pos-1
                Nodo aux= cabecera;
                int i=1;
                while(i<pos-1){
                    aux= aux.getEnlace();
                    i++;
                }
                //crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElem,null);
                nuevo.setEnlace(aux.getEnlace());
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
            // DEBEMOS DEVOLVER UNA NUEVA LISTA. POR ESO CREAMOS DENTRO DEL METODO UNA NUEVA LISTA
            public Lista obtenerMultiplos(int num) {
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

    // Resto de operaciones del TDA Lista
     
                //DEVUELVE VOID PORQUE SOLO MODIFICO LA LISTA DEL TDA.
            public void eliminarApariciones1(Object x) {
                cabecera = eliminarAparicionesAux1(x, cabecera);
            }
                //DEBEMOS MODIFICAR LA LISTA DEL TDA, POR ESO NO DEVOLVEMOS UNA NUEVA LISTA, SOLO
            //DEVOLVEMOS LA CABECERA MODIFICADA
            private Nodo eliminarAparicionesAux1(Object x, Nodo cabe) {
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
    public void agregarElemento(Object elem, int x) {
       Nodo actual = cabecera;
       int contador = 0;

       // Agregar el elemento nuevo en la posición 1
       Nodo nodoNuevo = new Nodo(elem);
       nodoNuevo.setEnlace(actual);
       cabecera = nodoNuevo;

       actual = actual.getEnlace();
       contador++;

       // Recorrer la lista y agregar el elemento nuevo cada x+1 posiciones
       while (actual != null) {
           if ((contador+1) % (x+1) == 0) {
               Nodo nodoNuevo2 = new Nodo(elem);
               nodoNuevo2.setEnlace(actual);
               actual = nodoNuevo2;
           }

           contador++;
           actual = actual.getEnlace();
       }
   }
    /*Agregar al TDA Lista la operación cambiarPosicion(int pos1, int pos2) 
    que elimina al elemento de pos1 y lo inserta en pos2.
    Por ejemplo, si lis es [6,2,7,1,3,5], pos1=3 y pos2=5, el método debe 
    modificar la lista para que quede [6,2,1,3,7,5]
    Realizar una traza para la lista[2,1,4,3,5,8], pos1=2 y pos2=4. 
    IMPORTANTE: 
    No usar metodos del TDA Lista y recorrer sola una vez la lista*/
    public void cambiarPosiciones (int pos1,int pos2){
      cambiarPosicionesAux(pos1,pos2);
    }
    private void cambiarPosicionesAux (int pos1, int pos2){
        int contador1=1,contador2=1;
        Nodo aux1=cabecera;
        Nodo aux2=cabecera;
        Nodo aux3=null;
        
        //POS1 es 1 y el POS2 cualquier otra posicion mayor
        if(pos1==1 && pos2>1){
            cabecera=aux1.getEnlace();
            while(contador1!=pos2){
                aux2=aux2.getEnlace();
                contador1++;
            }
            aux1.setEnlace(aux2.getEnlace());
            aux2.setEnlace(aux1);
            contador1=1;
            contador2=1;
        }
        //POS1 ES MENOR QUE POS2
        if(pos1>1 && pos1<pos2){
            while(contador1!=(pos1-1)){
                aux1=aux1.getEnlace();
                contador1++;
            }
            aux3=aux1.getEnlace();
            while(contador2!=(pos2)){
                aux2=aux2.getEnlace();
                contador2++;
            }
            aux1.setEnlace(aux1.getEnlace().getEnlace());
            aux3.setEnlace(aux2.getEnlace());
            aux2.setEnlace(aux3);
        }
        //POS1 ES MAYOR QUE POS2, SIENDO MAYORES QUE 1
        if(pos1>1 && pos1>pos2){
            while(contador1!=(pos1-1)){
                aux1=aux1.getEnlace();
                contador1++;
            }
            while(contador2!=(pos2-1)){
                aux2=aux2.getEnlace();
                contador2++;
            }
            aux3=aux1.getEnlace();
            aux1.setEnlace(aux1.getEnlace().getEnlace());
            aux3.setEnlace(aux2.getEnlace());
            aux2.setEnlace(aux3);
        }
            
    }
    
    public void eliminarApariciones(Object elem) {
    Nodo aux1 = cabecera;
    Nodo aux2 = null;

    if (cabecera != null) {
        // Eliminar elementos al principio de la lista
        while (aux1 != null && aux1.getInformacion().equals(elem)) {
            cabecera = aux1.getEnlace();
            aux1 = cabecera;
        }

        // Eliminar elementos en otras posiciones de la lista
        while (aux1 != null) {
            if (aux1.getInformacion().equals(elem)) {
                aux2.setEnlace(aux1.getEnlace());
                aux1 = aux1.getEnlace();
            } else {
                aux2 = aux1;
                aux1 = aux1.getEnlace();
            }
        }
    }
}

            
    
}
