public class Calculadora 
{
    private Fila filaNum;
    private PilhaS pilhaOper;
    private String[] expressao;
    private int result;
    
 
    public Calculadora(String exp) throws Exception
    {   
        filaNum =new Fila();
        pilhaOper= new PilhaS(20);
        
        exp = exp.replaceAll(" ","");
        
        int a=0;
        StringTokenizer quebrador = new StringTokenizer (exp, "+-*/^()", true);
        while(exp.quebrador.hasMoreTokens())
        {
            expressao[a]=exp;
            exp.quebrador.nextToken();
            a++;
        }
        
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
            throw new Exception("Sua expressão é invalida");
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
    {
        String item;
        String[] caracter = expInf.split(" ");

        for(int i; i<expInf.length();i++)
            if(isNumeros(caracter[i]))
            filaNum.guarde(caracter[i]);

        
            
            caracter[i].verificacao(caracter[i]);
        
        
        
    }

     public void verificacao(String caracter)throws Exception
     {  boolean posicao;
        String simbolo = "(^*/+-)"; 
        String pilha=pilhaOper.getItem();
        String 
        int lin=simbolo.indexOf();
        int col=simbolo.indexOf();
        for(int e=0; e<lin.length; i++ ){

        posicao = Tabela.isParaDesempilhar();
        
      

    }

    public int calculadoraDeExpressão(){
        int num1;
        int num2;
        String operador;
        
        PilhaS resultado = new PilhaS(5);
        
        while(filaNum.length)
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
        return calculadoraDeExpressão();//o aaaaaaaaa "?" funciona como uma condicional, com as opções de condição separados por ":"

    }


}



