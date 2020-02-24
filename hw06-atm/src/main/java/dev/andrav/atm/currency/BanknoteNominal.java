package dev.andrav.atm.currency;

import java.util.stream.Stream;

/**
 * depricated
 * Номиналы для банкнот любых валют.
 */
@Deprecated
public enum BanknoteNominal implements Nominals {
    NOMINAL_10(10),
    NOMINAL_20(20),
    NOMINAL_50(50),
    NOMINAL_100(100),
    NOMINAL_200(200),
    NOMINAL_500(500),
    NOMINAL_1000(1000),
    NOMINAL_2000(2000),
    NOMINAL_5000(5000);

    private int nominalValue;

    BanknoteNominal(int nominal) {
        this.nominalValue = nominal;
    }

    @Override
    public Integer getNominalValue() {
        return nominalValue;
    }

    public static Stream<BanknoteNominal> stream() {
        return Stream.of(BanknoteNominal.values());
    }
}
