package dev.andrav.hw06.atm;

import dev.andrav.hw06.currency.Banknote;

import java.util.List;

public interface ATM<T> {
    void init();

    //<T extends Banknote<? extends MyCurrency>> void deposit(List<? extends T> banknote);
    List<Banknote<?>> deposit(List<T> banknote);

    List<? super T> withdraw(int amount);
    //<T extends Banknote<? extends MyCurrency>> List<? super T> withdraw(int amount);

    void getBalanceATM();

}
