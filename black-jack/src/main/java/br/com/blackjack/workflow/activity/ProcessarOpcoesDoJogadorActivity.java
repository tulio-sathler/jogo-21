package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Jogo;
import br.com.blackjack.workflow.activity.generico.BaseActivity;

import java.util.Scanner;


public class ProcessarOpcoesDoJogadorActivity implements BaseActivity<Jogo, Void, Integer> {

    private CalculaValorMaoActivity calculaValorMaoActivity;
    private PegarCartaBaralhoActivity pegarCartaBaralhoActivity;

    public ProcessarOpcoesDoJogadorActivity() {
        calculaValorMaoActivity = new CalculaValorMaoActivity();
        pegarCartaBaralhoActivity = new PegarCartaBaralhoActivity();
    }

    @Override
    public Integer doExecute(Jogo jogo, Void context) {

        Scanner scanner = new Scanner(System.in);
        Integer escolhaJogador;
        Integer pontosJogador;

        do {

            System.out.println(" -- O que você deseja fazer agora? (1 Comprar , 2- Parar)");

            escolhaJogador = scanner.nextInt();
            switch (escolhaJogador) {
                case 1:
                    pegarCartaBaralhoActivity.doExecute(jogo.getJogador(), jogo.getBaralho());

                    System.out.println(String.format("\n -- %s sua nova mão é: ", jogo.getJogador().getNome()));
                    jogo.getJogador().mostraMao();

                    break;
                case 2:
                    break;
                default:
                    System.out.println(" -- Número Invalido, tente novamente.");

            }
            pontosJogador = calculaValorMaoActivity.doExecute(jogo.getJogador().getMao(), null);
            System.out.println(String.format("\n -- Total de pontos: %s\n", pontosJogador));

        } while (escolhaJogador != 2 && pontosJogador < 21);

        return pontosJogador;
    }
}
