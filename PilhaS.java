public class PilhaS <String> {
    
	private String[] vetor;
	private int ultimo=-1;

	public Pilha (int tamanho) throws Exception
	{
		if (tamanho<1)
		    throw new Exception ("Tamanho invalido");

		this.vetor = new Object [tamanho];
	}

    public X meuCloneDeX (X x)
    {
	    X ret=null;

		try
		{
			Class<?> classe = x.getClass();
			Class<?>[] tipos = null; 
			Method metodo = classe.getMethod ("clone", tipos);
			Object[] parametros = null; 
			ret=(X)metodo.invoke(x,parametros);
        }
		catch (Exception erro)
		{} 

		return ret;
	}


	public void guarde (X x) throws Exception
	{
		if (x==null)
		    throw new Exception ("Informacao ausente");

		if (this.ultimo == this.vetor.length-1)
		    throw new Exception ("Nao cabe mais nada");

		this.ultimo++;

        if (x instanceof Cloneable)
		    this.vetor[this.ultimo] = meuCloneDeX(x);
		else
		    this.vetor[this.ultimo] = x;
	}

	public X getItem () throws Exception
	{
		if (this.ultimo==-1)
		    throw new Exception ("Nada guardado");

        if (this.vetor[this.ultimo] instanceof Cloneable)
		    return meuCloneDeX ((X)this.vetor[this.ultimo]);
		else
		    return (X)this.vetor[this.ultimo];
	}


	public void removaItem () throws Exception
	{
		if (this.ultimo==-1)
		    throw new Exception ("Nada guardado");

		this.vetor[this.ultimo] = null;
		this.ultimo--;
	}

   
	public String toString ()
	{
		     
	}

   
    public boolean equals (Object obj)
    {
		if (this==obj)
		    return true;

		if (obj==null)
		    return false;

		if (this.getClass() != obj.getClass())
		    return false;
	
		Pilha<X> pil = (Pilha<X>)obj;

		if (this.ultimo != pil.ultimo)
			return false;

		for (int i=0; i<this.ultimo; i++)
			if (!this.vetor[i].equals(pil.vetor[i]))
				return false;

		return true;
	}

   
	public int hashCode ()
	{
		int ret=1;

		for (int i=0; i<=this.ultimo; i++)
    		ret = ret*2 + this.vetor[i].hashCode();

		ret = ret*2 + new Integer (this.ultimo).hashCode();

		return ret;
	}

  
    public Pilha (Pilha<X> modelo) throws Exception 
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        this.vetor = new Object [modelo.vetor.length];

        for (int i=0; i<=modelo.ultimo; i++)
            this.vetor[i] = modelo.vetor[i];

        this.ultimo = modelo.ultimo;
    }

    
    public Object Clone ()
    {
        Pilha<X> ret=null;

        try
        {
            ret = new Pilha<X> (this);
        }
        catch (Exception erro)
        {} 

        return ret;
    }
   
}