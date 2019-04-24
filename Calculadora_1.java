
import java.util.StringTokenizer;

public class Calculadora_1
{
    private Fila<String> filaNum;
    private Pilha<String> pilhaOper;
    private String expressao;
    private double result;
    StringTokenizer quebrador = null;
 
    public Calculadora_1(String exp) throws Exception
    {   
        filaNum = new Fila<String>(exp.length());
        pilhaOper = new Pilha<String>(exp.length());
        //expressao = new String[50];
        
        this.expressao = exp.replaceAll(" ","");
        
        quebrador = new StringTokenizer (this.expressao, "+-*/^()", true);
        String pedacoAtual = "";
        while(quebrador.hasMoreTokens())
        {
            conversor(quebrador.nextToken());
        }

        while(pilhaOper.Tamanho() > 0){
            filaNum.guarde(pilhaOper.getItem());
            pilhaOper.removaItem();
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
        String oper = "^*/+-";
        return oper.contains(op);
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
   
            if(isNumeros(expInf))   //se ? numero guarde na fila de numeros
                filaNum.guarde(expInf);
            else
            {
                if(pilhaOper.Tamanho() == 0 || expInf.equals("("))
                    pilhaOper.guarde(expInf);
                else if(isOperadores(expInf)){
                    verificado = verificacao(expInf);

                    while (verificado)
                    {
                        filaNum.guarde(pilhaOper.getItem());
                        pilhaOper.removaItem();

                        verificado = verificacao(expInf);
                    }

                    pilhaOper.guarde(expInf);
                }
                else if (expInf.equals(")")) {
                    while(!pilhaOper.getItem().equals("(")){
                        filaNum.guarde(pilhaOper.getItem());
                        pilhaOper.removaItem();
                    }
                    pilhaOper.removaItem();
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

    public void calculadoraDeExpressao() throws Exception
    {
        double num1;
        double num2;
        String operador;
        
        Pilha<Double> resultado = new Pilha<>(this.expressao.length());
        while(filaNum.Tamanho() > 0)
        {
           String pos=filaNum.getItem();
            
           if(isNumeros(pos))
           {
                resultado.guarde(Double.parseDouble(pos));
                filaNum.removaItem();
           }
           else
           {
                operador=pos;
                filaNum.removaItem();
                num2=resultado.getItem();
                resultado.removaItem();
                num1=resultado.getItem();
                resultado.removaItem();
                resultado.guarde(fazerContas(num1, num2, operador));
           }
        }
        if (resultado.Tamanho() > 1)
            throw new Exception("Expressão inválida");
        this.result = resultado.getItem();
    }
    
    public double fazerContas(double val1, double val2, String oper){
        
        double result = 0.0;
        if(oper.equals("^"))
            result = Math.pow(val1, val2);
        
        else if(oper.equals("*"))
            result = val1 * val2;
        
        else if(oper.equals("/"))
            result = val1 / val2;
        
        else if(oper.equals("+"))
            result = val1 + val2;
        
        else if(oper.equals("-"))
            result = val1 - val2;

        return result;
    }
    
    public String toString()
    {
        return  "O resultado da Expressao e: " + (this.result);

    }

    public double getResult(){
        return this.result;
    }
}
