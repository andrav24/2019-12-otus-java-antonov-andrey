package dev.andrav.hw06.currency;

public class Banknote<T extends MyCurrency> implements Comparable<Banknote<T>> {

    private T currencyUnit;

    public Banknote(T currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public T getBanknoteCurrencyUnit() {
        return currencyUnit;
    }

    public int getBanknoteValue() {
        return currencyUnit.getValue();
    }

    public String getBanknoteCurrencySymbol() {
        return currencyUnit.getCurrencySymbol();
    }

    @Override
    public int compareTo(Banknote<T> o) {
        return this.getBanknoteValue() - o.getBanknoteValue();
    }
}
