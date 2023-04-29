
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
                contador=+1;
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
    
    
}
    


