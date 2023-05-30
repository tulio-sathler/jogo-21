package br.com.blackjack.model.enums;

public enum Naipe {
    OURO("♦"),
    COPAS("♥"),
    ESPADAS("♠"),
    PAUS("♣");
    String nomeNaipe;

    Naipe(String nomeNaipe) {
        this.nomeNaipe = nomeNaipe;
    }

    public String toString() {
        return nomeNaipe;
    }

}
