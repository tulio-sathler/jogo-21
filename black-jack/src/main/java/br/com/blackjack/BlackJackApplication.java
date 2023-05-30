package br.com.blackjack;

import br.com.blackjack.model.Jogo;
import br.com.blackjack.workflow.InicializarJogoWorkflow;


public class BlackJackApplication {

    private static final InicializarJogoWorkflow inicializarJogoWorkflow = new InicializarJogoWorkflow();


    public static void main(String[] args) {
        System.out.println("  /$$$$$  /$$$$$$   /$$$$$$   /$$$$$$         /$$$$$$    /$$  \n" +
                "   |__  $$ /$$__  $$ /$$__  $$ /$$__  $$       /$$__  $$ /$$$$  \n" +
                "      | $$| $$  \\ $$| $$  \\__/| $$  \\ $$      |__/  \\ $$|_  $$  \n" +
                "      | $$| $$  | $$| $$ /$$$$| $$  | $$        /$$$$$$/  | $$  \n" +
                " /$$  | $$| $$  | $$| $$|_  $$| $$  | $$       /$$____/   | $$  \n" +
                "| $$  | $$| $$  | $$| $$  \\ $$| $$  | $$      | $$        | $$  \n" +
                "|  $$$$$$/|  $$$$$$/|  $$$$$$/|  $$$$$$/      | $$$$$$$$ /$$$$$$\n" +
                " \\______/  \\______/  \\______/  \\______/       |________/|______/\n" +
                "                                                                ");
        inicializarJogoWorkflow.doExecute(new Jogo(), null);

    }

}
