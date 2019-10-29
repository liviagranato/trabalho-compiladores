<h1 align="center">
  <a href="https://github.com/liviagranato/trabalho-compiladores">
    Analisador Léxico e Sintático | Linguagem VAL
  </a>
</h1>

<h3 align="center">
  O que é?
  <span> · </span>
  Iniciando o Programa
  <span> · </span>
  Requisitos
  <span> · </span>
  Primeiros Passos
  <span> · </span>
  Comandos Úteis
  <span> · </span>
  Como Contribuir
 </h3>
 

## 📋 O que é?

O analisador léxico e sintático é um projeto desenvolvido na linguagem de programação Java pelos alunos André Arantes, Livia Granato e Victor Pereira para a disciplina de Compiladores do curso de Engenharia da Computação da Universidade Federal de Itajubá. A partir de uma linguagem criada e especificada totalmente pelos alunos, o projeto tem por objetivo verificar uma implementação correta do código avaliando em dois critérios: <b>Avaliação Léxica</b> e <b>Avaliação Sintática</b>.

##  Iniciando o Programa
Ao executar o projeto e inserir um código na entrada, especifique um tipo de análise e realize o processo de compilação (através do botão COMPILAR). 

A interface criada (tentamos tornar o mais similar a uma IDE) denominada <i>Codekit</i> será responsável por exibir os retornos e resultados da análise para o código na saída, assim como apresentar possíveis erros durante a escrita. 

## 📖 Requisitos

Para execução do programa, é necessário ter o ambiente Netbeans IDE instalado no computador (recomenda-se a v8.0.1), Java JDK devidamente instalado, além das bibliotecas <b>Java-Cup-11a.jar</b>, <b>Java_Cup.jar</b> e <b>JFlex.jar</b> que estão disponíveis dentro do projeto.

## 🎉 Primeiros Passos

Para programar na linguagem "VAL", disponibilizamos o arquivo <b>Linguagens_Formais.pdf</b> onde especificamos todos os tokens que poderão ser utilizados, além de demonstrar também os compiladores acionados por eles durante o processo de compilação.

<b>Como Utilizar Corretamente as Bibliotecas</b>
O projeto possuirá alguns arquivos principais para gerar uma linguagem: <b>Lexer.flex</b>, <b>Parser.cup</b>, <b>Token.java</b>, <b>Sym.java</b> e <b>Yylex.java</b>.

<i>Obs: Alguns desses arquivos são gerados automaticamente após o processo de execução da main no projeto</i>
<ol>
<li><b>Lexer.flex</b></li>
É responsável por criar os lexemes, ou seja, as entradas para o compilador. Sendo assim, nele especificaremos tudo que estiver relacionado aos nossos tokens de entrada (como exemplo, uma <i>int main()</i> em C, se torna <MAIN></MAIN> em VAL). Sendo assim, especificaremos todos os nossos returns baseados em como esses tokens serão chamados na linguagem, além dos tipos de variáveis que iremos trabalhar (inteiro, digito, real, booleano, string e outros).

<li><b>MainLex.java | MainSint.java</b></li>
São responsáveis por criar os arquivos auxiliares a serem utilizados no código. Como exemplo, ao executar a MainLex.java, obteremos o arquivo Lexer.java, necessário para a verificação dos tokens por nossa interface.

<li><b>Token.java</b></li>
O arquivo gerado tokens.java é responsável por manter o identificador de todos os tokens da nossa linguagem.

<li><b>Parser.cup</b></li>
É o principal arquivo responsável por verificar o código sintaticamente. Para isso, define-se quais identificadores serão <b>terminais</b> e <b>não-terminais</b>, uma vez será realizada a derivação do código até obtermos apenas símbolos terminais, de forma que o compilador possa interpretar o código inserido.

<li><b>Sym.java</b></li>
Contém todos os símbolos terminais como tokens servindo como auxiliar do Yylex.java.

<li><b>Yylex.java</b></li>
Por fim, o Yylex.java será o arquivo responsável por gerar os retornos para a interface dos resultados obtidos a partir da análise sintática, tomando como base os tokens especificados e como as estruturas deverão ser montadas. Por exemplo, sabemos que uma função principal deve ser precedida por um conjunto de operações dentro dela. Caso esse critério não seja cumprido, obteremos um erro sintático do código.
</ol>

## Comandos Úteis
1. Comando para compilar o Parser.cup:

<b>java -jar <i>local_da_biblioteca/.../java-cup-11a.jar</i> -parser Parser -symbols Sym Parser.cup</b>


## 👏 Como Contribuir

O principal propósito deste repositório e agregar conhecimento e auxiliar no processo de aprendizagem acadêmica de como funciona um compilador na prática, além de ajudar no processo de criação de novas linguagens a partir das bibliotecas mencionadas. Sabemos que ainda existem recursos a serem melhorados (como exemplo, realizar a análise semântica do código) e aceitaremos <i>commit's</i> externos nas próximas versões para possíveis melhorias no código. 
