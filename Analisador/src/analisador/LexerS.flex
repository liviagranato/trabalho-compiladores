package analisador;

import static analisador.Token.*;
import java_cup.runtime.Symbol;
import analisador.sym;

%%

//%public
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%eofval{
    return new Symbol (sym.EOF, new String("Fim do arquivo"));
%eofval}

CARACTERE = [a-zA-Z_]
DIGITO = [0-9]
NUMERO = [- | ]?({DIGITO}+ | {DIGITO}+("."){DIGITO}+)
IDENTIFICADOR = {CARACTERE}({CARACTERE} | {DIGITO})*
WHITE=[ \t\r\n]

%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}

/*Operadores Aritméticos */
("+" | "-" | "X" | "/" | "¨" | "%" )    {return new Symbol(sym.OP_ARITMETICO, yychar, yyline, yytext());}

/* Operadores Lógicos */
("E" | "OU" | "!")  {return new Symbol(sym.OPERADOR_LOGICO, yychar, yyline, yytext());}

/*Operadores Relacionais */
(">" | "<" | "=" | "?" | ">=" | "<=")   {return new Symbol(sym.OP_RELACIONAL, yychar, yyline, yytext());}

/*Operadores Booleanos*/
("falso" | "vdd")   {return new Symbol(sym.OP_BOOLEANO, yychar, yyline, yytext());}

/*Separadores */
("(")   {return new Symbol(sym.ABRE_PARENTESES, yychar, yyline, yytext());}
( ")")  {return new Symbol(sym.FECHA_PARENTESES, yychar, yyline, yytext());}
("[")   {return new Symbol(sym.ABRE_COLCHETES, yychar, yyline, yytext());}
("]")   {return new Symbol(sym.FECHA_COLCHETES, yychar, yyline, yytext());}
(";")   {return new Symbol(sym.PONTO_VIRGULA, yychar, yyline, yytext());}
(":")   {return new Symbol(sym.DOIS_PONTOS, yychar, yyline, yytext());}
(",")   {return new Symbol(sym.VIRGULA, yychar, yyline, yytext());}
(".")   {return new Symbol(sym.PONTO, yychar, yyline, yytext());}
("\"")  {return new Symbol(sym.ASPAS_DUPLAS, yychar, yyline, yytext());}
("\'")  {return new Symbol(sym.ASPAS_SIMPLES, yychar, yyline, yytext());}

/* Comentarios */
("##"(.)* | "#"(.)*"#" )   {;}

/* Marcador de inicio do algoritmo */
("<MAIN>")  {return new Symbol(sym.PRINCIPAL, yychar, yyline, yytext());}

/* Marcador de fim do algoritmo */
("</MAIN>")  {return new Symbol(sym.FIM, yychar, yyline, yytext());}

/* Marcador de inicio de blocos */
("<FUNCTION>")  {return new Symbol(sym.FUNCAO, yychar, yyline, yytext());}

/* Marcador de inicio de blocos */
("</FUNCTION>")  {return new Symbol(sym.FUNCAO_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<SE>")  {return new Symbol(sym.SE, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</SE>")  {return new Symbol(sym.SE_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<ESE>")  {return new Symbol(sym.ESE, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</ESE>")  {return new Symbol(sym.ESE_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<SENAO>")  {return new Symbol(sym.SENAO, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</SENAO>")  {return new Symbol(sym.SENAO_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<RT>")  {return new Symbol(sym.REPETICAO, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</RT>")  {return new Symbol(sym.REPETICAO_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<ENQ>")  {return new Symbol(sym.ENQUANTO, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</ENQ>")  {return new Symbol(sym.ENQUANTO_FIM, yychar, yyline, yytext());}

/* Identificar a escrita na tela */
( "<<")  {return new Symbol(sym.ESCREVA, yychar, yyline, yytext());}

/* Identificar a leitura na tela */
( ">>")  {return new Symbol(sym.LEIA, yychar, yyline, yytext());}

/* Palavra reservada RETORNA*/
("RETORNA")   {return new Symbol(sym.RETORNA, yychar, yyline, yytext());}

{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yychar, yyline, yytext());}
{NUMERO} {return new Symbol(sym. NUMERO, yychar, yyline, yytext());}

. {System.err.println("Caracter ilegal: " + yytext());}
