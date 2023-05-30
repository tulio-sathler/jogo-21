package br.com.blackjack.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class Pessoa {

    @NonNull
    private String nome;

    @NonNull
    private List<Carta> mao;

    public void mostraMao() {
        mao.stream().forEach(carta -> System.out.println(carta.toString()));
    }

}
