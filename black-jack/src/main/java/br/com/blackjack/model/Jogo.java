package br.com.blackjack.model;

import lombok.Data;

@Data
public class Jogo {

    private Baralho baralho;

    private Pessoa jogador, dealer;

    private Integer vitorias, derrotas, empate;

    public Jogo() {
        vitorias = 0;
        derrotas = 0;
        empate = 0;

    }

}
