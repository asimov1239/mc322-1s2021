package mc322.lab04;

public class AppRestaUm {

    public static void main(String[] args) {
	    CSVReader csv = new CSVReader();
	    csv.setDataSource("../lab04/src/mc322/lab04/bonfa.csv");
	    String[] commands = csv.requestCommands();
	    RestaUm jogo = new RestaUm();

        System.out.println("Tabuleiro Inicial:");
        jogo.printarTab();
        for (String command : commands) {
            System.out.println("Source: " + command.charAt(0) + commands[0].charAt(1));
            System.out.println("Target: " + command.charAt(3) + commands[0].charAt(4));
            jogo.mudarTab(command);
            jogo.printarTab();
        }
    }
}
