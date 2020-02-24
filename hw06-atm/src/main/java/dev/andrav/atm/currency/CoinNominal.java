package dev.andrav.atm.currency;

/**
 * depricated
 * В программе не используется.
 * Класс введен для демонстрационных целей.
 */

@Deprecated
public enum CoinNominal implements Nominals {
    NOMINAL_0_01(0.01f),
    NOMINAL_0_50(0.50f),
    NOMINAL_1_00(1.00f),
    NOMINAL_10_00(10.00f);

    private float nominalValue;

    CoinNominal(float nominalValue) {
        this.nominalValue = nominalValue;
    }

    @Override
    public Float getNominalValue() {
        return nominalValue;
    }
}
