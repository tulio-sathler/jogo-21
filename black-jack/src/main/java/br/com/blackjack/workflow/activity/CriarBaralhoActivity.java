package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Baralho;
import br.com.blackjack.model.Carta;
import br.com.blackjack.model.enums.Naipe;
import br.com.blackjack.model.enums.Valor;
import br.com.blackjack.workflow.activity.generico.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CriarBaralhoActivity implements BaseActivity<Void, Void, Baralho> {

    private EmbaralharActivity embaralharActivity;

    public CriarBaralhoActivity() {
        embaralharActivity = new EmbaralharActivity();
    }

    @Override
    public Baralho doExecute(Void input, Void context) {

        List<Carta> listaCartas = new ArrayList<>();

        Arrays.stream(Naipe.values()).forEach((naipe) -> Arrays.stream(Valor.values()).
                forEach(valor -> listaCartas.add(Carta.builder().naipe(naipe).valor(valor).build())
                ));

        embaralharActivity.doExecute(listaCartas, null);

        return Baralho.builder().cartas(listaCartas).build();

    }


}
