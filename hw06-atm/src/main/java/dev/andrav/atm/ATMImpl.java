package dev.andrav.atm;

import dev.andrav.atm.currency.Banknote;
import dev.andrav.atm.currency.MyCurrency;
import java.util.Collection;

public class ATMImpl implements ATM {

    /*private Class<? extends MyCurrency> currencyClass;
    private CellBox<Cell<Banknote<?>>> cellBox;
    private BanknoteAnalyzer<Banknote<?>> analyzer;*/


    @Override
    public void deposit(Collection<Banknote<?>> banknote) {

    }

    @Override
    public Collection<Banknote<?>> withdraw(int amount) {
        return null;
    }

    @Override
    public int getBalanceATM() {
        return 0;
    }
}
