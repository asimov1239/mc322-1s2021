package mc322.lab05b;

public class AppDama {

    public static void executaJogo(String entrada, String saida) {
        Tabuleiro tabuleiro = new Tabuleiro();
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(entrada);
        csv.setDataExport(saida);
        tabuleiro.rodarEntradas(csv.requestCommands());
        csv.exportState(tabuleiro.exportarArquivo());
    }

    public static void main(String[] args) {
        executaJogo(args[0], args[1]);
    }

}
