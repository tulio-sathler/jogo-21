package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Jogo;
import br.com.blackjack.model.Pessoa;
import br.com.blackjack.workflow.activity.generico.BaseActivity;


public class DistribuirCartasActivity implements BaseActivity<Jogo, Void, Void> {

    private PegarCartaBaralhoActivity pegarCartaBaralhoActivity;
    private CriarBaralhoActivity criarBaralhoActivity;

    public DistribuirCartasActivity() {
        pegarCartaBaralhoActivity = new PegarCartaBaralhoActivity();
        criarBaralhoActivity = new CriarBaralhoActivity();
    }


    @Override
    public Void doExecute(Jogo jogo, Void context) {

        if (jogo.getBaralho().getCartas().size() < 4) {
            jogo.setBaralho(criarBaralhoActivity.doExecute(null, null));
        }

        Pessoa maoDealer = jogo.getDealer();
        Pessoa maoJogador = jogo.getJogador();

        pegarCartaBaralhoActivity.doExecute(maoDealer, jogo.getBaralho());
        pegarCartaBaralhoActivity.doExecute(maoJogador, jogo.getBaralho());

        pegarCartaBaralhoActivity.doExecute(maoDealer, jogo.getBaralho());
        pegarCartaBaralhoActivity.doExecute(maoJogador, jogo.getBaralho());

        maoDealer.getMao().get(1).setMostrarCarta(false);

        return null;
    }
}
