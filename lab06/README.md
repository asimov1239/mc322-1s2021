## Arquivos .java
Segue o link para os arquivos java:
[lab06](src/mc322/lab06)


## Instruções

Para rodar o Mundo de Wumpus, basta passar como argumento o caminho do arquivo .csv na pasta [data](data)!

## Destaques de Arquitetura

Segue alguns destaques do código:


### `Delegando o máximo de campos a cada objeto que lhe diz respeito`

~~~java
public class Heroi extends Componente {
    boolean ouro = false;
    boolean wumpus = false;
    boolean resultado = false;
    boolean flechaready = false;
    boolean flecha = true;
    boolean vivo = true;
    Caverna caverna;
    int pontuacao = 0;
    
    (...)
}   
~~~

> No destaque acima, observamos o uso de campos booleanos para variáveis que só dizem respeito à classe Heroi, como a pontuação, ouro e flecha. Esses valores em si funcionam como centro do resto da arquitetura, ditando o andamento do programa. 

~~~java
public class Sala {
    int qtdecomp = 0;
    boolean visitada = false;
    Componente[] comp = new Componente[4];
    int linha, coluna;
    
    (...)   
}
~~~

> Nesse destaque, obse valores que dizem respeito apenas ao objeto Sala, como a quantidade de componentes na sala, ou o boolean visitada que diz respeito se ela já foi explorada pelo herói, até uma array de componentes junto com linha e coluna. Essas váriaveis são uteis na hora de acessar valores especificos da sala, sem a necessidade de ser citadas em outras classes, melhorando assim o fluxo de comunicação.

### `Explorando ao máximo o polimorfismo`

~~~java
public class Sala {
    int qtdecomp = 0;
    Componente[] comp = new Componente[4];
    
    (...)
}   
~~~

> O polimorfismo foi  essencial  na hora de enfileirar os componentes em sua respectiva sala. Foi fácil utilizar um array de componentes para armazenar cada um, sejam eles brisa, fedor ou até o próprio Heroi, o qual saia e entrava da sala de acordo com o jogo. Utilizando o inteiro qtdecomp, foi possível manter rastro da quantidade de componentes dentro da sala, facilitando assim na hora de usar o println para enviar a informação correta ao usuário.

~~~java
public class Componente {
    char id;
    int linha, coluna;

    public void rodarInteracao(Heroi heroi) {
    }
} 
~~~

> Cada um dos componentes possui um método herdado `rodarInteração`, a qual facilita na hora de implementar novos componentes. O objetivo desse método é mudar os valores do herói e printar as informações necessárias para o usuário assim que o herói entra na sala. Observa-se também que cada um dos componentes possui sua própria id, isso é, o caracter necessário para identificar o componente, facilitando na hora de fazer o println e ordenar corretamente qual componente deve ser informada primeiro. 



