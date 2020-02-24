package dev.andrav.atm;

import dev.andrav.atm.currency.Banknote;
import java.util.Collection;

public interface ATM {

    void deposit(Collection<Banknote<?>> banknote);

    Collection<Banknote<?>> withdraw(int amount);

    int getBalanceATM();
}
