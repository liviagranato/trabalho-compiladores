/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador;

import static analisador.MainLex.geraLexer;
import java.io.File;

/**
 *
 * @author 12131002916
 */
public class MainSint {

    public static void geraLexer(String path1){
    File arquivo1 = new File(path1);  //abre o arquivo "Lexer.flex"
    jflex.Main.generate(arquivo1);   //gera a classe "Lexer.java"
}
    
    public static void main(String[] args){
        //localiza o arquivo ""
        String path1 = "/home/arantesandre97/Developer/trabalho-compiladores/Analisador/src/analisador/LexerS.flex";
        
        //chamada do metodo "geraLexer"
        geraLexer(path1);
    }
    }
    
