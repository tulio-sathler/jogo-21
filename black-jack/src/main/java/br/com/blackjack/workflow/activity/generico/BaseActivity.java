package br.com.blackjack.workflow.activity.generico;

public interface BaseActivity<I, C, O> {
    public O doExecute(I input, C context);

}
