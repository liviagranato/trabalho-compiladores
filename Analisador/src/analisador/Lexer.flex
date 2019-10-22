package analisador;

import static analisador.Token.*;
%%
%class Lexer
%type Token

L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r]

%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}

/* Pular linha*/
( "\n" )    {lexeme = yytext(); return LINHA;}

/*Operadores Aritméticos */
("+" | "-" | "X" | "/" | "¨" | "%" ) {lexeme = yytext(); return OP_ARITMETICO;}

/* Operadores Lógicos */
("E" | "OU" | "!")    {lexeme = yytext(); return OPERADOR_LOGICO;}

/*Operadores Relacionais */
(">" | "<" | "=" | "?" | ">=" | "<=")   {lexeme = yytext(); return OP_RELACIONAL;}

/*Operadores Booleanos*/
("falso" | "vdd")      {lexeme=yytext(); return OP_BOOLEANO;}

/*Separadores */
("(" | ")" | "[" | "]" | ";" | "," |  "." |  "\"")      {lexeme = yytext(); return SEPARADOR;}

/* Comentarios */
("##"(.)* | "#"(.)*"#" )   {lexeme = yytext(); return COMENTARIO;}

/* Marcador de inicio do algoritmo */
("<MAIN>")  {lexeme = yytext(); return PRINCIPAL;}

/* Marcador de fim do algoritmo */
("</MAIN>")  {lexeme = yytext(); return FIM;}

/* Marcador de inicio de blocos */
("<FUNCTION>")  {lexeme = yytext(); return FUNCAO;}

/* Marcador de inicio de blocos */
("</FUNCTION>")  {lexeme = yytext(); return FUNCAO_FIM;}

/* Marcador de inicio do algoritmo */
("<SE>")  {lexeme = yytext(); return SE;}

/* Marcador de inicio do algoritmo */
("</SE>")  {lexeme = yytext(); return SE_FIM;}

/* Marcador de inicio do algoritmo */
("<ESE>")  {lexeme = yytext(); return ESE;}

/* Marcador de inicio do algoritmo */
("</ESE>")  {lexeme = yytext(); return ESE_FIM;}

/* Marcador de inicio do algoritmo */
("<SENAO>")  {lexeme = yytext(); return SENAO;}

/* Marcador de inicio do algoritmo */
("</SENAO>")  {lexeme = yytext(); return SENAO_FIM;}

/* Marcador de inicio do algoritmo */
("<RT>")  {lexeme = yytext(); return REPETICAO;}

/* Marcador de inicio do algoritmo */
("</RT>")  {lexeme = yytext(); return REPETICAO_FIM;}

/* Marcador de inicio do algoritmo */
("<ENQ>")  {lexeme = yytext(); return ENQUANTO;}

/* Marcador de inicio do algoritmo */
("</ENQ>")  {lexeme = yytext(); return ENQUANTO_FIM;}

/* Identificar a escrita na tela */
( "<<")  {lexeme = yytext(); return ESCREVA;}

/* Identificar a leitura na tela */
( ">>")  {lexeme = yytext(); return LEIA;}

/* Palavra reservada RETORNA*/
("RETORNA")   {lexeme = yytext(); return RETORNA;}

{L}({L}|{D})* {lexeme=yytext(); return PALAVRA;}
({D}+ | {D}+"."{D}+) | "-"({D}+ | {D}+"."{D}+) {lexeme=yytext(); return NUMERO;}

. {return ERROR;}
