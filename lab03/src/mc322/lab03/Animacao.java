package mc322.lab03;

public class Animacao {
    AquarioLombriga lombriga;
    String comandos;
    int passoAtual = 0;

    Animacao(String comando){
        int tamAquario = Integer.parseInt(comando.substring(0, 2));
        int tamLombriga = Integer.parseInt(comando.substring(2, 4));
        int pos = Integer.parseInt(comando.substring(4, 6));
        this.comandos = comando.substring(6);
        this.lombriga = new AquarioLombriga(tamLombriga, tamAquario, pos);
        Apresenta();
    }


    public void Apresenta() {
        System.out.println(lombriga.Apresenta());
    }

    public void Passo() {
        char passo = this.comandos.charAt(passoAtual);
        if (passo == 'C'){
            lombriga.Crescer();
        } else if(passo == 'M') {
            lombriga.Mover();
        } else {
            lombriga.Virar();
        }
        this.passoAtual++;
    }
}
