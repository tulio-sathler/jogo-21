package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Jogo;
import br.com.blackjack.model.Pessoa;
import br.com.blackjack.workflow.activity.generico.BaseActivity;



public class MostrarMaosActivity implements BaseActivity<Jogo, Void, Void> {

    private CalculaValorMaoActivity calculaValorMaoActivity;

    public MostrarMaosActivity() {
        calculaValorMaoActivity = new CalculaValorMaoActivity();
    }

    @Override
    public Void doExecute(Jogo jogo, Void context) {
        Pessoa dealer = jogo.getDealer();
        Pessoa jogador = jogo.getJogador();

        System.out.println(String.format("\n -- A mão do Dealer é: "));
        dealer.mostraMao();

        System.out.println(String.format(" -- Total: %s\n", calculaValorMaoActivity.doExecute(dealer.getMao(), null)));

        System.out.println(String.format(" -- A mão do Jogador %s é:", jogador.getNome()));
        jogador.mostraMao();

        System.out.println(String.format(" -- Total: %s\n", calculaValorMaoActivity.doExecute(jogador.getMao(), null)));

        return null;
    }
}
