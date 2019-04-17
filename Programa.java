import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Programa{

    static void Main(String [] args) throws Exception
    {   
  
        BufferedReader myBuffer = new BufferedReader(new InputStreamReader(
        new FileInputStream("C:\\Desktop\\CalculatorEA\\Calculadora.txt"), "UTF-8"));

        String expressao;
        Calculator c = new Calculator();
       
        
        System.out.println ("Digite a expressao:");
        
        if(expressao == null)
        throw new Exception("Nenhuma expressao declarada");

    }
    
    
}