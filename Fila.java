
public class Fila <X>
{
	private Object[] vetor;
	private int inicio=0, fim=0, qtd=0;

	public Fila (int tamanho) throws Exception
	{
		if (tamanho<1)
		    throw new Exception ("Tamanho invalido");

		this.vetor = new Object [tamanho];
	}

	public void guarde (X x) throws Exception
	{
		if (x==null)
		    throw new Exception ("Informacao ausente");

		if (this.qtd == this.vetor.length)
		    throw new Exception ("Nao cabe mais nada");

		this.vetor[this.fim] = x;
		this.fim = this.fim<this.vetor.length?this.fim+1:0;
		this.qtd++;
	}

	public X getItem () throws Exception
	{
		if (this.qtd==0)
		    throw new Exception ("Nada guardado");

		return (X)this.vetor[this.inicio];
	}

	public void removaItem () throws Exception
	{
		if (this.qtd==0)
		    throw new Exception ("Nada guardado");

		this.vetor[this.inicio] = null;
		this.inicio = this.inicio<this.vetor.length?this.inicio+1:0;
		this.qtd--;
	}
public int Tamanho()
{
    return qtd;
}
    // repensar toString, equals e hashCode
}