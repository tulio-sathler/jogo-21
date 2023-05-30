package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Carta;
import br.com.blackjack.model.Jogo;
import br.com.blackjack.workflow.activity.generico.BaseActivity;

import java.util.List;

public class ProcessarAcoesDealerActivity implements BaseActivity<Jogo, Void, Integer> {

    private CalculaValorMaoActivity calculaValorMaoActivity;
    private PegarCartaBaralhoActivity pegarCartaBaralhoActivity;

    public ProcessarAcoesDealerActivity() {
        calculaValorMaoActivity = new CalculaValorMaoActivity();
        pegarCartaBaralhoActivity = new PegarCartaBaralhoActivity();
    }

    @Override
    public Integer doExecute(Jogo jogo, Void context) {
        List<Carta> maoDealer = jogo.getDealer().getMao();
        maoDealer.stream().forEach(carta -> carta.setMostrarCarta(true));

        Integer pontosDealer = calculaValorMaoActivity.doExecute(maoDealer, null);

        while (pontosDealer < 17) {
            pegarCartaBaralhoActivity.doExecute(jogo.getDealer(), jogo.getBaralho());
            pontosDealer = calculaValorMaoActivity.doExecute(maoDealer, null);
        }

        return pontosDealer;
    }
}
