package mc322.lab06;

public class Sala {
    int qtdecomp = 0;
    boolean visitada = false;
    Componente[] comp = new Componente[4];
    int linha, coluna;


    Sala(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public void novoComponente(Componente c) {
        c.linha = this.linha;
        c.coluna = this.coluna;
        comp[qtdecomp] = c;
        qtdecomp++;
    }

    public void explorarSala(Heroi heroi){
        for (int i = 0; i < qtdecomp; i++) {
            comp[i].rodarInteracao(heroi);
        }
        visitada = true;
        heroi.caverna.salas[heroi.linha][heroi.coluna].qtdecomp--;
        novoComponente(heroi);
    }

    public boolean checarOuro(){
        for(int i = 0; i < qtdecomp; i++){
            if (comp[i].id == 'o'){
                comp[i].id = 'x';
                return true;
            }
        }
        return false;
    }

    public boolean checarWumpus(){
        for(int i = 0; i < qtdecomp; i++){
            if (comp[i].id == 'w'){
                return true;
            }
        }
        return false;
    }

    public String retornarPrioridade() {
        if(visitada) {
            if(qtdecomp == 0) {
                return "#";
            }
            for(int i = 0; i < qtdecomp; i++){
                if(comp[i].id == 'h') {
                    return "P";
                } else if(comp[i].id == 'w') {
                    return "W";
                } else if(comp[i].id == 'B') {
                    return "B";
                }
            }
            for(int i =0; i < qtdecomp;i++){
                if(comp[i].id == 'o'){
                    return "O";
                }
            }
            String prioridade = null;
            for(int i = 0; i < qtdecomp; i++) {
                if(comp[i].id == 'f'){
                    return "f";
                } else if (comp[i].id == 'b') {
                    prioridade = "b";
                }
            }
            if(prioridade == null) {
                return "-";
            }
            return prioridade;
        }
        return "-";
    }
}
