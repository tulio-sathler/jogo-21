package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CriarParticipanteActivityTest {

    @InjectMocks
    private CriarParticipanteActivity target;


    @Test
    void doExecuteCriaParticipanteSucesso() {
        Pessoa pessoa = Pessoa.builder().nome("Teste").mao(new ArrayList<>()).build();

        var retorno = target.doExecute(pessoa.getNome(), null);

        assertEquals(pessoa, retorno);

    }
}


