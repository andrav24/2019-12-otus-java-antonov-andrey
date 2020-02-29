package dev.andrav.hw06.currency;

import java.util.stream.Stream;

/**
 * Номиналы для любых валют.
 */

public enum MoneyNominal {
    NOMINAL_0_01(0.01f),
    NOMINAL_0_50(0.50f),
    NOMINAL_1(1),
    NOMINAL_2(2),
    NOMINAL_5(5),
    NOMINAL_10(10),
    NOMINAL_20(20),
    NOMINAL_50(50),
    NOMINAL_100(100),
    NOMINAL_200(200),
    NOMINAL_500(500),
    NOMINAL_1000(1000),
    NOMINAL_2000(2000),
    NOMINAL_5000(5000);

    private Number nominalValue;

    MoneyNominal(Number nominal) {
        this.nominalValue = nominal;
    }

    public Number getNominalValue() {
        return nominalValue;
    }

    public static Stream<MoneyNominal> stream() {
        return Stream.of(MoneyNominal.values());
    }
}
