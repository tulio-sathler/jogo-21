package br.com.blackjack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Baralho {

    private List<Carta> cartas;

}
