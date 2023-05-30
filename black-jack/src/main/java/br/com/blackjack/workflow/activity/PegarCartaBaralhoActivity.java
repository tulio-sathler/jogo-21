package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Baralho;
import br.com.blackjack.model.Carta;
import br.com.blackjack.model.Pessoa;
import br.com.blackjack.workflow.activity.generico.BaseActivity;

public class PegarCartaBaralhoActivity implements BaseActivity<Pessoa, Baralho, Pessoa> {

    @Override
    public Pessoa doExecute(Pessoa pessoa, Baralho baralho) {
        Carta carta = baralho.getCartas().remove(0);

        pessoa.getMao().add(carta);

        System.out.println(String.format(" -- %s pegou uma carta." , pessoa.getNome()));

        return pessoa;

    }
}
