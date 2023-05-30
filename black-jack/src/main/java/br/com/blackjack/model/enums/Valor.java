package br.com.blackjack.model.enums;

public enum Valor {

    AS("Ás", 11),
    DOIS("2", 2),
    TRES("3", 3),
    QUATRO("4",4),
    CINCO("5",5),
    SEIS("6",6),
    SETE("7",7),
    OITO("8",8),
    NOVE("9",9),
    DEZ("10",10),
    VALETE("J",10),
    DAMA("Q",10),
    REI("K",10);

    public String nomeCarta;
    public Integer valorCarta;

    Valor(String nomeCarta, Integer valorCarta) {
        this.nomeCarta = nomeCarta;
        this.valorCarta = valorCarta;
    }

    public String toString() {
        return nomeCarta;
    }
}
