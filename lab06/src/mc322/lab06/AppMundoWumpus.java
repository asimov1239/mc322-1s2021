package mc322.lab06;

public class AppMundoWumpus {

    static void executaJogo(String entrada) {
        Montador montador = new Montador(entrada);
        Heroi heroi = montador.retornarHeroi();
        Controle controle = new Controle(heroi);
        controle.rodarJogo();
    }


    public static void main(String[] args) {
        executaJogo(args[0]);
    }
}
