public class Fila <X>
{
    private Object[] fila;
    private int ultimo;
    private int primeiro= -1;

    public Fila (int tamanho) throws Exception
    {
        if(tamanho<1)
            throw new Exception ("Tamanho invalido");
        this.fila = new Object[tamanho];
        this.ultimo = this.fila[tamanho];
        this.primeiro = this.fila[0];
       
    }
    public void guarde(X x) throws Exception
    {
        if(x==null)
        throw new Exception("Informação ausente");

        if(this.ultimo==this.fila.lenght-1)
        throw new Exception("nao cabe mais nada");
        
          
        this.fila[this.ultimo]= x;
        
    }

    public void RemoveItem() throws Exception
    {
        if(this.primeiro==-1)
        throw new Exception ("Nada guardado");
        
        for(int i=0; i==this.fila.length-1; i++){
        this.fila[i]=this.fila[i+1];
        }
        this.ultimo--;
    }
    public X PegaItem() throws Exception
    {   if(this.fila[this.primeiro]==-1)
        throw new Exception("Nada guardado");


       return this.fila[primeiro];

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
        if (f.fila.length != this.fila.length)
        return false;
        for(int i=0; i<this.ultimo;i++)
            if(!this.fila[i].equals(fil.fila[i]))
            return false;

            return true;

     }