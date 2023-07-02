package testt;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;
import lineales.dinamicas.Cola;


/**
 *
 * @author ulise
 */
public class testLista {
    public static void main(String[] args) {
        Cola q= new Cola();
        q.poner("A");
        q.poner("B");
        q.poner("#");
        q.poner("C");
        q.poner("#");
        q.poner("D");
        q.poner("E");
        q.poner("F");
        Cola w= genera(q);
        System.out.println(w.toString());
    }
    private static void ponerEnColaNueva(Pila temp1, Cola temp2,Cola res){
        String text="";
        while(!temp2.esVacia()){
            Object f=temp2.obtenerInicio();
            Object t=temp1.obtenerTope();
            text+=f.toString()+t.toString()+f.toString();
            temp2.sacar();
            temp1.desapilar();
        }
        res.poner(text+"#");
    }
    public static Cola genera(Cola c1){
        Cola res=new Cola();
        Pila temp1=new Pila();
        Cola temp2=new Cola();
        while(!c1.esVacia()){
            Object elemento= c1.obtenerInicio();
            if(!elemento.equals("#")){
                temp1.apilar(elemento);
                temp2.poner(elemento);
                
            }else{
                ponerEnColaNueva(temp1,temp2,res);
                temp1.vaciar();
                temp2.vaciar();
        }
            c1.sacar();
    }
        if(!temp1.esVacia()){
            ponerEnColaNueva(temp1,temp2,res);
        }
        return res;
    }
}
