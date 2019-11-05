package analisador;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Tradutor {
  int i=0;
  
  public void Traduzir(String codigo){
    char [] letras = codigo.toCharArray();
    String aux = "";
    String codigo_traduzido = "";
    String parametro = "";
    String identificador = "";
    String tipo_variavel = "";
    String comentario = "";
    
    for(i=0; i < letras.length; i++){
        aux += letras[i];
        switch(aux){    
            //case p/ comentários
            case "##":
                codigo_traduzido += "//" + comentario;
                aux = "";
            break;
                
            case "+":
                codigo_traduzido += "+";
                aux = "";
            break;
                
            case "-":
                codigo_traduzido += "-";
                aux = "";
            break;
                
            case "*":
                codigo_traduzido += "*";
                aux = "";
            break;
                
            case "/":
                codigo_traduzido += "/";
                aux = "";
            break;
            
            case "^":
                codigo_traduzido += "^";
                aux = "";
            break;    
            
            case "> ":
                codigo_traduzido += ">";
                aux = "";
            break;
                
            case "< ":
                codigo_traduzido += "<";
                aux = "";
            break; 
            
            case "<= ":
                codigo_traduzido += "<=";
                aux = "";
            break;
            
            case ">= ":
                codigo_traduzido += ">=";
                aux = "";
            break;    
            
            case "E":
                codigo_traduzido += " && ";
                aux = "";
            break;    
            
            case "OU":
                codigo_traduzido += " || ";
                aux = "";
            break;
            
            case "=":
                codigo_traduzido += " == ";
                aux = "";
            break;    
                
            case "?":
                codigo_traduzido += " != ";
                aux = "";
            break;
                
            case "<< ":
                codigo_traduzido += "printf();";
                aux = "";
            break;
            
            case ">> ":
                codigo_traduzido += "scanf();";
                aux = "";
            break;
                
            case "\n":
                codigo_traduzido += "\n";
                aux = "";
            break;
            
            case "\"\"":
            break;
                
            case "falso":
                codigo_traduzido += "false";
                aux = "";
            break;
                
            case "vdd":
                codigo_traduzido += "true";
                aux = "";
            break;    
            
            case "<MAIN>":
                codigo_traduzido += "void main(){";
                aux = "";
            break;
            
            case "</MAIN>":
                codigo_traduzido += "\n }";
                aux = "";
            break;
                
            case "<SE>":
                codigo_traduzido += "if(){";
                aux = "";
            break;
            
            case "</SE>":
                codigo_traduzido += "\n }";
                aux = "";
            break;
            
            case "<ESE>":
                codigo_traduzido += "else if(){";
                aux = "";
            break;
            
            case "</ESE>":
                codigo_traduzido += "\n }";
                aux = "";
            break;
            
            case "<SENAO>":
                codigo_traduzido += "else{";
                aux = "";
            break;
            
            case "</SENAO>":
                codigo_traduzido += "\n }";
                aux = "";
            break;    
            
            case ";":
                codigo_traduzido += ";";
                aux = "";
            break;
            
            case ".":
                codigo_traduzido += ".";
                aux = "";
            break;
            
            case "RETORNA":
                codigo_traduzido += "return";
                aux = "";
            break;
            
            case "<RT>":
                codigo_traduzido += "for(){";
                aux = "";
            break;
                 
            case "</RT>":
                codigo_traduzido += "\n }";
                aux = "";
            break;
            
            case "<ENQ>":
                codigo_traduzido += "while(){";
                aux = "";
            break;
                 
            case "</ENQ>":
                codigo_traduzido += "\n }";
                aux = "";
            break;
                
            case "<FUNCTION>":
                //Tipo_variável = char || int || float
                //Identificador =  nome da função
                codigo_traduzido += tipo_variavel + identificador + "(){";
                aux = "";
            break;
                 
            case "</FUNCTION>":
                codigo_traduzido += "\n }";
                aux = "";
            break;
        }
    }
        System.out.println(codigo_traduzido);
    geradorArquivo(codigo_traduzido);
  }     

  private void geradorArquivo(String conteudo){
    try {
        FileWriter writer = new FileWriter(new File("C:\\Users\\vitau\\OneDrive\\Documents\\Pessoal\\Trabalho\\Git\\trabalho-compiladores\\Analisador\\src\\analisador\\codigo.c"));  
        PrintWriter saida = new PrintWriter(writer);
        saida.print(conteudo);
        saida.close();  
        writer.close();
        } catch (Exception e) {
            e.printStackTrace();
       }
    }
}
