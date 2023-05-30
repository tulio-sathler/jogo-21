package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Carta;
import br.com.blackjack.workflow.activity.generico.BaseActivity;

import java.util.Collections;
import java.util.List;
import java.util.Random;


public class EmbaralharActivity implements BaseActivity<List<Carta>, Void, Void> {
    @Override
    public Void doExecute(List<Carta> baralho, Void unused) {
        Collections.shuffle(baralho, new Random());

        return null;
    }
}
