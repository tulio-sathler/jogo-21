package br.com.blackjack.constants;

import br.com.blackjack.model.Carta;
import br.com.blackjack.model.enums.Naipe;
import br.com.blackjack.model.enums.Valor;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static List<Carta> listaCartas() {
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta(Naipe.ESPADAS, Valor.AS, false));
        cartas.add(new Carta(Naipe.PAUS, Valor.REI, false));
        cartas.add(new Carta(Naipe.COPAS, Valor.DAMA, false));
        return cartas;
    }
}
