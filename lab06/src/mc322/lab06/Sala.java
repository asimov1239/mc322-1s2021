package mc322.lab06;

public class Sala {
    int qtdecomp = 0;
    boolean visitada = false;
    //Esse campo marca os componentes que existem na sala
    Componente[] comp = new Componente[4];
    int linha, coluna;


    Sala(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    /*
    * Adiciona um novo componente a sala, usando
    * polimorfismo é fácil adicionar qualquer herdeiro
    * */
    public void novoComponente(Componente c) {
        c.linha = this.linha;
        c.coluna = this.coluna;
        comp[qtdecomp] = c;
        qtdecomp++;
    }

    /*Função chamada pelo herói
    * na hora de explorar a próxima sala,
    * mudando o booleano assim como adicionando
    * o herói como componente*/
    public void explorarSala(Heroi heroi){
        for (int i = 0; i < qtdecomp; i++) {
            comp[i].rodarInteracao(heroi);
        }
        visitada = true;
        heroi.caverna.salas[heroi.linha][heroi.coluna].qtdecomp--;
        novoComponente(heroi);
    }


    /*
    * Os dois próximos métodos checam para ver se o ouro ou o wumpus estão
    * na sala
    * */
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

    /*Essa função
    * retorna o componente com maior
    * prioridade na hora de printar
    * */
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
