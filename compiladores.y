//inclusão de bibliotecas
%{
    #include <stdio.h>
    #include <stdlib.h>
    int yylex(void)
    extern int yylval;
    void yyerror(char *);
%}

//especificação de tokens
%token MAIN, SE, SENAO, ESE, ENQ, RT, RETORNA, NULO, TAM, vdd, falso
%token E, OU, !, ##, #, +, -, X, /, %, =, ?, (), [, ], >=, <, >, <=, :, ;, INC, DEC

//precedências

%%
S : ST { printf("\nAceito\n"); exit(0); }

ST : RT [ Expr1 ; Expr2 ; Expr3 ; ]
|    ENQ [ Expr2 ]
|    BINARIO
|    HEXADECIMAL
|    OCTAL


//atalho para expressão de verificação
RELOP : <
|       >
|       =
|       >=
|       <=
|       !

//atalhos de expressões
Expr1: VARIAVEL = VARIAVEL
|      VARIAVEL = DIGITO
|      VARIAVEL = REAL

Expr2: VARIAVEL RELOP VARIAVEL
|      VARIAVEL RELOP DIGITO

Expr3: VARIAVEL INC
|      VARIAVEL DEC