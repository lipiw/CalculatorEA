
public class Calculadora 
{

    private String exp;

    StringTokenizer quebrador = new StringTokenizer (exp, "+-*/^()", true);
    
    public Calculadora() throws Exception
    {
        if(exp == null)
        throw new Exception("Nenhuma expressão declarada");
    }

    public static boolean valida(String expressao)
    {
        int parenteses = 0;
        expressao = expressao.replaceAll("", "");
        
        while (true)
        {
            for(int i=0; i<expressao.length(); i++)
            {
                if(expressao.charAt(i) == "(")
                    this.parenteses++;
                
                if(expressao.charAt(i) == ")")
                this.parenteses--;
            }
            
            
        }
    }
    

}



