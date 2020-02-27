package dev.andrav.atm;

import dev.andrav.atm.currency.Banknote;
import dev.andrav.atm.currency.MyCurrency;

import java.util.List;

public interface ATM {
    void init();

    <T extends Banknote<? extends MyCurrency>> void deposit(List<T> banknote);

    <T extends Banknote<? extends MyCurrency>> List<T> withdraw(int amount);

    void getBalanceATM();

}
