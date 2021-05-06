package mc322.lab05a;

public class Dama extends Peça {

    Dama(char cor, int linha, int coluna){
        this.tipo = 'd';
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
    }

    boolean requisitarMovimento(Peça[] caminho, int tamanho) {
        boolean captura = false;
        if(tamanho == 2){
            return true;
        }
        for(int i = 1, j = 1; i < tamanho; i++) {
            if(caminho[i] != null) {
                captura = true;
            }
            if(captura) {
                if(j%2 == 0) {
                    if(caminho[i] != null) {
                        return false;
                    }
                } else {
                    if(caminho[i] == null || caminho[i].cor == cor) {
                        return false;
                    }
                }
                j++;
            }
        }
        return true;
    }

}
