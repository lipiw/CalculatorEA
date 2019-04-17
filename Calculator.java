public class Calculator
{
    private Fila filaNum;
    private Pilha pilhaOper;
    private String[] expressao;
    private int result;

    
 
    public Calculator(String exp) throws Exception
    {   
        

       Pilha<String> p1 = new Pilha<String>();
       Pilha<Double> resultado = new Pilha<Double>();
       
       
        filaNum = new Fila(100);
        pilhaOper = new Pilha(100);
        
        exp = exp.replaceAll(" ","");
        
        int a=0;
        StringTokenizer quebrador = new StringTokenizer (exp, "+-*/^()", true);
        while(exp.quebrador.hasMoreTokens())
        {
            expressao[a]=exp;
            conversor(expressao[a]);
            exp.quebrador.nextToken();
            a++;
        }

        filaNum.calculadoraDeExpressao();
        
        
    }

    public static boolean valida(String expressao)throws Exception
    {
        int parenteses = 0;
            
            for(int i=0; i<expressao.length(); i++)
            {
                if(expressao.charAt(i) == "(")
                parenteses++;
                
                if(expressao.charAt(i) == ")")
                parenteses--;
            }
        
        if(parenteses!=0)
        {
            return false;
            throw new Exception("Sua expressao e invalida");
        }

        else
        return true;
    }

    public boolean isOperadores (String op)
    {   
        if(op.matches("[^|*|/|+|-]"))
            return true;
        return false;
    }
    
    public boolean isNumero (String nmr)
    {
        try
        {
            Double.parseDouble(nmr);
            return true;
        }
        catch (NumberFormatException erro)
        {
            return false;
        }    
    }
    
    
    public void conversor(String expInf)throws Exception
    {   
        boolean verificado;
   
            if(isNumeros(expInf))   //se é numero guarde na fila de numeros
            filaNum.guarde(expInf);
     
            else
            {
            if(isOperadores(expInf)){           //se
            verificado = verificacao(expInf);
                
            if(!verificado)
            {
                pilhaOper.guarde(expInf);
            }
                    
            else
            {
            filaNum.getItem(pilhaOper.getItem());
            pilhaOper.RemoveItem();
            pilhaOper.guarde(expInf);
            }
        }
                
        else
        throw new Exception("Caracter inserido invalido!");
        }
    }

     public boolean verificacao(String caracter)throws Exception
     { 
        boolean posicao;
        String simbolo = "(^*/+-)"; 
        String pilha=this.pilhaOper.getItem();

        char lin, col;
        string qual1, qual2;
        for(int a=0; a<=6;a++)
        {
            qual1= simbolo.indexOf(a);
            
            if(pilha==qual1)
            lin=pilha.charAt(0);
        }
      
        for(int a=0; a<=6;a++)
        {
            qual2= simbolo.indexOf(a);
            
            if(caracter!=simbolo.indexOf(6))
            {
                
            if(caracter==qual2)
                col=caracter.charAt(0);
            }
            
            else
            {
            if(pilha==simbolo.indexOf(0))
            pilhaOper.removaItem();

            col=caracter.charAt(0);
            }
            
        }
        posicao = Tabela.isParaDesempilhar(lin,col);
     
        return posicao;
    }

    public int calculadoraDeExpressao()
    {
        int num1;
        int num2;
        String operador;
        String resultado;
        
        while (filaNum.length)
        {
           String pos=filaNum.PegaItem();
            
           if(!isOperadores(pos))
               
           {
           resultado.guarde(pos);
           filaNum.RemoveItem();
           }
            
           else
           {
           operador=pos;
           filaNum.RemoveItem();
           num2=(double)resultado.getItem();
           num1=(double)resultado.getItem();
           resultado.guarde(fazerContas(num1, num2, operador));
            }
        
       
            this.result=resultado.getItem();
            return this.result;

        }
    }
    
    public int fazerContas(int val1, int val2, String oper){
       
        
        if(oper=="^")
        result=val1^val2;
        
        else if(oper=="*")
        result=val1*val2;
        
        else if(oper=="/")
        result=val1/val2;
        
        else if(oper=="+")
        result=val1+val2;
        
        else if(oper=="-")
        result=val1-val2;

        return this.result;
    }
    public String toString()
    {
        return  "O resultado da Expressao e: " + (this.result);

    }


}



