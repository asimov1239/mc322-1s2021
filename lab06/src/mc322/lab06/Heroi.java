package mc322.lab06;

public class Heroi extends Componente {

    /*Segue todas as informações importantes ao Heroi,
    * incluindo uma refêrencia a caverna seguindo a
    * arquitetura proposta.
    */
    boolean ouro = false;
    boolean wumpus = false;
    boolean resultado = false;
    boolean flechaready = false;
    boolean flecha = true;
    boolean vivo = true;
    Caverna caverna;
    int pontuacao = 0;

    Heroi(){
        super.id = 'h';
    }

    // No final de cada iteração, a função atualizara o resultado do heroi
    private void checarResultado(){
        if(linha == 0 && coluna == 0 && ouro) {
            pontuacao += 1000;
            resultado = true;
        }
    }


    // Rodar comando utiliza uma função switch para analisar cada caso
    void rodarComando(String comando) {
        switch (comando) {
            case "w" -> subir();
            case "s" -> descer();
            case "a" -> esquerda();
            case "d" -> direita();
            case "k" -> equiparFlecha();
            case "c" -> capturarOuro();
            case "q" -> vivo = false;
            default -> System.out.println("Comando Inválido");
        }
        /*No final da função, o resultado é checado,
        * a caverna é printada junto com a pontuação
        */
        checarResultado();
        caverna.printarCaverna();
        System.out.println("Pontuacao: " + this.pontuacao);
    }

    //método que analisa se a flecha foi gastada a toa
    void atirarFlecha() {
        if(!caverna.salas[linha][coluna].checarWumpus() && flechaready){
            System.out.println("VOCÊ ATIRA A FLECHA... mas não tem motivo pra isso... parabéns...");
            pontuacao -= 100;
            flechaready = false;
            flecha = false;
        }
    }

    /*
    * Os próximos métodos atualizam a posição do herói na caverna junto com
    * atualizar os pontos e checar para ver se a flecha foi atirada a toa
    * */
    void subir(){
        if(linha - 1 >= 0) {
            caverna.salas[linha-1][coluna].explorarSala(this);
            pontuacao -= 15;
            atirarFlecha();
        } else {
            System.out.println("Você está fugindo da caverna!");
        }
    }

    void descer(){
        if(linha + 1 < 4) {
            caverna.salas[linha+1][coluna].explorarSala(this);
            pontuacao -= 15;
            atirarFlecha();
        } else {
            System.out.println("Você está fugindo da caverna!");
        }
    }

    void direita(){
        if(coluna + 1 < 4) {
            caverna.salas[linha][coluna+1].explorarSala(this);
            pontuacao -= 15;
            atirarFlecha();
        } else {
            System.out.println("Você está fugindo da caverna!");
        }
    }

    void esquerda(){
        if(coluna - 1 >= 0) {
            caverna.salas[linha][coluna-1].explorarSala(this);
            pontuacao -= 15;
            atirarFlecha();
        } else {
            System.out.println("Você está fugindo da caverna!");
        }
    }

    void equiparFlecha(){
        // Checando para ver se existe uma flecha na aljava
        if(flecha) {
            System.out.println("VOCÊ ESTÁ PREPARADO PARA ATIRAR!");
            flechaready = true;
        } else {
            System.out.println("Você estaria preparado para atirar... se você tivesse alguma flecha...");
        }
    }

    /*
    * Esse método possui uma refêrencia a caverna, depois a sala para
    * checar se existe ouro no lugar em que o herói está
    * */
    void capturarOuro() {
        if (caverna.salas[linha][coluna].checarOuro()){
            ouro = true;
            System.out.println("Você pegou o ouro!");
        } else {
            System.out.println("Você não encontra nenhum ouro!");
        }

    }



}
