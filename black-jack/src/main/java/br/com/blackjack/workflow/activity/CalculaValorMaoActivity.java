package br.com.blackjack.workflow.activity;

import br.com.blackjack.model.Carta;
import br.com.blackjack.workflow.activity.generico.BaseActivity;

import java.util.List;

public class CalculaValorMaoActivity implements BaseActivity<List<Carta>, Void, Integer> {

    @Override
    public Integer doExecute(List<Carta> mao, Void unused) {
        Integer valor = 0;
        Integer numeroAs = 0;


        for(Carta carta: mao){
            if(!carta.getMostrarCarta()) {
                continue;
            }
            valor += carta.getValor().valorCarta;
            if (carta.getValor().valorCarta == 11){
                numeroAs ++;
            }
        }

        if (valor > 21 && numeroAs > 0){
            while(numeroAs > 0 && valor > 21){
                numeroAs --;
                valor -= 10;
            }
        }

        return valor;
    }

}
