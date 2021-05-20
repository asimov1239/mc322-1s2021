package mc322.lab06;

public class Brisa extends Componente {

    Brisa(){
        super.id = 'b';
    }

    /*Para o caso da brisa
    * só é necessário um aviso para o usuário
    * de que existe um buraco por perto.
    * */
    public void rodarInteracao(Heroi heroi) {
        System.out.println("Você sente uma brisa...");
    }

}
