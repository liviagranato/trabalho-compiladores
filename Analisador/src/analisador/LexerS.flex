package analisador;

import static analisador.Token.*;
import java_cup.runtime.Symbol;
import analisador.Sym;

%%

//%public
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%eofval{
    return new Symbol (Sym.EOF, new String("Fim do arquivo"));
%eofval}

CARACTERE = [a-zA-Z_]
DIGITO = [0-9]
INTEIRO = [- | ]?{DIGITO}+
REAL = [- | ]?{DIGITO}+("."){DIGITO}+
IDENTIFICADOR = {CARACTERE}({CARACTERE} | {DIGITO})*
WHITE=[ \t\r\n]

%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}

/*Operadores Aritméticos */
("X" | "/" | "¨" | "%" )    {return new Symbol(Sym.OP_ARITMETICO, yychar, yyline, yytext());}

/*Operador Soma*/
("+") {return new Symbol(Sym.OP_SOMA, yychar, yyline, yytext());}

/*Operador Subtração*/
("-") {return new Symbol(Sym.OP_SUBTRACAO, yychar, yyline, yytext());}

/* Operadores Lógicos */
("E" | "OU")  {return new Symbol(Sym.OP_LOGICO, yychar, yyline, yytext());}
("!")   {return new Symbol(Sym.OP_NEGACAO, yychar, yyline, yytext());}

/*Operadores Relacionais */
(">" | "<" | ">=" | "<=")   {return new Symbol(Sym.OP_RELACIONAL, yychar, yyline, yytext());}

/*Operadores de Comparação*/
("=")   {return new Symbol(Sym.OP_IGUAL, yychar, yyline, yytext());}
("?")   {return new Symbol(Sym.OP_DIFERENTE, yychar, yyline, yytext());}

/*Operadores Booleanos*/
("falso" | "vdd")   {return new Symbol(Sym.OP_BOOLEANO, yychar, yyline, yytext());}

/*Separadores */
("(")   {return new Symbol(Sym.ABRE_PARENTESES, yychar, yyline, yytext());}
( ")")  {return new Symbol(Sym.FECHA_PARENTESES, yychar, yyline, yytext());}
("[")   {return new Symbol(Sym.ABRE_COLCHETES, yychar, yyline, yytext());}
("]")   {return new Symbol(Sym.FECHA_COLCHETES, yychar, yyline, yytext());}
(";")   {return new Symbol(Sym.PONTO_VIRGULA, yychar, yyline, yytext());}
(",")   {return new Symbol(Sym.VIRGULA, yychar, yyline, yytext());}
("\"")  {return new Symbol(Sym.ASPAS_DUPLAS, yychar, yyline, yytext());}
("\'")  {return new Symbol(Sym.ASPAS_SIMPLES, yychar, yyline, yytext());}

/* Comentarios */
("##"(.)* | "#"(.)*"#" )   {;}

/* Marcador de inicio do algoritmo */
("<MAIN>")  {return new Symbol(Sym.PRINCIPAL, yychar, yyline, yytext());}

/* Marcador de fim do algoritmo */
("</MAIN>")  {return new Symbol(Sym.FIM, yychar, yyline, yytext());}

/* Marcador de inicio de blocos */
("<FUNCTION>")  {return new Symbol(Sym.FUNCAO, yychar, yyline, yytext());}

/* Marcador de inicio de blocos */
("</FUNCTION>")  {return new Symbol(Sym.FUNCAO_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<SE>")  {return new Symbol(Sym.SE, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</SE>")  {return new Symbol(Sym.SE_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<ESE>")  {return new Symbol(Sym.ESE, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</ESE>")  {return new Symbol(Sym.ESE_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<SENAO>")  {return new Symbol(Sym.SENAO, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</SENAO>")  {return new Symbol(Sym.SENAO_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<RT>")  {return new Symbol(Sym.REPETICAO, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</RT>")  {return new Symbol(Sym.REPETICAO_FIM, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("<ENQ>")  {return new Symbol(Sym.ENQUANTO, yychar, yyline, yytext());}

/* Marcador de inicio do algoritmo */
("</ENQ>")  {return new Symbol(Sym.ENQUANTO_FIM, yychar, yyline, yytext());}

/* Identificar a escrita na tela */
( "<<")  {return new Symbol(Sym.ESCREVA, yychar, yyline, yytext());}

/* Identificar a leitura na tela */
( ">>")  {return new Symbol(Sym.LEIA, yychar, yyline, yytext());}

/* Palavra reservada RETORNA*/
("RETORNA")   {return new Symbol(Sym.RETORNA, yychar, yyline, yytext());}

{IDENTIFICADOR} {return new Symbol(Sym.IDENTIFICADOR, yychar, yyline, yytext());}
{INTEIRO} {return new Symbol(Sym.INTEIRO, yychar, yyline, yytext());}
{REAL} {return new Symbol(Sym.REAL, yychar, yyline, yytext());}

. {System.err.println("Caracter ilegal: " + yytext());}
