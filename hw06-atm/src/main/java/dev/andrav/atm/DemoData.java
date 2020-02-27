package dev.andrav.atm;

import dev.andrav.atm.currency.Banknote;
import dev.andrav.atm.currency.MyCurrency;
import dev.andrav.atm.currency.RUB;
import dev.andrav.atm.currency.USD;

import java.util.ArrayList;
import java.util.List;

public class DemoData {
    public static <T extends Banknote<? extends MyCurrency>> List<T> getDemoData() {
        List<T> listBanknotes = new ArrayList<>();
        int i;
        for (i = 0; i < 1; i++) {
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(100)));
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(500)));
            listBanknotes.add((T) new Banknote<MyCurrency>(USD.getInstance(50)));
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(100)));
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(1000)));
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(5000)));
        }
        return listBanknotes;
    }
}
