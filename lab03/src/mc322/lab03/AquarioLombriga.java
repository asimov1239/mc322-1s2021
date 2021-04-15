package mc322.lab03;

public class AquarioLombriga {
    int tamLombriga, tamAquario;
    int pos;
    boolean lado = true;

    AquarioLombriga(int tamLombriga, int tamAquario, int pos){
        this.tamLombriga = tamLombriga;
        this.tamAquario = tamAquario;
        this.pos = pos;
    }

    public void Crescer(){
            tamLombriga++;
            pos--;
    }

    public void Mover(){
        if (lado){
            pos++;
        } else {
            pos--;
        }
    }

    public void Virar(){
        lado = !lado;
    }

    public String Apresenta(){
        String lombriga = "";
        boolean aquario = true;
        for(int i = 1; i <= tamAquario; i++) {
            if(pos == i) {
                aquario = false;
                if(!lado) {
                    lombriga = lombriga + '0';
                    continue;
                }
            } else if ((pos + tamLombriga - 1) == i) {
                if (lado) {
                    lombriga = lombriga + '0';
                } else {
                    lombriga = lombriga + '@';
                }
                aquario = true;
                continue;
            }

            if(aquario) {
                lombriga = lombriga + '#';
            } else {
                lombriga = lombriga + '@';
            }

        }
        return lombriga;
    }
}



