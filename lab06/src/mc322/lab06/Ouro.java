package mc322.lab06;

public class Ouro extends Componente{

    Ouro(){
        super.id = 'o';
    }

    public void rodarInteracao(Heroi heroi) {
        if(heroi.caverna.salas[linha][coluna].visitada && heroi.ouro == true){
            return;
        }
        System.out.println("Ouro encontrado... só falta pega-lo!");
    }

}
