

public class Calculadora 
{
    private Fila filaNum;
    private Pilha pilhaOper;
    private String[] expressao;
    private int result;
    
 
    public Calculadora(String exp) throws Exception
    {   
        filaNum<String> =new Fila(100);
        pilhaOper<String>= new Pilha(100);
        
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
            throw new Exception("Sua express�o � invalida");
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
        if(nmr.matches("[0-9]"))
            return true;
        return false;
    }
    
    
    public void conversor(String expInf)throws Exception
    {   boolean verificado;
   
            if(isNumeros(expInf))
            filaNum.guarde(expInf);
            else{
                if(isOperadores(expInf)){
            verificado = verificacao(expInf);
            if(!verificado){
                pilhaOper.guarde(expInf);
            }
            else{
            filaNum.getItem(pilhaOper.getItem());
            pilhaOper.RemoveItem();
            pilhaOper.guarde(expInf);
        }
        }
        else
        throw new Exception("caracter inserido invalido!");
        }
        
        
    
    }

     public boolean verificacao(String caracter)throws Exception
     {  boolean posicao;
        String simbolo = "(^*/+-)"; 
        String pilha=pilhaOper.getItem();
        char lin, col;
   
     
        for(int a=0; a<=7;a++){
            int qual1= simbolo.indexOf(a);
            if(pilha==qual1)
            lin=(char)pilha;

        }
        for(int a=0; a<=7;a++){
            int qual2= simbolo.indexOf(a);
            if(caracter==qual2)
            col=(char)caracter;
        }
        posicao = Tabela.isParaDesempilhar(lin,col);
     
        return posicao;
    }

    public int calculadoraDeExpressao()
    {
        int num1;
        int num2;
        String operador;
        
        Pilha resultado = new Pilha(5);
        
        while (filaNum.length)
        {
           String pos=filaNum.PegaItem();
           if(!isOperadores(pos)){
           resultado.guarde(pos);
           filaNum.RemoveItem();
           }
           else
           {
           operador=pos;
           filaNum.RemoveItem();
           num2=(int)resultado.getItem();
           num1=(int)resultado.getItem();
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
        return  "O resultado da Express�o �: " + (this.result);

    }


}



