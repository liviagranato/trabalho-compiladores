%{
	#include"y.tab.h"
	extern int yy1val;
%}


%%

"main"						{return MAIN;}
"if"						{return SE;}
"else"						{return SENAO;}
"elseif"					{return ESE;}	
"while"						{return ENQ;}
"for"						{return RT;}
"return"					{return RETORNA;}
"null"						{return NULO;}
"length"					{return TAM;}
"true"						{return vdd;}
"false"						{return falso;}

"&&"						{return E;}
"||"						{return OU;}
"!"							{return !;}
"//"						{return ##;}
"/*"						{return #;}
"*/"						{return #;}
"+"							{return +;}
"-"							{return -;}
"*"							{return X;}
"/"							{return /;}
"pow"						{return ¨;}
"mod"						{return %;}
"=="						{return =;}
"!="						{return ?;}
"="							{return ();}
"("							{return [;}
")"							{return ];}
">="						{return >=;}
"<"							{return <;}
">"							{return >;}
"<="						{return <=;}
":"							{return :;}
'"'							{return ";}
","							{return ,;}
";"							{return ; ;}
"."							{return .;}
"++"						{return INC;}
"--"						{return DEC;}

[0-9]+						(yy1val=atoi(yytext); return DIGITO;)
(-)?{[0-9]}+(.){[0-9]}*		(yy1val=atoi(yytext); return REAL;)
[a-zA-Z]					(yy1val=atoi(yytext); return LETRA;)
((a-zA-Z)+([0-9])*)			(yy1val=atoi(yytext); return STRING;)
[a-zA-Z]+([a-zA-Z]|[0-9])*	(yy1val=atoi(yytext); return VARIAVEL;)


[ \t]+					;
[\n]+					{return \n;}
.						{printf("NAO RECONHECIDO: %s\n", yytext); exit(0);}
%%