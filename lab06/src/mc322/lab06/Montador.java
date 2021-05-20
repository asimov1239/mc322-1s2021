package mc322.lab06;

public class Montador {
    Caverna caverna;
    String entrada;
    String[][] salas;
    Heroi heroi;


    /*
    * O construtor do montador atualiza cada um de seus campos de acordo
    * com o caminho do .csv
    * */
    Montador(String entrada) {
        this.heroi = new Heroi();
        this.caverna = new Caverna();
        this.entrada = entrada;
        this.salas = montarSalas(entrada);
        this.caverna = montarCaverna(salas);
        this.heroi.caverna = this.caverna;
    }

    /*
    * Esse método possui quatro condicionais atualizando os arredores do wumpus
    * ou do buraco.
    * */
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

    /*
     * Usando o parâmetro das salas, é o principal método
     * ao atualizar a caverna com cada componente
     *  */
    private Caverna montarCaverna(String[][] salas) {

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

    /*
    * Retorna o vetor de salas de acordo com o arquivo csv
    * utilizado como argumento
    * */
    private String[][] montarSalas(String entrada) {
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(entrada);
        return csv.requestCommands();
    }

    // Retorna o herói para iniciar o controle
    public Heroi retornarHeroi(){
        return this.heroi;
    }

}
