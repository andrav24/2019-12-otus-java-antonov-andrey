package dev.andrav.hw06.currency;

public class RUB extends MyCurrency {

    private static final CurrencyType CURRENCY_TYPE = CurrencyType.RUB;

    private RUB(MoneyNominal nominalType) {
        super(nominalType, CURRENCY_TYPE);
    }

    public static RUB getInstance(int nominal) {
        switch (nominal) {
            case 10:
                return new RUB(MoneyNominal.NOMINAL_10);
            case 50:
                return new RUB(MoneyNominal.NOMINAL_50);
            case 100:
                return new RUB(MoneyNominal.NOMINAL_100);
            case 200:
                return new RUB(MoneyNominal.NOMINAL_200);
            case 500:
                return new RUB(MoneyNominal.NOMINAL_500);
            case 1000:
                return new RUB(MoneyNominal.NOMINAL_1000);
            case 2000:
                return new RUB(MoneyNominal.NOMINAL_2000);
            case 5000:
                return new RUB(MoneyNominal.NOMINAL_5000);
            default:
                throw new RuntimeException("Undefined currency nominal!");
        }
    }
}
