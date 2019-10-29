<h1 align="center">
  <a href="https://github.com/liviagranato/trabalho-compiladores">
    Analisador Léxico e Sintático | Linguagem VAL
  </a>
</h1>

<h3 align="center">
  O que é?
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

O analisador léxico e sintático é um projeto desenvolvido pelos alunos André Arantes, Livia Granato e Victor Pereira para a disciplina de Compiladores do curso de Engenharia da Computação da Universidade Federal de Itajubá. A partir de uma linguagem criada e especificada totalmente pelos alunos, o projeto tem por objetivo verificar uma implementação correta do código avaliando em dois critérios: <b>Avaliação Léxica</b> e <b>Avaliação Sintática</b>.

Ao inserir um código, especificar um tipo de análise e realizar o processo de compilação (através do botão <i>COMPILAR</i>), a interface criada (tentamos tornar o mais similar de uma IDE) denominada <i>Codekit</i> será responsável por exibir os retornos e resultados da análise para o código, assim como apresentar possíveis erros durante a escrita. 

## 📖 Requisitos

Para execução do programa, é necessário ter o ambiente Netbeans IDE instalado no computador (recomenda-se a v8.0.1), Java JDK devidamente instalado, além das bibliotecas <b>Java-Cup-11a.jar</b>, <b>Java_Cup.jar</b> e <b>JFlex.jar</b> que estão disponíveis dentro do projeto.

## 🎉 Primeiros Passos

Para programar na linguagem "VAL", disponibilizamos o arquivo <b>Linguagens_Formais.pdf</b> onde especificamos todos os tokens que poderão ser utilizados, além de demonstrar também os compiladores acionados por eles durante o processo de compilação.

## Comandos Úteis
1. Comando para compilar o Parser.cup:

<b>java -jar <i>local_da_biblioteca/.../java-cup-11a.jar</i> -parser Parser -symbols Sym Parser.cup</b>


## 👏 Como Contribuir

O principal propósito deste repositório e agregar conhecimento e auxiliar no processo de aprendizagem acadêmica de como funciona um compilador na prática, além de ajudar no processo de criação de novas linguagens a partir das bibliotecas mencionadas. Sabemos que ainda existem recursos a serem melhorados (como exemplo, realizar a análise semântica do código) e aceitaremos <i>commit's</i> externos nas próximas versões para possíveis melhorias no código. 
