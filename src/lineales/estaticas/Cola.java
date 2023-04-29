package lineales.estaticas;


// COLA ESTATICA

public class Cola {
    private int frente;
    private int fin;
    private Object datos[];
    private final int  tamanio=10;
    
         //----------------------------------------------------------------------------------------------------------------------------------------
    
          public Cola(){
          frente=0;
          fin=0;
          datos= new Object [tamanio];
         }

         //----------------------------------------------------------------------------------------------------------------------------------------
     
     
        public boolean estaLlena(){
            boolean resultado =false;
            if(datos[(fin+1)%tamanio]==datos[frente]){
                resultado=true;
            }
            return resultado;
        }
    
         //----------------------------------------------------------------------------------------------------------------------------------------
    
        public boolean esVacia(){
            boolean resultado=false;
            if(frente==fin){
                resultado=true;
            }
            return resultado;
        }
    
         //----------------------------------------------------------------------------------------------------------------------------------------
    
        public boolean poner(Object elemento){
            boolean resultado=false;
            boolean lleno;
            lleno = ((fin + 1) % tamanio) == frente;
            if(!lleno){
            //if (!((fin + 1) % TAMANIO==frente)) {
                datos[fin] = elemento ;
                fin = (fin + 1) % tamanio; 
                //frente = (frente+1) % TAMANIO;
                resultado=true;
            }

            return resultado;
        }
    
         //----------------------------------------------------------------------------------------------------------------------------------------

            public String toString() {
            int i = this.frente;
            String cadena ="[| ";
            while (i != fin) {
                cadena = cadena + this.datos[i] + " | ";
                i=(i+1)%10;
            }
            cadena = cadena + " ]";
            return cadena;
        }
        
         //----------------------------------------------------------------------------------------------------------------------------------------
        
        public Object obtenerInicio(){
            Object resultado=null;
            resultado=datos[frente];
            return resultado;
        }
        
        
         //----------------------------------------------------------------------------------------------------------------------------------------
       
        //elimina el elemento que esta en el inicio, y luego al inicio le asigna el elemento que estaba despues de el
        public boolean sacar(){
            boolean exito=true;
            if(esVacia()){
                exito=false;
            }else{
                datos[frente]=null;
                frente=(frente+1)%tamanio;
            }
            return exito;
        }
        
        
         //----------------------------------------------------------------------------------------------------------------------------------------
       
        //Como es un arreglo, entonces a cada posicion del arreglo se le asigna null
        public void vaciar(){
        for (int i = 0; i < this.datos.length; i++) {
            this.datos[i]=null;
            }
        }
        
         //----------------------------------------------------------------------------------------------------------------------------------------
       
        //clona todos los datos, uno por uno del arreglo y luego asigna inicio y fin como en la cola original
        public Cola clone() {
        Cola colaClon = new Cola();
        if(!esVacia()){
            int i = frente;
            while (i !=fin) {
                colaClon.datos[i]=datos[i];
                i=(i+1)%10;
            }
        }
        colaClon.frente = frente;
        colaClon.fin= fin;        
        return colaClon;
    }
}
