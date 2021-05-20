package mc322.lab06;

public class Caverna {
    /*Campo com a matriz das salas*/
    public Sala[][] salas = {
            {new Sala(0, 0), new Sala(0, 1), new Sala(0, 2), new Sala(0, 3)},
            {new Sala(1, 0), new Sala(1, 1), new Sala(1, 2), new Sala(1, 3 )},
            {new Sala(2, 0), new Sala(2, 1), new Sala(2, 2 ), new Sala(2, 3 )},
            {new Sala(3, 0), new Sala(3, 1), new Sala(3, 2), new Sala(3, 3)},
    };


    public void printarCaverna() {
        for(int i = 0; i < 4; i++) {
            System.out.print(i + 1);
            System.out.print(" ");
            for(int j = 0; j < 4; j++){
                String c = salas[i][j].retornarPrioridade();
                System.out.print(c);
            }
            System.out.print("\n");
        }
        System.out.println("  1 2 3 4");
    }
}
