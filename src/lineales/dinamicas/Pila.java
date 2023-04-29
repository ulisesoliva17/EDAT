package lineales.dinamicas;
import javax.swing.JOptionPane;
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
        Nodo aux;
    
        if(tope!=null){
            aux=tope.getEnlace();
            tope=aux;
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
        //while(!esVacia()){
         //    desapilar();
      //  }
      tope = null;
      //asignando nulo al tope, rompe con el enlace y con la informacion que tiene el ultimo nodo, por ende, queda vacia la pila
    }
    
    //Mostrar el contenido de la pila
    public void mostrarPila(){
        String lista = " ";
        Nodo recorrido = tope;
        while(recorrido!=null){
            lista += recorrido.informacion+"\n";
            recorrido = recorrido.enlace;
    }
        JOptionPane.showMessageDialog(null, lista);
        lista = "";
    }
    //Clona la pila
    public Pila clonar(){
        Pila clonada = new Pila ();
        Nodo aux = tope;
        while (aux != null){
            clonada.tope = new Nodo (tope.getInformacion(), (Nodo) tope.getEnlace());
            aux = (Nodo) aux.getEnlace();
        }
        return clonada;
    }

//  if(this.tope != null){
 //      nuevaPila.setElem(this.tope.getElem());
    }


