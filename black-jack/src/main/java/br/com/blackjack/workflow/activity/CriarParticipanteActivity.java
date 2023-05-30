package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Pessoa;
import br.com.blackjack.workflow.activity.generico.BaseActivity;

import java.util.ArrayList;


public class CriarParticipanteActivity implements BaseActivity<String, Void, Pessoa> {

    @Override
    public Pessoa doExecute(String nome, Void context) {

        return Pessoa.builder().nome(nome).mao(new ArrayList<>()).build();

    }
}
