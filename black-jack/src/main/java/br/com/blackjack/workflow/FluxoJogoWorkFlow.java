package br.com.blackjack.workflow;

import br.com.blackjack.contants.Constants;
import br.com.blackjack.model.Jogo;
import br.com.blackjack.model.enums.Placar;
import br.com.blackjack.workflow.activity.*;
import br.com.blackjack.workflow.activity.generico.BaseActivity;
import lombok.AllArgsConstructor;

import java.util.Scanner;


@AllArgsConstructor
public class FluxoJogoWorkFlow implements BaseActivity<Jogo, Void, Jogo> {

    Scanner scanner = new Scanner(System.in);

    private DistribuirCartasActivity distribuirCartasActivity;
    private MostrarMaosActivity mostrarMaosActivity;
    private ProcessarOpcoesDoJogadorActivity processarOpcoesDoJogadorActivity;
    private ProcessarPlacarActivity processarPlacarActivity;
    private ProcessarAcoesDealerActivity processarAcoesDealerActivity;
    private LimpaMaoJogadoresActivity limpaMaoJogadoresActivity;

    //Essa injeção seria feita por spring mas como não estou utilizando, tive que fazer na mão.
    public FluxoJogoWorkFlow() {
        distribuirCartasActivity = new DistribuirCartasActivity();
        mostrarMaosActivity = new MostrarMaosActivity();
        processarOpcoesDoJogadorActivity = new ProcessarOpcoesDoJogadorActivity();
        processarPlacarActivity = new ProcessarPlacarActivity();
        processarAcoesDealerActivity = new ProcessarAcoesDealerActivity();
        limpaMaoJogadoresActivity = new LimpaMaoJogadoresActivity();
    }

    @Override
    public Jogo doExecute(Jogo jogo, Void unused) {

        boolean desejaJogarNovamente = false;
        Integer pontosDealer = 0;

        do {

            distribuirCartasActivity.doExecute(jogo, null);

            mostrarMaosActivity.doExecute(jogo, null);

            Integer pontosJogador = processarOpcoesDoJogadorActivity.doExecute(jogo, null);
            Boolean placarProcessado = null;

            if (pontosJogador > 21) {
                placarProcessado = processaFinalizacao(Placar.PERDEU, jogo, null);
            } else {
                pontosDealer = processarAcoesDealerActivity.doExecute(jogo, null);

                if (pontosDealer > 21) {
                    placarProcessado = processaFinalizacao(Placar.GANHOU, jogo, pontosDealer);

                }
            }

            if (placarProcessado != null) {
                if (placarProcessado) {
                    desejaJogarNovamente = true;
                    continue;
                } else {
                    break;
                }
            }

            Placar status;

            if (pontosJogador < pontosDealer) {
                status = Placar.PERDEU;
            } else if (pontosJogador > pontosDealer) {
                status = Placar.GANHOU;
            } else {
                status = Placar.EMPATOU;
            }

            desejaJogarNovamente = processaFinalizacao(status, jogo, pontosDealer);

        } while (desejaJogarNovamente);

        return null;
    }

    public boolean processaFinalizacao(Placar status, Jogo jogo, Integer pontosDealer) {

        if (pontosDealer != null) {
            System.out.println(" -- A mão do Dealer é: ");
            jogo.getDealer().mostraMao();

            System.out.println(String.format("O total da mão do Dealer é: %s", pontosDealer));
        }

        processarPlacarActivity.doExecute(status, jogo);

        System.out.println(" -- Deseja jogar novamente? 1 - Continuar ou qualquer NUMERO para sair");

        Boolean desejaJogarNovamente = scanner.nextInt() == 1;

        if(!desejaJogarNovamente) {
            System.out.println(Constants.fimDeJogo);
        }

        limpaMaoJogadoresActivity.doExecute(jogo, null);

        return desejaJogarNovamente;

    }

}
