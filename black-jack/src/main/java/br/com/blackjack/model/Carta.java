package br.com.blackjack.model;

import br.com.blackjack.model.enums.Naipe;
import br.com.blackjack.model.enums.Valor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Carta {

    private Naipe naipe;
    private Valor valor;

    @Builder.Default
    private Boolean mostrarCarta = true;

    public String toString() {
        if (!mostrarCarta) {
            return " -- A segunda carta está oculta";
        }

        return String.format(" -- %s %s (%s)", valor, naipe, valor.valorCarta);
    }

}
