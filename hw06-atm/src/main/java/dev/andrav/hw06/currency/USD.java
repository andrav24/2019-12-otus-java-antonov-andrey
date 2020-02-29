package dev.andrav.hw06.currency;

public class USD extends MyCurrency {

    private static final CurrencyType CURRENCY_TYPE = CurrencyType.USD;

    private USD(MoneyNominal nominalType) {
        super(nominalType, CURRENCY_TYPE);
    }

    public static USD getInstance(int nominal) {
        switch (nominal) {
            case 1:
                return new USD(MoneyNominal.NOMINAL_1);
            case 2:
                return new USD(MoneyNominal.NOMINAL_2);
            case 5:
                return new USD(MoneyNominal.NOMINAL_5);
            case 10:
                return new USD(MoneyNominal.NOMINAL_10);
            case 20:
                return new USD(MoneyNominal.NOMINAL_20);
            case 50:
                return new USD(MoneyNominal.NOMINAL_50);
            case 100:
                return new USD(MoneyNominal.NOMINAL_100);
            default:
                throw new RuntimeException("Undefined currency nominal!");
        }
    }
}
