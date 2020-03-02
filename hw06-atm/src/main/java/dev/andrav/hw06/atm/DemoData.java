package dev.andrav.hw06.atm;

import dev.andrav.hw06.currency.Banknote;
import dev.andrav.hw06.currency.MyCurrency;
import dev.andrav.hw06.currency.RUB;
import dev.andrav.hw06.currency.USD;

import java.util.ArrayList;
import java.util.List;


public class DemoData {
    public static <T extends Banknote<? extends MyCurrency>> List<? super T> getDemoData() {
        List<? super T> listBanknotes = new ArrayList<>();
        int i;
        for (i = 0; i < 1; i++) {
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(100)));
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(500)));
            listBanknotes.add((T) new Banknote<MyCurrency>(USD.getInstance(50)));
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(100)));
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(1000)));
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(2000)));
            listBanknotes.add((T) new Banknote<MyCurrency>(RUB.getInstance(5000)));
        }
        return listBanknotes;
    }



}
