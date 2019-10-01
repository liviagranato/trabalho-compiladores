%{
	#include"y.tab.h"
	extern int yy1val;
%}


%%

"main"			{return MAIN;}
"if"			{return SE;}
"else"			{return SENAO;}
"elseif"		{return ESE;}	
"while"			{return ENQ;}
"for"			{return RT;}
"return"		{return RETORNA;}
"null"			{return NULO;}
"length"		{return TAM;}
"true"			{return vdd;}
"false"			{return falso;}

"&&"			{return E;}
"||"			{return OU;}
"!"				{return !;}
"//"			{return ##;}
"/*"			{return #;}
"*/"			{return #;}
"+"				{return +;}
"-"				{return -;}
"*"				{return X;}
"/"				{return /;}
"pow"			{return ¨;}
"mod"			{return %;}
"=="			{return =;}
"!="			{return ?;}
"="				{return ();}
"("				{return [;}
")"				{return ];}
">="			{return >=;}
"<"				{return <;}
">"				{return >;}
"<="			{return <=;}
":"				{return : ;}
'"'				{return ";}
","				{return ,;}
";"				{return ; ;}
"."				{return .;}

[0-9]+			(yy1val=atoi)


%%