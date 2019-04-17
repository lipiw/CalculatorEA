import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Programa{

    static void Main(String [] args) throws Exception
    {   
        System.out.println("Digite uma expressao: ");
        
        BufferedReader myBuffer = new BufferedReader(new InputStreamReader(System.in));

        String expressao = myBuffer.readLine();
        Calculator c = new Calculator(expressao);
       
        
        System.out.println ("Digite a expressao:");
        
        if(expressao == null)
        throw new Exception("Nenhuma expressao declarada");

    }
    
    
}