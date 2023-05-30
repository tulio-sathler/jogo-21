package br.com.blackjack.workflow;

import br.com.blackjack.constants.Constants;
import br.com.blackjack.model.Baralho;
import br.com.blackjack.model.Carta;
import br.com.blackjack.model.Jogo;
import br.com.blackjack.model.Pessoa;
import br.com.blackjack.workflow.activity.CriarBaralhoActivity;
import br.com.blackjack.workflow.activity.CriarParticipanteActivity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InicializarJogoWorkflowTest {

    @InjectMocks
    private InicializarJogoWorkflow target;
    @Mock
    private Scanner scanner;
    @Mock
    private FluxoJogoWorkFlow fluxoJogoWorkFlow;
    @Mock
    private CriarBaralhoActivity criarBaralhoActivity;
    @Mock
    private CriarParticipanteActivity criarParticipanteActivity;


    @Test
    void doExecuteTest() {
        Jogo jogo = new Jogo();
        List<Carta> mao = Constants.listaCartas();

        Pessoa pessoa = Pessoa.builder().mao(mao).nome("Jogador").build();
        Baralho baralho = Baralho.builder().cartas(mao).build();

        jogo.setBaralho(baralho);
        jogo.getBaralho().setCartas(Constants.listaCartas());

        Pessoa dealer = new Pessoa("deler", mao);
        Pessoa jogador = new Pessoa("jogador", mao);

        jogo.setDealer(dealer);
        jogo.setJogador(jogador);

        when(criarBaralhoActivity.doExecute(any(), any())).thenReturn(baralho);
        when(criarParticipanteActivity.doExecute(any(), any())).thenReturn(pessoa);
        when(fluxoJogoWorkFlow.doExecute(any(), any())).thenReturn(jogo);
        when(scanner.nextLine()).thenReturn("nome");

        target.doExecute(jogo, null);

        verify(criarBaralhoActivity, times(1)).doExecute(any(), any());
        verify(criarParticipanteActivity, times(2)).doExecute(any(), any());
        verify(fluxoJogoWorkFlow, times(1)).doExecute(any(),any());
        verify(scanner, times(1)).nextLine();
    }
}
