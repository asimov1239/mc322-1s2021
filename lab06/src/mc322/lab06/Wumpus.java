package mc322.lab06;

import java.util.Random;

public class Wumpus extends Componente{

    Wumpus(){
        super.id = 'w';
    }

    public void rodarInteracao(Heroi heroi) {
        if(heroi.caverna.salas[linha][coluna].visitada){
            return;
        }
        System.out.println("Você encontrou o WUMPUS! SE PREPARA PARA A TRETA...");
        if(heroi.flechaready) {
            Random random = new Random();
            if(random.nextInt(99) <= 49) {
                id = 'x';
                heroi.wumpus = true;
                heroi.pontuacao += 500;
                System.out.println("VOCÊ CONSEGUIU A CABEÇA DE WUMPUS! PARABENS HEROI!");
            } else {
                heroi.id = 'x';
                heroi.vivo = false;
                heroi.pontuacao -= 1000;
                System.out.println("Você atirou seu próprio joelho, parabens, jovem, tu morreu.");
            }
            heroi.flechaready = false;
            heroi.flecha = false;
        } else {
            System.out.println("mas você não preparou a flecha jovem... tu morreu.");
            heroi.vivo = false;
        }
    }
}
