package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Jogo;
import br.com.blackjack.workflow.activity.generico.BaseActivity;

public class LimpaMaoJogadoresActivity implements BaseActivity<Jogo, Void, Void> {

    @Override
    public Void doExecute(Jogo jogo, Void context) {
        jogo.getJogador().getMao().clear();
        jogo.getDealer().getMao().clear();

        return null;
    }
}
