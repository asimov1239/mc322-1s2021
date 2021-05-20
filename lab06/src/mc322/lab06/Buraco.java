package mc322.lab06;

public class Buraco extends Componente {

    Buraco(){
        super.id = 'B';
    }

    /*Se o herói cair no buraco,
    * ele morre e perde 1000 pontos*/
    public void rodarInteracao(Heroi heroi){
        System.out.println("Presta atenção onde você anda, tu morreu... caiu em um buraco e vai ficar preso para sempre!");
        heroi.pontuacao -= 1000;
        heroi.vivo = false;
    }

}
