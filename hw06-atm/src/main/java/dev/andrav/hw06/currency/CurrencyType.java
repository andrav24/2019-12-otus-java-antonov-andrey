package dev.andrav.hw06.currency;

import java.util.Currency;

public enum CurrencyType {
    RUB(Currency.getInstance("RUB")),
    USD(Currency.getInstance("USD")),
    EUR(Currency.getInstance("EUR"));

    Currency currency;

    CurrencyType(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }
}
