package dev.andrav.hw06.atm;

import dev.andrav.hw06.currency.Banknote;
import dev.andrav.hw06.currency.MoneyNominal;
import dev.andrav.hw06.currency.MyCurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BanknoteAnalyzer<T extends Banknote<? extends MyCurrency>> {

    private Class<? extends MyCurrency> currencyClass;
    private List<MoneyNominal> validMoneyNominals;

    public BanknoteAnalyzer(Class<? extends MyCurrency> currencyClass, MoneyNominal[] moneyNominals) {
        this.currencyClass = currencyClass;
        this.validMoneyNominals = Arrays.asList(moneyNominals);
    }

    public List<T> getAnalyze(List<T> list) {
        //System.out.println("Banknote analyzer: ");

        List<T> accepted = new ArrayList<>();
        List<T> unaccepted = new ArrayList<>(); // в данной реализации дальше не используется

        for (T banknote : list) {
            if (currencyClass.isInstance(banknote.getBanknoteCurrencyUnit())
                    && validMoneyNominals.contains(banknote.getBanknoteCurrencyUnit().getNominalType())) {
                accepted.add(banknote);
        //        System.out.println("Принимаем: " + banknote.getBanknoteValue() + " " + banknote.getBanknoteCurrencySymbol());
            } else {
                unaccepted.add(banknote);
        //        System.out.println("Отбрасываем: " + banknote.getBanknoteValue() + " " + banknote.getBanknoteCurrencySymbol());
            }
        }
        return accepted;
    }
}
