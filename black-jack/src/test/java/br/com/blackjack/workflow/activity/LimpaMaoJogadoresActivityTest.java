package br.com.blackjack.workflow.activity;

import br.com.blackjack.constants.Constants;
import br.com.blackjack.model.Carta;
import br.com.blackjack.model.Jogo;
import br.com.blackjack.model.Pessoa;
import br.com.blackjack.model.enums.Naipe;
import br.com.blackjack.model.enums.Valor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LimpaMaoJogadoresActivityTest {

    @InjectMocks
    private LimpaMaoJogadoresActivity target;

    @Test
    void doExecute() {
        Jogo jogo = new Jogo();
        List<Carta> mao = Constants.listaCartas();
        Pessoa dealer = new Pessoa("deler", mao);
        Pessoa jogador = new Pessoa("jogador", mao);

        jogo.setJogador(jogador);
        jogo.setDealer(dealer);

        target.doExecute(jogo, null);

        int tamanhoMaoInicial = jogador.getMao().size();
        int tamanhoMaoInicialDealer = dealer.getMao().size();

        assertEquals(0,tamanhoMaoInicial);
        assertEquals(0, tamanhoMaoInicialDealer);

    }

}
