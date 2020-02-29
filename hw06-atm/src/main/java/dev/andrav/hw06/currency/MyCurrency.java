package dev.andrav.hw06.currency;

import java.util.Currency;
import java.util.Objects;

public abstract class MyCurrency {

    protected MoneyNominal nominalType;
    protected CurrencyType currencyType;

    protected MyCurrency(MoneyNominal nominalType, CurrencyType currencyType) {
        this.nominalType = nominalType;
        this.currencyType = currencyType;
    }

    public MoneyNominal getNominalType() {
        return this.nominalType;
    }

    public Integer getValue() {
        return (Integer) nominalType.getNominalValue();
    }

    public Currency getCurrency() {
        return currencyType.getCurrency();
    }

    public String getCurrencySymbol() {
        return getCurrency().getSymbol();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyCurrency)) return false;
        MyCurrency that = (MyCurrency) o;
        return nominalType.equals(that.nominalType) &&
                currencyType == that.currencyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominalType, currencyType);
    }
}
