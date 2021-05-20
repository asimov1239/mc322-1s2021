package mc322.lab06;

public class Montador {
    Caverna caverna;
    String entrada;
    String[][] salas;
    Heroi heroi;

    Montador(String entrada) {
        this.heroi = new Heroi();
        this.caverna = new Caverna();
        this.entrada = entrada;
        this.salas = montarSalas(entrada);
        this.caverna = montarCaverna(salas);
        this.heroi.caverna = this.caverna;
    }

    private void componenteAdjacente(Componente x, int linha, int coluna) {
        int adjlinha = linha + 1; int adjcoluna = coluna;
        if (adjlinha >= 0 && adjcoluna >= 0
                && adjlinha < 4 && adjcoluna < 4) {
            caverna.salas[adjlinha][adjcoluna].novoComponente(x);
        }
        adjlinha = linha - 1;
        if (adjlinha >= 0 && adjcoluna >= 0
                && adjlinha < 4 && adjcoluna < 4) {
            caverna.salas[adjlinha][adjcoluna].novoComponente(x);
        }
        adjlinha = linha; adjcoluna = coluna + 1;
        if (adjlinha >= 0 && adjcoluna >= 0
                && adjlinha < 4 && adjcoluna < 4) {
            caverna.salas[adjlinha][adjcoluna].novoComponente(x);
        }
        adjcoluna = coluna - 1;
        if (adjlinha >= 0 && adjcoluna >= 0
                && adjlinha < 4 && adjcoluna < 4) {
            caverna.salas[adjlinha][adjcoluna].novoComponente(x);
        }
    }


    private Caverna montarCaverna(String[][] salas) {
//        for(int i = 0; i < salas.length; i++){
//            for(int j = 0; j < salas[i].length; j++) {
//                System.out.print(salas[i][j]);
//                System.out.print("  ");
//            }
//            System.out.print("\n");
//        }

        for(int i = 0; i < salas.length; i++) {
            String sala = salas[i][0];
            int linha = Character.getNumericValue(sala.charAt(0));
            int coluna = Character.getNumericValue(sala.charAt(2));
            char componente = salas[i][1].charAt(0);

            if (componente == 'P') {
                Heroi h = new Heroi();
                caverna.salas[linha - 1][coluna - 1].novoComponente(h);
                heroi = h;
            } else if (componente == 'W') {
                Componente w = new Wumpus();
                caverna.salas[linha - 1][coluna - 1].novoComponente(w);
                Componente f = new Fedor();
                componenteAdjacente(f, linha - 1, coluna - 1);
            } else if (componente == 'B') {
                Componente B = new Buraco();
                caverna.salas[linha - 1][coluna - 1].novoComponente(B);
                Componente b = new Brisa();
                componenteAdjacente(b, linha - 1, coluna - 1);
            } else if (componente == 'O') {
                Componente o = new Ouro();
                caverna.salas[linha - 1][coluna - 1].novoComponente(o);
            }
         }
        return caverna;
    }

    private String[][] montarSalas(String entrada) {
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(entrada);
        return csv.requestCommands();
    }

    public Heroi retornarHeroi(){
        return this.heroi;
    }

}
