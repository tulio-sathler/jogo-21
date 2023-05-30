package br.com.blackjack.workflow.activity;

import br.com.blackjack.constants.Constants;
import br.com.blackjack.model.Baralho;
import br.com.blackjack.model.Carta;
import br.com.blackjack.model.Jogo;
import br.com.blackjack.model.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DistribuirCartasActivityTest {

    @InjectMocks
    private DistribuirCartasActivity target;

    @Mock
    private PegarCartaBaralhoActivity pegarCartaBaralhoActivity;

    @Mock
    private CriarBaralhoActivity criarBaralhoActivity;

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


        when(pegarCartaBaralhoActivity.doExecute(any(), any())).thenReturn(pessoa);
        when(criarBaralhoActivity.doExecute(any(), any())).thenReturn(baralho);

        target.doExecute(jogo, null);

        assertEquals(3, jogo.getBaralho().getCartas().size());

        verify(pegarCartaBaralhoActivity, times(4)).doExecute(any(), any());
        verify(criarBaralhoActivity, times(1)).doExecute(any(), any());

    }

}
