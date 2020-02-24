package dev.andrav.atm;

import dev.andrav.atm.currency.Banknote;
import java.util.Collection;

public class ATMImpl implements ATM {
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
