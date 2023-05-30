package br.com.blackjack.workflow.activity;

import br.com.blackjack.constants.Constants;
import br.com.blackjack.model.Baralho;
import br.com.blackjack.model.Carta;
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
public class PegarCartaBaralhoActivityTest {

    @InjectMocks
    private PegarCartaBaralhoActivity target;

    @Test
    void doExecutePegarCartaBaralho() {
        Pessoa pessoa = new Pessoa("Jogador", new ArrayList<>());
        Baralho baralho = new Baralho(Constants.listaCartas());
        int tamanhoMaoInicial = pessoa.getMao().size();

        Pessoa resultado = target.doExecute(pessoa, baralho);

        assertEquals(tamanhoMaoInicial + 1, resultado.getMao().size());

    }


}
