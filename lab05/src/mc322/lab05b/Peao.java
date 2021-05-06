package mc322.lab05b;

public class Peao extends Peça {

    Peao(char cor, int linha, int coluna){
        this.tipo = 'p';
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
    }

    boolean requisitarMovimento(Peça[] caminho, int tamanho) {
        if (tamanho == 2){
            return true;
        }
        for(int i = 1; i < tamanho; i++){
            if(i%2 == 0){
                if(caminho[i] != null) {
                    return false;
                }
            } else {
                if(caminho[i] == null || caminho[i].cor == cor) {
                    return  false;
                }
            }
        }
        return true;
    }


}
