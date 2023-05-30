package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Carta;
import br.com.blackjack.model.Jogo;
import br.com.blackjack.model.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MostrarMaosActivityTest {

    @InjectMocks
    private MostrarMaosActivity target;

    @Mock
    private CalculaValorMaoActivity calculaValorMaoActivity;

    @Test
    void doExecute() {
        Jogo jogo = new Jogo();
        List<Carta> mao = new ArrayList<>();
        Pessoa dealer = new Pessoa("deler", mao);
        Pessoa jogador = new Pessoa("jogador", mao);

        jogo.setDealer(dealer);
        jogo.setJogador(jogador);

        when(calculaValorMaoActivity.doExecute(anyList(), any())).thenReturn(2);

        target.doExecute(jogo, null);

        verify(calculaValorMaoActivity, times(2)).doExecute(anyList(), any());

    }

}
