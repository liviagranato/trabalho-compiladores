package analisador;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static jflex.Skeleton.line;

public class Tradutor {
  int i=0;
  
  public void Traduzir(String codigo){
    char [] letras = codigo.toCharArray();
    String aux = "";
    String codigo_traduzido = "#include <stdio.h> \n\n";
    String nomeFuncao = "";
    String parametro = "";
    String identificador = "";
    String tipo_variavel = "void ";
    String comentario = "";
    
    for(i=0; i < letras.length; i++){
        aux += letras[i];
        
        Pattern pattern_1 = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher_1 = pattern_1.matcher(aux);
        
        Pattern pattern_2 = Pattern.compile("([^\"]*)\n");
        Matcher matcher_2 = pattern_2.matcher(aux);
        
        Pattern pattern_3 = Pattern.compile("([^\"]*)\\(([^\"]*)\\)");
        Matcher matcher_3 = pattern_3.matcher(aux);
        
        if (matcher_1.find()) {
            parametro += matcher_1.group(1) +"\");\n";
            codigo_traduzido += parametro;
            aux = "";
            parametro = "";
        }
        
        if (matcher_2.find()) {
            identificador += matcher_2.group(1);
            if(!identificador.equals("")){
                identificador += ");\n";
                codigo_traduzido += identificador;
            }
            aux = "";
            identificador = "";
        }
        
        if (matcher_3.find()) {
            nomeFuncao += matcher_3.group(1);
            System.out.println("\nResultado: " + nomeFuncao);
        }
        
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
                codigo_traduzido += "\tprintf(\"";
                aux = "";
            break;
            
            case ">> ":
                codigo_traduzido += "\tscanf(\"%d\","+identificador;
                aux = "";
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
                codigo_traduzido += "void main(){\n";
                aux = "";
            break;
            
            case "</MAIN>":
                codigo_traduzido += "}";
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
                codigo_traduzido += tipo_variavel + identificador + "(" + parametro + "){";
                aux = "";
            break;
                 
            case "</FUNCTION>":
                codigo_traduzido += "}\n\n";
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
