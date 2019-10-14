package analisador;

import static analisador.Token.*;
%%
%class Lexer
%type Token

L = [a-zA-Z_]
D = [0-9]

%{
public String lexeme;
%}
%%

/* Pular linha */
( "\nl" )    {lexeme = yytext(); return LINHA;}

/*Operadores Aritméticos */
("+" | "-" | "X" | "/" | "¨" | "%" ) {lexeme = yytext(); return OP_ARITMETICO;}

/* Operadores Lógicos */
("E" | "OU" | "!")    {lexeme = yytext(); return OPERADOR_LOGICO;}

/*Operadores Relacionais */
(">" | "<" | "=" | "?" | ">=" | "<=")   {lexeme = yytext(); return OP_RELACIONAL;}

/* Operadores Atribuição */
/*("(" | ")")      {lexeme = yytext(); return OP_ATRIBUICAO;}

/*Operadores Booleanos*/
("falso" | "vdd")      {lexeme=yytext(); return OP_BOOLEANO;}

/*Separadores */
("(" | ")" | "[" | "]" | ";" | "," |  "." |  "\"")      {lexeme = yytext(); return SEPARADOR;}

/* Caracteres Especiais */
("<" | ">" | "</")   {lexeme = yytext(); return ESPECIAL;} */

/* Comentarios */
("##"(.)* | "#"(.)*"#" )     {lexeme = yytext(); return COMENTARIO;}

/* Marcador de inicio do algoritmo */
("MAIN")  {lexeme = yytext(); return PRINCIPAL;}

/* Marcador de fim do algoritmo */
/*("/MAIN")  {lexeme = yytext(); return FIM;}

/* Marcador de inicio de blocos */
("FUNCTION")  {lexeme = yytext(); return FUNCAO;}

/* Marcador de inicio do algoritmo */
("SE")  {lexeme = yytext(); return CONDICIONAL_SE;}

/* Marcador de inicio do algoritmo */
("ESE")  {lexeme = yytext(); return CONDICIONAL_ESE;}

/* Marcador de inicio do algoritmo */
("RT")  {lexeme = yytext(); return REPETICAO_RT;}

/* Marcador de inicio do algoritmo */
("ENQ")  {lexeme = yytext(); return REPETICAO_EQ;}

/* Marcador de fim de blocos */
/*( "/FUNCTION")  {lexeme = yytext(); return FUNCAO_FIM;}

/* Marcar Biblioteca */
/*( &{L}({L}|{D})*)  {lexeme = yytext(); return BIBLIOTECA;}

/* Identificar a escrita na tela */
( "<<")  {lexeme = yytext(); return ESCREVA;}

/* Identificar a leitura na tela */
( ">>")  {lexeme = yytext(); return LEIA;}

/* 7 palavras reservadas da linguagem Swigol */
/* ( exibir_interface | exibir_mac | exibir_vlan */
/* | exibir_ram | exibir_nvram | exibir_flash | copia_ram_nvram ) {lexeme = yytext(); return PALAVRA;} */


/* Palavra reservada MAIN*/
("MAIN")  {lexeme = yytext(); return MAIN;}  


/* Palavra reservada FUNCTION*/
("FUNCTION")  {lexeme = yytext(); return FUNCTION;} 


/* Palavra reservada SE*/
("SE")   {lexeme = yytext(); return SE;} 

/* Palavra reservada ELSE*/
("ESE")   {lexeme = yytext(); return ELSE;} 

/* Palavra reservada falso*/
( "falso")  {lexeme = yytext(); return FALSO;} 
 

/* Palavra reservada vdd*/
( "vdd")   {lexeme = yytext(); return VERDADEIRO;} 
 
/* Palavra reservada E*/
("E")   {lexeme = yytext(); return E;}

/* Palavra reservada OU*/
("OU")   {lexeme = yytext(); return OU;} 

/* Palavra reservada RETORNA*/
("RETORNA")   {lexeme = yytext(); return RETORNA;}

/* Palavra reservada TAM*/
("TAM")   {lexeme = yytext(); return TAM;}  

. {return ERROR;}
