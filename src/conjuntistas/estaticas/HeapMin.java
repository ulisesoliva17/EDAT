package conjuntistas.estaticas;

/**
 *
 * @author ulise
 */
public class HeapMin {
    
    public Comparable[] heap;
    private int ultimo;
    private int TAMANIO=20;
    
    public HeapMin(){
        heap = new Comparable[TAMANIO];
        ultimo=0;
    }
    //------------------------------------------------------------------------------------------------------
    public boolean eliminarCima(){
        boolean exito;
        if(ultimo==0){
            //Estructura vacia
            exito=false;
        }else{
            //saca la raiz y pone la ultima hoja en su lugar
            heap[1]=heap[ultimo];
            ultimo--;
            //reestablece la propiedad de heap minimo
            hacerBajar(1);
            exito=true;
        }
        return exito;
    }
   //-------------------------------------------------------------------------------------------------------
    private void hacerBajar(int posPadre){
        int posH;
        Comparable temp = heap[posPadre];
        boolean salir=false;
        while(!salir){
            posH=posPadre*2;
            //acceso al hijo
            if(posH<=ultimo){
                //temp tiene al menos un hijo(izq) y lo considera menor
                if(posH<ultimo){
                    //hijo menor tiene hermano derecho
                    if(heap[posH+1].compareTo(heap[posH])<0){
                        //el hijo derecho es el menor de los dos
                        posH++;
                    }
                }
                //compara al hijo menor con el padre
                if(heap[posH].compareTo(temp)<0){
                    //el hijo es menor que el padre, los intercambia
                    heap[posPadre]= heap[posH];
                    heap[posH]=temp;
                    posPadre=posH;
                }else{
                    //el padre es menor que sus hijos, esta bien ubicado
                    salir=true;
                }
            }else{
                //el temp es hoja, esta bien ubicado
                salir=true;
            }
        }
    }
    
 //------------------------------------------------------------------------------------------------------
    public boolean insertar(Comparable elem) {
        // Inserta un elemento en el árbol.
        boolean exito = false;
        if (this.TAMANIO > this.ultimo + 1) {
            this.heap[this.ultimo + 1] = elem;
            this.ultimo++;
            hacerSubir(ultimo);
            exito = true;
        }
        return exito;
    }
     //-------------------------------------------------------------------------------------------------------
    
      private void hacerSubir(int posHijo) {
        int posPadre;
        Comparable temp = this.heap[posHijo];
        boolean salir = false;
        while (!salir) {
            posPadre = posHijo / 2;
            if (this.heap[1].compareTo(this.heap[posHijo]) == 0) {
                salir = true;
            } else if (this.heap[posHijo].compareTo(this.heap[posPadre]) > 0) {
                salir = true;
            } else {
                temp = this.heap[posPadre];
                this.heap[posPadre] = this.heap[posHijo];
                this.heap[posHijo] = temp;
                posHijo = posHijo / 2;
            }
        }
    }
      
       //------------------------------------------------------------------------------------------------------
         public Comparable recuperarCima() {
        // Recupera el elemento de la cima del árbol.
        Comparable exito = null;
        if (!esVacio()) {
            exito = this.heap[1];
        }
        return exito;
    }

    public boolean esVacio() {
        // Indica si el árbol está vacío.
        return this.ultimo == 0;
    }

    public void vaciar() {
        // Vacía el árbol.
        this.ultimo = 0;
    }
     //-------------------------------------------------------------------------------------------------------

    public String toString() {
        String cadena = "ESTRUCTURA VACIA";
        if (!esVacio()) {
            cadena = "";
            for (int i = 1; i <= this.ultimo; i++) {
                cadena += this.heap[i] + "\t-->";
                if (i * 2 < this.ultimo) {
                    // hay hijo izquierdo
                    cadena += "HI: " + this.heap[2 * i];
                    if (i * 2 + 1 < this.ultimo) {
                        // hay hijo derecho
                        cadena += "\tHD: " + this.heap[(2 * i) + 1] + "\n";
                    } else {
                        // no hay hijo derecho
                        cadena += "\n";
                    }
                } else {
                    // no hay hijo izquierdo
                    cadena += "\n";
                }
            }
        }
        return cadena;
    }
      
}
