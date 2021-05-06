package mc322.lab05a;

public class Tabuleiro {

    public Peça[][] tabuleiro = {
            {null, new Peao('p', 0, 1), null, new Peao('p', 0, 3),
                    null, new Peao('p', 0, 5), null, new Peao('p', 0, 7)},
            {new Peao('p', 1, 0), null, new Peao('p', 1, 2 ), null,
                    new Peao('p', 1, 4), null, new Peao('p', 1, 6), null},
            {null, new Peao('p', 2, 1), null, new Peao('p', 2, 3),
                    null, new Peao('p', 2, 5), null, new Peao('p', 2, 7)},

            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},

            {new Peao('b', 5, 0), null, new Peao('b', 5, 2), null,
                    new Peao('b', 5, 4), null, new Peao('b', 5, 6), null},
            {null, new Peao('b', 6, 1), null, new Peao('b', 6, 3),
                    null, new Peao('b', 6, 5), null, new Peao('b', 6, 7)},
            {new Peao('b', 7, 0), null, new Peao('b', 7, 2), null,
                    new Peao('b', 7, 4), null, new Peao('b', 7, 6), null},
    };

    public void rodarEntradas(String[] entrada) {
        for (String movimento : entrada){
            solicitaMovimento(movimento);
            System.out.println("Posição Inicial: " + movimento.charAt(0) + movimento.charAt(1));
            System.out.println("Posição Final: " + movimento.charAt(3) + movimento.charAt(4));
            imprimirTabuleiro();
        }
    }

    private int getColuna(char x) {
        return (int)x - 97;
    }

    private int getLinha(char x) {
        int y = x - '0';
        return 8 - y;
    }

    private int checarDiagonais(Peça[] caminho, int linhaDestino, int colunaDestino){
        int linhaAtual = caminho[0].linha; int colunaAtual = caminho[0].coluna;
        int i = 1;
        linhaAtual--; colunaAtual--;
        while((linhaAtual >= 0) || (colunaAtual >= 0)){
            caminho[i] = tabuleiro[linhaAtual][colunaAtual];
            if((linhaDestino == linhaAtual) && (colunaDestino == colunaAtual)) {
                return i + 1;
            }
            linhaAtual--; colunaAtual--; i++;
        }
        linhaAtual = caminho[0].linha; colunaAtual = caminho[0].coluna; i = 1;
        while((linhaAtual >= 0) || (colunaAtual <= 7)) {
            caminho[i] = tabuleiro[linhaAtual][colunaAtual];
            if((linhaDestino == linhaAtual) && (colunaDestino == colunaAtual)) {
                return i + 1;
            }
            linhaAtual--; colunaAtual--; i++;
        }
        linhaAtual = caminho[0].linha; colunaAtual = caminho[0].coluna; i = 1;
        while((linhaAtual <= 7) || (colunaAtual <= 7)) {
            caminho[i] = tabuleiro[linhaAtual][colunaAtual];
            if((linhaDestino == linhaAtual) && (colunaDestino == colunaAtual)) {
                return i + 1;
            }
            linhaAtual--; colunaAtual--; i++;
        }
        linhaAtual = caminho[0].linha; colunaAtual = caminho[0].coluna; i = 1;
        while((linhaAtual <= 7) || (colunaAtual >= 0)) {
            caminho[i] = tabuleiro[linhaAtual][colunaAtual];
            if((linhaDestino == linhaAtual) && (colunaDestino == colunaAtual)) {
                return i + 1;
            }
            linhaAtual--; colunaAtual--; i++;
        }
        return 0;
    }

    private void solicitaMovimento(String entrada){
        int colunaOrigem = getColuna(entrada.charAt(0));
        int linhaOrigem = getLinha(entrada.charAt(1));
        int colunaDestino = getColuna(entrada.charAt(3));
        int linhaDestino = getLinha(entrada.charAt(4));

        if((tabuleiro[linhaOrigem][colunaOrigem] == null)
                || (tabuleiro[linhaDestino][colunaDestino] != null)){
            System.out.println("Movimento invalido!");
            return ;
        }

        char tipo = tabuleiro[linhaOrigem][colunaOrigem].tipo;
        char cor = tabuleiro[linhaOrigem][colunaOrigem].cor;

        // CAMINHO QUE A PEÇA VAI FAZER
        Peça[] caminho = new Peça[8];
        int tamanho = 1;
        caminho[0] = tabuleiro[linhaOrigem][colunaOrigem];


        if(cor == 'p' && tipo == 'p'){
            // se o peão se mover apenas uma vez
            if(linhaDestino == linhaOrigem + 1) {
                if((colunaDestino == colunaOrigem + 1) || (colunaDestino == colunaOrigem - 1)) {
                    caminho[1] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho++;
                }
            }
            else if(linhaDestino == linhaOrigem) {
                if(colunaDestino == colunaOrigem + 4){
                    caminho[1] = tabuleiro[linhaOrigem + 1][colunaOrigem + 1];
                    caminho[2] = tabuleiro[linhaOrigem + 2][colunaOrigem + 2];
                    caminho[3] = tabuleiro[linhaOrigem + 1][colunaOrigem + 3];
                    caminho[4] = tabuleiro[linhaOrigem][colunaOrigem + 4];
                    tamanho+=4;
                } else if (colunaDestino == colunaOrigem - 4){
                    caminho[1] = tabuleiro[linhaOrigem + 1][colunaOrigem - 1];
                    caminho[2] = tabuleiro[linhaOrigem + 2][colunaOrigem - 2];
                    caminho[3] = tabuleiro[linhaOrigem + 1][colunaOrigem - 3];
                    caminho[4] = tabuleiro[linhaOrigem][colunaOrigem - 4];
                    tamanho+=4;
                }
            }
            // se o peão faz um movimento e captura simples
            else if(linhaDestino == linhaOrigem + 2) {
                if(colunaDestino == colunaOrigem + 2) {
                    caminho[1] = tabuleiro[linhaOrigem + 1][colunaOrigem + 1];
                    caminho[2] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=2;
                } else if (colunaDestino == colunaOrigem - 2) {
                    caminho[1] = tabuleiro[linhaOrigem + 1][colunaOrigem - 1];
                    caminho[2] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=2;
                }
            }
            // se o peão fazer um movimento de zigue e zague
            else if(linhaDestino == linhaOrigem + 4) {
                if(colunaDestino == colunaOrigem) {
                    caminho[1] = tabuleiro[linhaOrigem + 1][colunaOrigem + 1];
                    caminho[2] = tabuleiro[linhaOrigem + 2][colunaOrigem + 2];
                    caminho[3] = tabuleiro[linhaOrigem + 3][colunaOrigem + 1];
                    caminho[4] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=4;
                    if(!caminho[0].requisitarMovimento(caminho, tamanho)) {
                        caminho[1] = tabuleiro[linhaOrigem + 1][colunaOrigem - 1];
                        caminho[2] = tabuleiro[linhaOrigem + 2][colunaOrigem - 2];
                        caminho[3] = tabuleiro[linhaOrigem + 3][colunaOrigem - 1];
                        caminho[4] = tabuleiro[linhaDestino][colunaDestino];
                    }
                } else if (colunaDestino == colunaOrigem + 4) {
                    caminho[1] = tabuleiro[linhaOrigem + 1][colunaOrigem + 1];
                    caminho[2] = tabuleiro[linhaOrigem + 2][colunaOrigem + 2];
                    caminho[3] = tabuleiro[linhaOrigem + 3][colunaOrigem + 3];
                    caminho[4] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=4;
                } else if (colunaDestino == colunaOrigem - 4) {
                    caminho[1] = tabuleiro[linhaOrigem + 1][colunaOrigem - 1];
                    caminho[2] = tabuleiro[linhaOrigem + 2][colunaOrigem - 2];
                    caminho[3] = tabuleiro[linhaOrigem + 3][colunaOrigem - 3];
                    caminho[4] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=4;
                }

            }

        } else if (cor == 'b' && tipo == 'p') {
            // se o peão se mover apenas uma vez
            if(linhaDestino == linhaOrigem - 1) {
                if((colunaDestino == colunaOrigem + 1) || (colunaDestino == colunaOrigem - 1)) {
                    caminho[1] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho = 2;
                }
            }
            else if(linhaDestino == linhaOrigem) {
                if(colunaDestino == colunaOrigem + 4){
                    caminho[1] = tabuleiro[linhaOrigem - 1][colunaOrigem + 1];
                    caminho[2] = tabuleiro[linhaOrigem - 2][colunaOrigem + 2];
                    caminho[3] = tabuleiro[linhaOrigem - 1][colunaOrigem + 3];
                    caminho[4] = tabuleiro[linhaOrigem][colunaOrigem + 4];
                    tamanho+=4;
                } else if (colunaDestino == colunaOrigem - 4){
                    caminho[1] = tabuleiro[linhaOrigem - 1][colunaOrigem - 1];
                    caminho[2] = tabuleiro[linhaOrigem - 2][colunaOrigem - 2];
                    caminho[3] = tabuleiro[linhaOrigem - 1][colunaOrigem - 3];
                    caminho[4] = tabuleiro[linhaOrigem][colunaOrigem - 4];
                    tamanho+=4;
                }
            }
            // se o peão faz um movimento e captura simples
            else if(linhaDestino == linhaOrigem - 2) {
                if(colunaDestino == colunaOrigem + 2) {
                    caminho[1] = tabuleiro[linhaOrigem - 1][colunaOrigem + 1];
                    caminho[2] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=2;
                } else if (colunaDestino == colunaOrigem - 2) {
                    caminho[1] = tabuleiro[linhaOrigem - 1][colunaOrigem - 1];
                    caminho[2] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=2;
                }
            }
            // se o peão fazer um movimento de zigue e zague
            else if(linhaDestino == linhaOrigem - 4) {
                if(colunaDestino == colunaOrigem) {
                    caminho[1] = tabuleiro[linhaOrigem - 1][colunaOrigem + 1];
                    caminho[2] = tabuleiro[linhaOrigem - 2][colunaOrigem + 2];
                    caminho[3] = tabuleiro[linhaOrigem - 3][colunaOrigem + 1];
                    caminho[4] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=4;
                    if(!caminho[0].requisitarMovimento(caminho, tamanho)) {
                        caminho[1] = tabuleiro[linhaOrigem - 1][colunaOrigem - 1];
                        caminho[2] = tabuleiro[linhaOrigem - 2][colunaOrigem - 2];
                        caminho[3] = tabuleiro[linhaOrigem - 3][colunaOrigem - 1];
                        caminho[4] = tabuleiro[linhaDestino][colunaDestino];
                        tamanho+=4;
                    }
                } else if (colunaDestino == colunaOrigem + 4) {
                    caminho[1] = tabuleiro[linhaOrigem - 1][colunaOrigem + 1];
                    caminho[2] = tabuleiro[linhaOrigem - 2][colunaOrigem + 2];
                    caminho[3] = tabuleiro[linhaOrigem - 3][colunaOrigem + 3];
                    caminho[4] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=4;
                } else if (colunaDestino == colunaOrigem - 4) {
                    caminho[1] = tabuleiro[linhaOrigem - 1][colunaOrigem - 1];
                    caminho[2] = tabuleiro[linhaOrigem - 2][colunaOrigem - 2];
                    caminho[3] = tabuleiro[linhaOrigem - 3][colunaOrigem - 3];
                    caminho[4] = tabuleiro[linhaDestino][colunaDestino];
                    tamanho+=4;
                }

            }
        }
        else if(tipo == 'd') {
            tamanho = checarDiagonais(caminho, linhaDestino, colunaDestino);
            if(tamanho == 0) {
                System.out.println("TESTE");
                System.out.println("Movimento invalido!");
                return ;
            }
        }



        if(caminho[0].requisitarMovimento(caminho, tamanho)){
            System.out.println("tamanho:" + tamanho);
            if(tabuleiro[linhaOrigem][colunaOrigem].tipo == 'p') {
                tabuleiro[linhaDestino][colunaDestino] = new Peao(cor, linhaDestino, colunaDestino);
            } else {
                tabuleiro[linhaDestino][colunaDestino] = new Dama(cor, linhaDestino, colunaDestino);
            }
            tabuleiro[linhaOrigem][colunaOrigem] = null;
            for(int i = 1; i < (tamanho - 1); i++){
                if(caminho[i] != null) {
                    tabuleiro[caminho[i].linha][caminho[i].coluna] = null;
                }
            }
            if((linhaDestino == 7 && cor == 'p') || (linhaDestino == 0 && cor == 'b')){
                tabuleiro[linhaDestino][colunaDestino] = new Dama(cor, linhaDestino, colunaDestino);
            }
        } else {
            System.out.println("Movimento invalido!");
        }

    }

    public void imprimirTabuleiro() {
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            tab.append((8 - i));
            for (int j = 0; j < 8; j++) {
                if (tabuleiro[i][j] == null) {
                    tab.append(" -");
                }
                else if (tabuleiro[i][j].tipo == 'p') {
                    if (tabuleiro[i][j].cor == 'p') {
                        tab.append(" p");
                    } else {
                        tab.append(" b");
                    }
                } else {
                    if (tabuleiro[i][j].cor == 'p') {
                        tab.append(" P");
                    } else {
                        tab.append(" B");
                    }
                }
            }
            tab.append("\n");
        }
        tab.append("  a b c d e f g h\n");
        System.out.println(tab);
    }

    public String[] exportarArquivo(){
        String[] estado = new String[64];
        int celula = 0;
        for(int i = 0; i < 8; i++) { //coluna
            for(int j = 7; j >= 0; j--) { //linha
                estado[celula] = (char) (i + 'a') +
                        Character.toString((char)( (8 - j) + '0'));
                if(tabuleiro[j][i] == null) {
                    estado[celula] += '_';
                } else {
                    estado[celula] += tabuleiro[j][i].cor;
                }
                celula++;
            }
        }
        return estado;
    }
}
