package analisador;

import java.io.File;

public class MainLex {

//metodo para criar a nova classe para fazer a análise léxica do codigo
public static void geraLexer(String path){
    File arquivo = new File(path);  //abre o arquivo "Lexer.flex"
    jflex.Main.generate(arquivo);   //gera a classe "Lexer.java"
}
    
    public static void main(String[] args){
        //localiza o arquivo .flex
        String path = "/home/arantesandre97/Developer/trabalho-compiladores/Analisador/src/analisador/Lexer.flex";
        
        //chamada do metodo "geraLexer"
        geraLexer(path);
    }
    
}
