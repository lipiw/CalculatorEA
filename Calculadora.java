
public class Calculadora 
{
    private Fila filaNum;
    private PilhaS pilhaOper;
    private String[] expressao;
    
 
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

        else if (isOperadores(caracter[i])){
            if(isOperadores(caracter[i++]))
            throw new Exception("Operação invalida");
            
            caracter[i].verificacao();
        }
        
        
    }

     public void verificacao(String caracter)throws Exception
     {
        String[] expressoes;

        expressoes[0]="(";
        expressoes[1]="^";
        expressoes[2]="*";
        expressoes[3]="/";
        expressoes[4]="+";
        expressoes[5]="-";

        if(caracter==")")
        for(int a=0; a<expressao.length;a++){
            if(expressao[a]==expressoes[0])
            pilhaOper.guarde(caracter);
            throw new Exception("Operacao invalida");
        }

        for(int i=0; i<expresso.length; i++){
            if(caracter)
        }
    }

    public void cauculadoraDeExpressão(){
        int num1;
        int num2;
        String operador;

        PilhaS resultado = new PilhaS(5);

        for(int i=0;i<this.expressao.length;i++){
           if(!isOperadores(expressao[i]))
           resultado.guarde(expressao[i]);

           else
           {
           operador=expressao[i];
           num2=(int)resultado.getItem();
           num1=(int)resultado.getItem();
           resultado.guarde(fazerContas(num1, num2, operador));
           }
        }



    }
    public int fazerContas(int val1, int val2, String oper){
        int result;
        
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

        return result;
    }
    public String toString()
    {
        return ;//o "?" funciona como uma condicional, com as opções de condição separados por ":"

    }
    public int hashCode(){
        int ret=7;//não pode ser zero

        ret=ret*17+...;//um numero primo qualquer
        ret=ret*17+...;
        ret=ret*17+...;
        ret=ret*17+...;
        ret=ret*17+...;
        ret=ret*17+...;
        ret=ret*17+...;
        ret=ret*13+...;
        ret=ret*13+...;
        ret=ret*13+...;
        ret=ret*17+...;
        ret=ret*17+...;
        ret=ret*17+...;

    }

}



