import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Programa{

    public static void main(String [] args) throws Exception
    {   
        System.out.println("Digite uma expressao: ");
        
        BufferedReader myBuffer = new BufferedReader(new InputStreamReader(System.in));

        String expressao = myBuffer.readLine();
        Calculadora_1 c = new Calculadora_1(expressao);
        
        System.out.println("O resultado da expressao e = " + c.getResult());
        if(expressao == null)
        throw new Exception("Nenhuma expressao declarada");

    }
    
    
}