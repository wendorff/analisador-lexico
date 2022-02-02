# analisador-lexico
Um analisador léxico simples desenvolvido por Cícero Wendorff e Yann Dihl, utilizando Java para a disciplina de Teoria da Computação. 

"Implementar um analisador léxico que receba, como entrada, um arquivo txt contendo um código, e o processe gerando, como saída, um outro arquivo txt, contendo a listagem dos tokens reconhecidos e o código reescrito, substituindo identificadores de variáveis e constantes numéricas por id e num, respectivamente.
Para tanto, o analisador léxico deverá processar trechos de código que possuem identificadores, constantes numéricas (inteiras ou fracionárias), operadores de atribuição (=), operadores aritméticos (+, -, * e /) e símbolos especiais (ponto e vírgula e parênteses).

<b>Passo a passo para a utilização: </b>

1. Criar um documento de texto com o código a ser analisado pelo software. O código deverá ser padronizado conforme exemplo dado na definição do trabalho: 

```
nota1 = 8.0;
nota2 = 6.0;
media = (nota1+nota2)/2;

``` 

2. Após a adição desse arquivo será necessário informar o caminho completo para o software através da declaração disponível no arquivo ```Main.java```, conforme exemplo: 

```
Analisador anas = new Analisador("C://caminho/para/arquivo.txt");

```

Caso o diretório destino seja copiado através do File Explorer, revisar a orientação das barras na variável uma vez que o File Explorer utiliza barras invertidas para o caminho. ("C:\\caminho\com\barrras\invalidas")

3. Execute o arquivo ```Main.Java```. Haverá uma saída no console e também a criação de um arquivo. Caso o código inserido seja válido, o analisador criará um arquivo resultado.txt no diretório raiz de onde o sistema está localizado (mesmo nível hierarquico da pasta /src) e gerará uma saída estrutura no console.
Caso o código seja inválido o sistema lançará uma Exception avisando em qual linha do código o erro está localizado. Essa saída não cria um arquivo. 


