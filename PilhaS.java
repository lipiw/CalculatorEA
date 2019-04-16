import com.sun.java.util.jar.pack.Package.Class.Method;

public class Pilha <X>//cria um parametro para classe, sendo ele de qualquer tipo.
{
    private Object[] vetor;
    private int ultimo;//marca o ultimo item do vetor

    public Pilha (int tamanho) throws Exception
    {
        if(tamanho<1)
            throw new Exception ("Tamanho invalido");
        this.vetor = new Object[tamanho];

    }

    public void guarde (X x) throws Exception
    {
        if(x==null)
        throw new Exception("Informacao ausente");

        if(this.ultimo==this.vetor.lenght-1)
        throw new Exception ("nao cabe mais nada");

    this.ultimo++;
    this.vetor[this.ultimo]= x;
    }

    public Object getItem() throws  Exception
    {
        if(this.ultimo==-1)
            throw new Exception ("Nada guardado");

        return (X)this.vetor[this.ultimo];
    }
    
    public void removaItem() throws  Exception
    {
        if(this.ultimo==-1)
            throw new Exception ("Nada guardado");

        this.vetor[this.ultimo]= null;//pode colocar nulo pois é um vetor
        this.ultimo--;//removendo a posição acessivel do vetor
    }
    public String toString()
    {
        return (this.ultimo+1)+" elementos"+ (this.ultimo!=-1?" sendo o ultimo "+ this.vetor[this.ultimo]:"");//o "?" funciona como uma condicional, com as opções de condição separados por ":"

    }
    //serve para comparar this com obj
    
     // DEVO criar objetos iguais para objetos que o .equals() considere iguais 
     // PROCURO gerar hashCodes diferentes para objetos que o .equals() diz ser diferente
     public int hashCode(){
        int ret=7;//não pode ser zero

        ret=ret*17+2;//um numero primo qualquer
        ret=ret*17+1;
        ret=ret*17+3;
        ret=ret*17+5;
        ret=ret*17+7;
        ret=ret*17+11;
        ret=ret*17+1;
        ret=ret*13+5;
        ret=ret*13+23;
        ret=ret*13+1;
        ret=ret*17+2;
        ret=ret*17+7;
        ret=ret*17+7;

    }
    public Object Clone ()
    {
        Pilha<X> ret=null;

        try
        {
            ret = new Pilha<X> (this);
        }
        catch (Exception erro)
        {} // sei que nao vai dar erro

        return ret;
    }

    public X meuCloneDeX(X x){
        //retun x.clone();
        X ret=null;
try{
    Class<> classe= x.getClass();//pego a classe do parametro
    Class<> tipos = null;//sem paramtro
    Method motodo = classe.getMethod("clone", tipos);//pegar o metodo da classe do objeto x
    Object[] parametros =null;//não tem parametro
    ret =(X)metodo.invoke(x,parametros);

    }
    
catch(Exception erro)
{}
    return ret;
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
        Pilha<X> pil =(Pilha<X>)obj;
        if(this.ultimo!=pil.ultimo)
        return false;
        for(int i=0; i<this.ultimo;i++)
            if(!this.vetor[i].equals(pil.vetor[i]))
            return false;

            return true;

     }
}