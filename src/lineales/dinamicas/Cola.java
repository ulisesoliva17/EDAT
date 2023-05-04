package lineales.dinamicas;
import javax.swing.JOptionPane;
import lineales.dinamicas.Nodo;

    // COLA DINAMICA

        public class Cola{
            private Nodo frente;
            private Nodo fin;

         //----------------------------------------------------------------------------------------------------------------------------------------
        
        public Cola( ){
        frente=null;
        fin=null;
        }
        
         //----------------------------------------------------------------------------------------------------------------------------------------
        public  boolean esVacia(){
            boolean resultado=false;
            if(frente==null){
                resultado=true;
                }
            return resultado;
        }
        
         //----------------------------------------------------------------------------------------------------------------------------------------
        
        public boolean poner(Object elem){
            boolean resultado=false;
            Nodo noditoNuevo= new Nodo(elem, null);
                if(esVacia()){
                        frente=noditoNuevo;
                        fin=noditoNuevo;
                        resultado=true;
                }else{
                        fin.setEnlace(noditoNuevo);
                        fin=noditoNuevo;
            }
            return resultado;
        }
         //----------------------------------------------------------------------------------------------------------------------------------------
        
        public boolean sacar(){
        boolean exito = true;
            if(frente == null){
                    //La cola esta vacia, reporta error
                    exito = false;
            }else{
                    //al menos hay un elemento
                    //quita el primer elemento y actualiza frente con el nodo que tiene atras
                    //Asigna fin = null si el frente es nulo, es decir, si esta vacia
                    frente = frente.getEnlace();
                        if(frente == null){
                                  fin = null;
                        }
            }
        return exito;
        }
        
         //----------------------------------------------------------------------------------------------------------------------------------------
        
        public void vaciar(){
            frente=null;
            fin=null;
        }
         //----------------------------------------------------------------------------------------------------------------------------------------
        
        public Object obtenerInicio(){
            Object resultado;
            if(esVacia()){
                resultado= null;
            }else{
            resultado=frente.getInformacion();
            }
            return resultado;
        }
        //----------------------------------------------------------------------------------------------------------------------------------------
       
        public void mostrarCola(){
            Nodo recorrido=frente;
            String colaInvertida="";
            String cola="";
                while(recorrido!=null){
                    cola+=recorrido.informacion+" ";
                    recorrido= recorrido.enlace;
                }
            String cadena[]= cola.split(" ");
                for(int i=0; i<=cadena.length-1; i++){
                    colaInvertida+= " "+ cadena[i];
                }
            JOptionPane.showMessageDialog(null, colaInvertida);
            cola="";
        }
         //----------------------------------------------------------------------------------------------------------------------------------------
        
        public String toString() {
               String cadena = "";
               Nodo temp = this.frente;
               while (temp != null) {
                   cadena = cadena + temp.getInformacion();
                   temp = temp.getEnlace();
               }
               cadena = cadena;
               return cadena;
           }
        
        
         //----------------------------------------------------------------------------------------------------------------------------------------
       
       public Cola clone() {
        Cola colaClon = new Cola();
        if (!esVacia()) {
            Nodo aux1 = frente;
            Nodo aux2 = new Nodo(aux1.getInformacion(), null);// el primer elemento del clon lo creo con el getElem del frente original
            colaClon.frente = aux2;
            while (aux1.getEnlace() != null) {  // se saca el elemento del frente y se asocia frente al siguiente, y el frente original es el nuevo nodo de la cola clonada
                aux1 = aux1.getEnlace(); // itero el aux1 
                Nodo nuevo = new Nodo(aux1.getInformacion(), null); // creo el nodo con el elemento correspondiente de la original
                aux2.setEnlace(nuevo);  //engancho el aux con el nodo nuevo 
                aux2 = aux2.getEnlace(); // itero el aux2
            }
            colaClon.fin = aux2;
        }
        return colaClon;
    }
        //----------------------------------------------------------------------------------------------------------------------------------------
       public boolean verificarBalanceo(Cola q){
           Pila p1= new Pila();
           Nodo puntero = q.frente;
           boolean rta=false;
           
           while(puntero!=null){
               if(puntero.getInformacion().equals("{") ||puntero.getInformacion().equals("[")||puntero.getInformacion().equals("(") ){
                   p1.apilar(puntero.getInformacion());
               }
               
               if(puntero.getInformacion().equals("}")){
                   if(p1.obtenerTope().equals("{")){
                       p1.desapilar();
                   }
               }
               
               if(puntero.getInformacion().equals("]")){
                   if(p1.obtenerTope().equals("[")){
                       p1.desapilar();
                   }
               }
               
               if(puntero.getInformacion().equals(")")){
                   if(p1.obtenerTope().equals("(")){
                       p1.desapilar();
                   }
               }
               if(puntero.getInformacion().equals(null)){
                   rta=false;
               }
               
              puntero = puntero.getEnlace();
                  
           }
           if(p1.esVacia()){
               rta=true;
           }
           return rta;
       }
}

    
