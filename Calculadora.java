
import java.util.StringTokenizer;

public class Calculadora
{
    private Fila<String> filaNum;
    private Pilha<String> pilhaOper;
    private String[] expressao;
    private Double result;

    
 
    public Calculadora(String exp) throws Exception
    {   
        filaNum = new Fila<String>(100);
        pilhaOper = new Pilha<String>(100);
        expressao = new String[50];
        
        exp = exp.replaceAll(" ","");
        
        int a=0;
        StringTokenizer quebrador = new StringTokenizer (exp, "+-*/^()", true);
        String pedacoAtual = "";
        while(quebrador.hasMoreTokens())
        {
            //pedacoAtual = quebrador.nextToken();
            expressao[a]=quebrador.nextToken();
            conversor(expressao[a]);
            a++;
        }

        calculadoraDeExpressao();
        
        
    }

    public static boolean valida(String expressao)throws Exception
    {
        int parenteses = 0;
            
            for(int i=0; i<expressao.length(); i++)
            {
                if(expressao.charAt(i) == '(')
                parenteses++;
                
                if(expressao.charAt(i) == ')')
                parenteses--;
            }
        
        if(parenteses!=0)
            throw new Exception("Sua expressao e invalida");
        
        return true;
    }

    public boolean isOperadores (String op)
    {   
        if(op.matches("[^|*|/|+|-]"))
            return true;
        return false;
    }
    
    public boolean isNumeros(String nmr)
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
   
            if(isNumeros(expInf))   //se � numero guarde na fila de numeros
            filaNum.guarde(expInf);
     
            else
            {
                if(isOperadores(expInf)){           //se
                verificado = verificacao(expInf);

                while (verificado)
                {
                    filaNum.guarde(pilhaOper.getItem());
                    pilhaOper.removaItem();

                    verificado = verificacao(expInf);
                }

                pilhaOper.guarde(expInf);
            }
            else
                throw new Exception("Caracter inserido invalido!");
        }
    }

     public boolean verificacao(String caracter)throws Exception
     { 
        //String simbolo = "(^*/+-)"; 
        String pilha=this.pilhaOper.getItem();  //ultimo da pilha

        char doTopo = pilha.charAt(0);
        char doStrTok = caracter.charAt(0);

        /*char lin, col;
        String qual1, qual2;
        for(int a=0; a<=6;a++)
        {
            qual1= simbolo.indexOf(a);
            qual2= simbolo.indexOf(a);
            if(pilha==qual1){
            lin=pilha.charAt(0);
            
            }
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
            
        */
     
        return Tabela.isParaDesempilhar(doTopo,doStrTok);
    }

    public Double calculadoraDeExpressao()
    {
        Double num1;
        Double num2;
        String operador;
        
        Pilha<Double> resultado=  new Pilha<>(5);
        for(int i=0;i>=filaNum.getTamanho();i++)
        {
           String pos=filaNum.PegaItem();
            
           if(!isOperadores(pos))
           {
           resultado.guarde(Double.parseDouble(pos));
           filaNum.RemoveItem();
           }
            
           else
           {
           operador=pos;
           filaNum.RemoveItem();
           num2=resultado.getItem();
           num1=resultado.getItem();
           resultado.guarde(fazerContas(num1, num2, operador));
            }
            
        }
        return resultado.getItem();
    }
    
    public double fazerContas(Double val1, Double val2, String oper){
       
        
        if(oper=="^")
        result=Math.pow(val1,val2);
        
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
