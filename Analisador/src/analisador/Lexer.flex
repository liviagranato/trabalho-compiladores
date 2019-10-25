package analisador;

import static analisador.Token.*;
%%
%class Lexer
%type Token

CARACTERE = [a-zA-Z_]
DIGITO = [0-9]
INTEIRO = [- | ]?{DIGITO}+
REAL = [- | ]?{DIGITO}+("."){DIGITO}+
IDENTIFICADOR = {CARACTERE}({CARACTERE} | {DIGITO})*
WHITE=[ \t\r]

%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}

/* Pular linha*/
( "\n" )    {lexeme = yytext(); return LINHA;}

/*Operadores Aritméticos */
( "X" | "/" | "¨" | "%" ) {lexeme = yytext(); return OP_ARITMETICO;}

/*Operador Soma*/
("+") {lexeme = yytext(); return OP_SOMA;}

/*Operador Subtração*/
("-") {lexeme = yytext(); return OP_SUBTRACAO;}

/* Operadores Lógicos */
("E" | "OU")    {lexeme = yytext(); return OP_LOGICO;}
("!")   {lexeme = yytext(); return OP_NEGACAO;}

/*Operadores Relacionais */
(">" | "<" | ">=" | "<=")   {lexeme = yytext(); return OP_RELACIONAL;}

/*Operadores de Comparação*/
("=")   {lexeme = yytext(); return OP_IGUAL;}
("?")   {lexeme = yytext(); return OP_DIFERENTE;}

/*Operadores Booleanos*/
("falso" | "vdd")   {lexeme=yytext(); return OP_BOOLEANO;}

/*Separadores */
("(")   {lexeme = yytext(); return ABRE_PARENTESES;}
( ")")  {lexeme = yytext(); return FECHA_PARENTESES;}
("[")   {lexeme = yytext(); return ABRE_COLCHETES;}
("]")   {lexeme = yytext(); return FECHA_COLCHETES;}
(";")   {lexeme = yytext(); return PONTO_VIRGULA;}
(":")   {lexeme = yytext(); return DOIS_PONTOS;}
(",")   {lexeme = yytext(); return VIRGULA;}
(".")   {lexeme = yytext(); return PONTO;}
("\"")  {lexeme = yytext(); return ASPAS_DUPLAS;}
("\'")  {lexeme = yytext(); return ASPAS_SIMPLES;}

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

{IDENTIFICADOR} {lexeme=yytext(); return IDENTIFICADOR;}
{INTEIRO} {lexeme=yytext(); return INTEIRO;}
{REAL} {lexeme=yytext(); return REAL;}

. {return ERROR;}
