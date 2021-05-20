package mc322.lab06;

public class Fedor extends Componente{

    Fedor(){
        super.id = 'f';
    }

    /*
    * Semelhante à classe Brisa, o rodarInteracao
    * do Fedor apenas retorna uma informação ao usuário,
    * isso é, o Wumpus está em uma sala adjacente
    * */
    public void rodarInteracao(Heroi heroi) {
        System.out.println("Você sente um fedor...");
    }

}
