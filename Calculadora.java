
public class Calculadora 
{

    private String exp;
 
    public Calculadora() throws Exception
    {
        StringTokenizer quebrador = new StringTokenizer (exp, "+-*/^()", true);
        while(quebrador.hasMoreTokens()){
        exp = quebrador.nextToken();}
    }

    public static boolean valida(String expressao)
    {
        int parenteses = 0;
        
        
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

    public boolean operadores (String op)
    {
        if(op.matches("[+|-|*|/|]"))
            return true;
        return false;
    }
    
    public boolean numeros (String nmr)
    {
        if(nmr.matches("[0-9]"))
            return true;
        return false;
    }
    
    //REVER
    public int prioridade(Object obj)
    {
        int ret = 0;
        String pri1 = "+-";
        String pri2 = "*/";
        if ("(".equals(obj.toString())) {
            ret = 1;
        } 
        else if (pri1.indexOf(obj.toString()) >= 0) {
            ret = 2;
        }
         else if (pri2.indexOf(obj.toString()) >= 0) {
            ret = 3;
        } 
        else if ("^".equals(obj.toString())) {
            ret = 4;
        }
        return ret;
    }

    public static conversor()
    {
        

    }

}



