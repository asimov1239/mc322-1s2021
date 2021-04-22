package mc322.lab04;

public class RestaUm {
    // Usando um array para cada linha torna-se mais fácil estudar cada uma das linhas
    String[] tabuleiro = {"     P P P    ","     P P P    "," P P P P P P P"," P P P - P P P"," P P P P P P P","     P P P    ","     P P P    "};

   /*
   * Método responsável por printar o tabuleiro
   * */
    void printarTab(){
        for(int i = 0; i < tabuleiro.length; i++){
            System.out.println(7 - i + tabuleiro[i]);
        }
        System.out.println("  a b c d e f g\n");
    }


    /*
     *   Para acessar a posição na string, usamos os seguintes métodos:
     *       - getRow retorna o valor correspondente a linha na array do tabuleiro
     *       - getColumn retorna a posição do caracter em uma das linhas
     * */
    int getColumn(int column) {
        return (column * 2) + 1;
    }


    int getRow(int row) {
        return 7 - row;
    }


    void mudarTab(String comando) {

        //Esses são as posições da source e da target
        int sourceColumn = comando.charAt(0) - 97;
        int sourceRow = comando.charAt(1) - 48;
        int targetColumn = (comando.charAt(3) - 97);
        int targetRow = comando.charAt(4) - 48;

        // Encontrar os devidos caracteres para checar se a jogada é válida
        char source = tabuleiro[getRow(sourceRow)].charAt(getColumn(sourceColumn));
        char target = tabuleiro[getRow(targetRow)].charAt(getColumn(targetColumn));

        //Calcular a posição da peça entre a source e o target para ser removida
        if((source == 'P') && (target == '-')){
            int changeRow = 0, changeColumn = 0;
            if (sourceColumn == targetColumn) {
                changeColumn = sourceColumn;
                if (targetRow > sourceRow) {
                    changeRow = sourceRow + 1;
                } else {
                    changeRow = sourceRow - 1;
                }
            } else if (sourceRow == targetRow) {
                changeRow = sourceRow;
                if (targetColumn > sourceColumn) {
                    changeColumn = sourceColumn + 1;
                } else {
                    changeColumn = sourceColumn - 1;
                }
            }

            sourceRow = getRow(sourceRow);
            sourceColumn = getColumn(sourceColumn);
            targetRow = getRow(targetRow);
            targetColumn = getColumn(targetColumn);
            changeRow = getRow(changeRow);
            changeColumn = getColumn(changeColumn);


            //Enfim efetuar a mudança das linhas criando uma newRow e substituindo cada uma delas
            String newRow = tabuleiro[sourceRow].substring(0, sourceColumn) + '-' +
                    tabuleiro[sourceRow].substring(sourceColumn + 1);
            tabuleiro[sourceRow] = newRow;

            newRow = tabuleiro[targetRow].substring(0, targetColumn) + 'P' +
                    tabuleiro[targetRow].substring(targetColumn + 1);
            tabuleiro[targetRow] = newRow;

            newRow = tabuleiro[changeRow].substring(0, changeColumn) + '-' +
                    tabuleiro[changeRow].substring(changeColumn + 1);
            tabuleiro[changeRow] = newRow;

        } else {
            System.out.println("Jogada Inválida!");
        }

    }


}
