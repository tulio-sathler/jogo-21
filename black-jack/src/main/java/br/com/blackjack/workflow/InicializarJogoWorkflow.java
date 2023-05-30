package br.com.blackjack.workflow;

import br.com.blackjack.model.Jogo;
import br.com.blackjack.model.Pessoa;
import br.com.blackjack.workflow.activity.CriarBaralhoActivity;
import br.com.blackjack.workflow.activity.CriarParticipanteActivity;
import br.com.blackjack.workflow.activity.generico.BaseActivity;
import lombok.AllArgsConstructor;

import java.util.Scanner;


@AllArgsConstructor
public class InicializarJogoWorkflow implements BaseActivity<Jogo, Void, Jogo> {

    Scanner scanner = new Scanner(System.in);

    private FluxoJogoWorkFlow fluxoJogoWorkFlow;
    private CriarBaralhoActivity criarBaralhoActivity;
    private CriarParticipanteActivity criarParticipanteActivity;


    //Essa injeção seria feita por spring mas como não estou utilizando, tive que fazer na mão.
    public InicializarJogoWorkflow() {
        criarBaralhoActivity = new CriarBaralhoActivity();
        criarParticipanteActivity = new CriarParticipanteActivity();
        fluxoJogoWorkFlow = new FluxoJogoWorkFlow();

    }

    @Override
    public Jogo doExecute(Jogo jogo, Void unused) {
        String nome;

        jogo.setBaralho(criarBaralhoActivity.doExecute(null, null));

        System.out.println("Para começar, digite o nome que gostaria de ser chamado(a): ");

        nome = scanner.nextLine();

        Pessoa jogador = criarParticipanteActivity.doExecute(nome, null);
        jogo.setJogador(jogador);

        Pessoa dealer = criarParticipanteActivity.doExecute("Dealer", null);
        jogo.setDealer(dealer);

        fluxoJogoWorkFlow.doExecute(jogo, null);

        return null;

    }

}
