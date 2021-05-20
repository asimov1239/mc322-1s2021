package mc322.lab06;

public class Ouro extends Componente{

    Ouro(){
        super.id = 'o';
    }

    /*
    * A interação do ouro possui um condicional para checar se o herói já pegou o ouro,
    * se ele já pegou não há necessidade de informar o usuário que existe um ouro no
    * lugar
    * */
    public void rodarInteracao(Heroi heroi) {
        if(heroi.caverna.salas[linha][coluna].visitada && heroi.ouro == true){
            return;
        }
        System.out.println("Ouro encontrado... só falta pega-lo!");
    }

}
