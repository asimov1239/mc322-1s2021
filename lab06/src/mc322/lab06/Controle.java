package mc322.lab06;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Controle {
    Heroi heroi;

    Controle(Heroi heroi) {
        this.heroi = heroi;
    }

    void rodarJogo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = keyboard.nextLine();
        heroi.caverna.salas[0][0].visitada = true;
        heroi.caverna.printarCaverna();
        while(heroi.vivo && !heroi.resultado) {
            String command = keyboard.nextLine();
            heroi.rodarComando(command);
            System.out.println("Player: " + nome);
        }
        if(heroi.vivo == false) {
            System.out.println("Boa sorte da próxima vez!");
        } else {
            System.out.println("Parabéns, você venceu! Só tenta não gastar o ouro de uma só vez.");
        }
    }

}
