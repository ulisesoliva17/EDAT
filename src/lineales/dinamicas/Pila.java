package lineales.dinamicas;
import lineales.dinamicas.Nodo;
    public class Pila {
 
    private Nodo tope;
    private int tamanio=0;
    //private String lista = " ";
    
    public Pila(){
        tope= null;
        tamanio  = 0;
    }
    
    //conocemos si la pila esta vacia. Preguntando si el tope es nulo, ya que de esa forma sabemos que no hay elementos 
    public boolean esVacia(){
        return tope==null;
    }
    
    //Metodo para insertar un nodo en la pila
    public void apilar(Object unNuevoElemento){
        Nodo nuevoElemento= new Nodo(unNuevoElemento);
        //el enlace del nuevo nodo se tiene que referenciar al tope viejo, que es todo el nodo viejo que estara debajo de el
        nuevoElemento.enlace= tope;
        //El tope posee el nuevo elemento que ingreso el usuario
        tope = nuevoElemento;
        //Esta variable debe aumentar ya que hay un nuevo elemento en la pila
        tamanio++;
    }
    
    
    //desapila el ultimo elemento de la pila
    public boolean desapilar(){
        boolean respuesta=true;
        
        if(tope!=null){
         //A tope le asignamos el anteultimo elemennto. Sin romper nada, solo borrando el ultimo.
            tope=tope.getEnlace();
        }else{
            respuesta=false;
        }
        return respuesta;
    }
    
    
    public Object obtenerTope(){
        return tope.getInformacion();
    }
    
    public int tamanioPila(){
        return tamanio;
    }
    
    //Vaciar totalmente la pila
    public void vaciarTotalPila(){
      tope = null;
      //asignando nulo al tope, rompe con el enlace y con la informacion que tiene el ultimo nodo, por ende, queda vacia la pila
    }
    
    //Mostrar el contenido de la pila
    public String toString(){
        String salida = " ";
        Nodo aux = tope;
        while(aux!=null){
            salida = salida+"\n" + aux.getInformacion().toString();
            aux = aux.getEnlace();
        }
        return salida;
    }
    
    //Clona la pila
    public Pila clonar(){
        Pila clon = new Pila ();
        Nodo aux = tope;
        while (aux != null){
            clon.tope = new Nodo (tope.getInformacion(), tope.getEnlace());
            aux = aux.getEnlace();
        }
        return clon;
    }
//    Inicio del método clonar()
    //Ejemplo con esta pila:
//tope = 8 -> 7 -> 3 -> null
//Creación del objeto clon de la clase Pila
//Creación del objeto aux de la clase Nodo y se le asigna la referencia al nodo en el tope de la pila original (nodo con valor 8)
//Comienzo del bucle while (aux != null)
//    Creación de un nuevo objeto Nodo con la información y enlace del nodo en el tope de la pila original (nodo con valor 8)
//    Asignación del nuevo nodo creado como el nuevo tope de la pila clonada (clon.tope)
//    Actualización de aux con el enlace al siguiente nodo en la pila original (nodo con valor 7)
//    Comienzo de la siguiente iteración del bucle while (aux != null)
//        Creación de un nuevo objeto Nodo con la información y enlace del nodo en el tope de la pila original (nodo con valor 7)
//        Asignación del nuevo nodo creado como el nuevo tope de la pila clonada (clon.tope)
//        Actualización de aux con el enlace al siguiente nodo en la pila original (nodo con valor 3)
//        Comienzo de la siguiente iteración del bucle while (aux != null)
//            Creación de un nuevo objeto Nodo con la información y enlace del nodo en el tope de la pila original (nodo con valor 3)
//            Asignación del nuevo nodo creado como el nuevo tope de la pila clonada (clon.tope)
//            Actualización de aux con el enlace al siguiente nodo en la pila original (null)
//            Fin del bucle while (aux == null)
//Fin del método clonar()
//Retorno del objeto clon

    }


