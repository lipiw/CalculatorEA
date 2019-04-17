import java.lang.reflect.*;

public class Fila <X>
{
    private Object[] fila;
    private int ultimo;
    private int primeiro= -1;

    public Fila (int tamanho) 
    {
        this.fila = new Object [tamanho];
        this.ultimo = tamanho;
        this.primeiro = (int) this.fila[0];
       
    }

    public int getTamanho()
    {
        return ultimo + 1;
    }

    public void guarde(X x) 
    {
        this.fila[this.ultimo]= x;
    }

    public void RemoveItem() 
    {

        for(int i=0; i==this.fila.length-1; i++)
        
        this.fila[i]=this.fila[i+1];
        
        this.ultimo--;
    }
    
    public X PegaItem() 
    {   
       return (X) this.fila[primeiro];
    }
    
    public String toString()
    {
        return (this.ultimo+1)+" elementos"
        + (this.ultimo!=-1?" sendo o ultimo "
        + this.fila[this.ultimo]:"")+"e o primeiro é"+(this.fila[primeiro]);//o "?" funciona como uma condicional, com as opções de condição separados por ":"

    }
    public boolean equals (Object obj)
    {      
        if(this==obj)
            return true;

        if(obj==null)
            return false;
        if(this.getClass()!= obj.getClass())
            return false;
        /*
        if(this.ultimo !=((Pilha<X>obj).ultimo))
        return false;
        if(int i=0; i<this.ultimo; i++)
        return false;
        */
        Fila<X> fil =(Fila<X>)obj;
        if(this.primeiro!=fil.primeiro)
        return false;
        if(this.ultimo!=fil.ultimo)
        return false;
        if (this.fila.length != this.fila.length)
        return false;
        for(int i=0; i<this.ultimo;i++)
            if(!this.fila[i].equals(fil.fila[i]))
            return false;

            return true;

     }
    }