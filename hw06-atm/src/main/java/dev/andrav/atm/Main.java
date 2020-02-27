package dev.andrav.atm;

import dev.andrav.atm.currency.Banknote;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Banknote<?>> cash = DemoData.getDemoData();

        ATM atm = new ATMImpl();
        atm.init();
        atm.deposit(cash);
        atm.getBalanceATM();
    }
}
