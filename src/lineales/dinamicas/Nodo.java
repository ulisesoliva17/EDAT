package lineales.dinamicas;

class Nodo {
    //es la variable que tiene el contenido 
   Object informacion;
   //es un apuntador al siguiente nodo
   Nodo enlace;
    
   public Nodo (Object valor ){
       informacion = valor;
       enlace = null;
   }
   
   public Nodo (Object valor, Nodo elem){
       informacion = valor;
       enlace = elem;
   }
   //Setters
   public void setElem(Object elem){
        informacion = elem;
    }
    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }
    //Getters
    public Object getInformacion(){
        return informacion;
    }
    public Nodo getEnlace(){
        return enlace;
    }

}
