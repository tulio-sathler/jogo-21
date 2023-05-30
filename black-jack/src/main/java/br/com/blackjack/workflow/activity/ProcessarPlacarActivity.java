package br.com.blackjack.workflow.activity;

import br.com.blackjack.contants.Constants;
import br.com.blackjack.model.Jogo;
import br.com.blackjack.model.enums.Placar;
import br.com.blackjack.workflow.activity.generico.BaseActivity;


public class ProcessarPlacarActivity implements BaseActivity<Placar, Jogo, Jogo> {

    @Override
    public Jogo doExecute(Placar placar, Jogo jogo) {
        switch (placar) {
            case GANHOU:
                jogo.setVitorias(jogo.getVitorias() + 1);
                System.out.println(Constants.ganhou);
                break;
            case PERDEU:
                jogo.setDerrotas(jogo.getDerrotas() + 1);
                System.out.println(Constants.perdeu);
                break;
            case EMPATOU:
                jogo.setEmpate(jogo.getEmpate() + 1);
                System.out.println(Constants.empate);
                break;
        }
        System.out.println(String.format(" -- Placar: Vitorias - %s, Derrotas - %s, Empates - %s", jogo.getVitorias(), jogo.getDerrotas(), jogo.getEmpate()));

        return jogo;
    }
}
