package mc322.lab06;

public class Heroi extends Componente {
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

    private void checarResultado(){
        if(linha == 0 && coluna == 0 && ouro) {
            pontuacao += 1000;
            resultado = true;
        }
    }


    void rodarComando(String comando) {
        if(comando.equals("w")) {
            subir();
        } else if (comando.equals("s")) {
            descer();
        } else if (comando.equals("a")) {
            esquerda();
        } else if (comando.equals("d")) {
            direita();
        } else if (comando.equals("k")) {
            equiparFlecha();
        } else if (comando.equals("c")) {
            capturarOuro();
        } else if (comando.equals("q")) {
            vivo = false;
        } else {
            System.out.println("Comando Inválido");
        }
        checarResultado();
        caverna.printarCaverna();
        System.out.println("Pontuacao: " + this.pontuacao);
    }

    void atirarFlecha() {
        if(!caverna.salas[linha][coluna].checarWumpus() && flechaready){
            System.out.println("VOCÊ ATIRA A FLECHA... mas não tem motivo pra isso... parabéns...");
            pontuacao -= 100;
            flechaready = false;
            flecha = false;
        }
    }

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

    void capturarOuro() {
        if (caverna.salas[linha][coluna].checarOuro()){
            ouro = true;
            System.out.println("Você pegou o ouro!");
        } else {
            System.out.println("Você não encontra nenhum ouro!");
        }

    }



}
