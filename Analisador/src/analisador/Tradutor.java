package analisador;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static jflex.Skeleton.line;

public class Tradutor {
  int i=0;
  
    public void getTokens(String tokens)throws Exception{ 
        int cont = 0;     

        Lexer lexer = new Lexer(new StringReader(tokens));   
        //System.out.println(tokens);                                               
        String resultado = "";
        String precedence = "";
        //boolean main = false;
        boolean function = false;
        boolean se = false;
        boolean ese = false;
        boolean enq = false;
        boolean rt = false;
        boolean igual = false;
        boolean ident = false;
     
       while(true){
           Token token = lexer.yylex();
           System.out.println(precedence);
           
           if(token == null){
               
                System.out.println(resultado);
                this.geradorArquivo(resultado);
               
                return;
           }
               //cases para mostrarmos a saida dos tokens 
               switch(token){                
                
                case LINHA:                    
                   if(precedence.contains("def")){
                        if(precedence.contains("print")){
                            resultado = resultado + ")";
                            precedence = precedence.replaceAll("print", "");
                        }
                                                
                        resultado = resultado + "\n";
                        resultado = resultado + "    ";
                        precedence = precedence.replaceAll("igual", "");
                        igual = false;
                        precedence = precedence.replaceAll("ident", "");
                        ident = false;
                        
                        if(precedence.contains("for")){
                            resultado = resultado + "    ";
                            if(precedence.contains("if")){
                                resultado = resultado + "    ";
                                break;
                            } else if(precedence.contains("elif")){
                                resultado = resultado + "    ";
                                break;
                            } else if(precedence.contains("else")){
                                resultado = resultado + "   ";
                                break;
                            }
                            break;
                        } else if(precedence.contains("while")){
                            resultado = resultado + "    ";
                            if(precedence.contains("if")){
                                resultado = resultado + "    ";
                                break;
                            } else if(precedence.contains("elif")){
                                resultado = resultado + "    ";
                                break;
                            } else if(precedence.contains("else")){
                                resultado = resultado + "   ";
                                break;
                            }
                            break;
                        } else if(precedence.contains("if")){
                            resultado = resultado + "    ";
                            break;
                        } else if(precedence.contains("elif")){
                            resultado = resultado + "    ";
                            break;
                        } else if(precedence.contains("else")){
                            resultado = resultado + "    ";
                            break;
                        }
                        break;
                   } else if(precedence.contains("main")){
                        
                        if(precedence.contains("print")){
                            resultado = resultado + ")";
                            precedence = precedence.replaceAll("print", "");
                        }
                       
                        resultado = resultado + "\n";
                        resultado = resultado + "    ";
                        precedence = precedence.replaceAll("igual", "");
                        igual = false;
                        precedence = precedence.replaceAll("ident", "");
                        ident = false;
                        
                        if(precedence.contains("for")){
                            resultado = resultado + "    ";
                            if(precedence.contains("if")){
                                resultado = resultado + "    ";
                                break;
                            } else if(precedence.contains("elif")){
                                resultado = resultado + "    ";
                                break;
                            } else if(precedence.contains("else")){
                                resultado = resultado + "   ";
                                break;
                            }
                            break;
                        } else if(precedence.contains("while")){
                            resultado = resultado + "    ";
                            if(precedence.contains("if")){
                                resultado = resultado + "    ";
                                break;
                            } else if(precedence.contains("elif")){
                                resultado = resultado + "    ";
                                break;
                            } else if(precedence.contains("else")){
                                resultado = resultado + "   ";
                                break;
                            }
                            break;
                        } else if(precedence.contains("if")){
                            resultado = resultado + "    ";
                            break;
                        } else if(precedence.contains("elif")){
                            resultado = resultado + "    ";
                            break;
                        } else if(precedence.contains("else")){
                            resultado = resultado + "    ";
                            break;
                        }
                        break;
                   } 
                   
                   else{
                        resultado = resultado + "\n";
                        break;
                   }
                                       
                case OP_SOMA:
                    resultado = resultado + " " + lexer.lexeme + " "; 
                    precedence = precedence.replaceAll("ident", "");
                    break;
                    
                case OP_SUBTRACAO:
                    resultado = resultado + "" + lexer.lexeme + "";
                    precedence = precedence.replaceAll("ident", "");
                    break;                    

                case OP_MULTIPLICACAO:
                    resultado = resultado + " " + lexer.lexeme + " ";
                    precedence = precedence.replaceAll("ident", "");
                    break;
                    
                case OP_DIVISAO:
                    resultado = resultado + " " + lexer.lexeme + " ";
                    precedence = precedence.replaceAll("ident", "");
                    break;                 
                    
                case OP_MOD:
                    resultado = resultado + " " + lexer.lexeme + " ";
                    precedence = precedence.replaceAll("ident", "");
                    break;
                    
                case OP_EXPONENCIACAO:
                    resultado = resultado + "**";
                    precedence = precedence.replaceAll("ident", "");
                    break; 
                    
                case OP_LOGICO:
                    
                    if(lexer.lexeme.equals("E")){
                        resultado = resultado + " and ";
                        break;
                    } else {
                        resultado = resultado + " or ";
                        break;
                    }
                    
                case OP_NEGACAO:
                    resultado = resultado + " " + lexer.lexeme;
                    break;
                                  
                case OP_RELACIONAL:
                    resultado = resultado + " " + lexer.lexeme + " ";
                    break;
                    
                case OP_IGUAL:
                    if(precedence.contains("ident")){
                        
                      if(precedence.contains("if") || precedence.contains("elif")){
                        precedence = precedence + "igual";
                        resultado = resultado + " == ";
                        precedence = precedence.replaceAll("ident", "");
                        break;
                      }
                      
                      precedence = precedence + "igual";
                      igual = true;
                      resultado = resultado + " " + lexer.lexeme + " ";
                      precedence = precedence.replaceAll("ident", "");
                      break;
                      
                    }
                    
                    resultado = resultado + " ==";
                    precedence = precedence.replaceAll("ident", "");
                    ident = false;
                    break;              
                    
                case OP_DIFERENTE:
                    resultado = resultado + " != ";
                    break;

                case OP_BOOLEANO:
                    
                    if(lexer.lexeme.equals("vdd")){
                        resultado = resultado + "True" ;
                        break;
                    } else {
                        resultado = resultado + "False" ;
                        break;
                    }  
                    
                case ABRE_PARENTESES:
                    resultado = resultado + lexer.lexeme;
                    break;

                case FECHA_PARENTESES:
                    if(precedence.contains("input")){
                        resultado = resultado + lexer.lexeme + lexer.lexeme;
                        precedence = precedence.replaceAll("input", "");
                        break;
                    } else if(precedence.contains("def") && function == true){
                       resultado = resultado + lexer.lexeme + ":";
                       function = false;
                       break;
                    } else
                    resultado = resultado + lexer.lexeme;
                    break;
                    
                case ABRE_COLCHETES:
                    if(precedence.contains("igual") && igual == true){                   
                      resultado = resultado + lexer.lexeme;
                      break;
                    } else if(precedence.contains("ident")){
                        resultado = resultado + lexer.lexeme;
                        break;
                    } else {
                        resultado = resultado + "(";
                        break;
                    }
                    
                case FECHA_COLCHETES:
                    
                    if(precedence.contains("if") && se == true){
                        resultado = resultado + "):";
                        se = false;
                        break;
                    } else if(precedence.contains("elif") && ese == true){
                        resultado = resultado + "):";
                        ese = false;
                        break;
                    } else if(precedence.contains("for") && rt == true){
                        resultado = resultado + "):";
                        rt = false;
                        break; 
                    } else if(precedence.contains("while") && enq == true){                                       
                        resultado = resultado + "):";
                        enq = false;
                        break;
                    } else if(precedence.contains("igual") && igual == true){
                        resultado = resultado + lexer.lexeme;
                        igual = false;
                        precedence = precedence.replaceAll("igual", "");
                        break;
                    } else {
                    
                        resultado = resultado + ")";
                        break;
                    }
                    
                case PONTO_VIRGULA:
                    resultado = resultado + lexer.lexeme;
                    break;
 
                case VIRGULA:
                    resultado = resultado + lexer.lexeme;
                    break;
                    
                case ASPAS_DUPLAS:
                    resultado = resultado + lexer.lexeme;
                    break;
                    
                case ASPAS_SIMPLES:
                    resultado = resultado + lexer.lexeme;
                    break;                   
                                        
                case COMENTARIO:
                    resultado = resultado + "#" + lexer.lexeme;
                    break;
                                                     
                case PRINCIPAL:
                    precedence = "main";                    
                    resultado = resultado + "def main():";
                    break;
                 
                case FIM:
                    precedence = "";
                    resultado = resultado + "\n\n";
                    resultado = resultado + "if __name__ == '__main__':\n";
                    resultado = resultado +  "    main()\n";
                    break;
                    
                case FUNCAO:
                    function = true;
                    precedence = "def";
                    resultado = resultado + "def ";
                    break;
                
                case FUNCAO_FIM:
                     precedence = "";
                     break;
                    
                case SE:
                    se = true;
                    precedence = precedence + " if";
                    resultado = resultado + "if ";
                    break;
                    
                case SE_FIM:
                    precedence = precedence.replaceFirst("if", "");
                    break;
                    
               case ESE:
                    ese = true;
                    precedence = precedence + " elif";
                    resultado = resultado + "elif ";
                    break;
                   
               case ESE_FIM:
                    precedence = precedence.replaceFirst("elif", "");
                    break;
                   
               case SENAO:
                   precedence = precedence + " else";
                   resultado = resultado + "else:";
                   break;  
                   
               case SENAO_FIM:
                    precedence = precedence.replaceFirst("else", "");
                    break; 
                   
                case REPETICAO:
                    rt = true;
                    precedence = precedence + " for";
                    resultado = resultado + "for ";
                    break; 

                case REPETICAO_FIM:
                    precedence = precedence.replaceFirst("for", "");
                break; 
                 
                case ENQUANTO:
                    enq = true;
                    precedence = precedence + "while";
                    resultado = resultado + "while";
                    break; 
                
                case ENQUANTO_FIM:   
                    precedence = precedence.replaceFirst("while", "");
                    break;
                    
                case ESCREVA:
                   precedence = precedence + " print"; 
                   resultado = resultado + "print(";
                   break;  
                   
                case LEIA:
                   precedence = precedence + " input";
                   break; 
                   
                case RETORNA:
                   resultado = resultado + "return ";
                   break;                   
                   
                case IDENTIFICADOR:
                   
                   if(precedence.contains("input")){
                        resultado = resultado + lexer.lexeme + " = int(input";
                        break;
                   }
                   
                   precedence = precedence + " ident";
                   ident = true;
                   resultado = resultado + lexer.lexeme;
                   break;
                   
                case STRING:
                   if(precedence.contains("print")){
                        resultado = resultado + lexer.lexeme + ")";
                        precedence = precedence.replaceFirst("print", "");
                        break;
                   }
                   precedence = precedence + " string";
                   resultado = resultado + lexer.lexeme;
                   break;                   

                case INTEIRO:
                   if(precedence.contains("print")){
                        resultado = resultado + lexer.lexeme + ")";
                        break;
                   }
                   resultado = resultado + lexer.lexeme;
                   break;
                   
                case REAL:
                   if(precedence.contains("print")){
                        resultado = resultado + lexer.lexeme + ")";
                        break;
                   }
                   resultado = resultado + lexer.lexeme;
                   break;                                               
           }
        
       }
    }
       

  private void geradorArquivo(String conteudo){
    try {
        FileWriter writer = new FileWriter(new File("/home/arantesandre97/Developer/trabalho-compiladores/Analisador/src/analisador/codigo.py"));  
        PrintWriter saida = new PrintWriter(writer);
        saida.print(conteudo);
        saida.close();  
        writer.close();
        } catch (Exception e) {
            e.printStackTrace();
       }
    }
}
