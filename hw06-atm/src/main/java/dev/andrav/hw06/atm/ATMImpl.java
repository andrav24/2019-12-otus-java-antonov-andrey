package dev.andrav.hw06.atm;

import dev.andrav.hw06.algorithms.Algorithm;
import dev.andrav.hw06.algorithms.AlgorithmImpl;
import dev.andrav.hw06.currency.*;

import java.util.*;

public class ATMImpl<T extends Banknote<? extends MyCurrency>> implements ATM<T> {

    private static final int CELLS_QUANTITY = 4;

    private Class<? extends MyCurrency> currencyClass;
    private MoneyNominal[] moneyNominals = new MoneyNominal[CELLS_QUANTITY];
    private CellBox<T> cellBox;
    private BanknoteAnalyzer<T> analyzer;
    private Algorithm algorithm;

    @Override
    public void init() {
        this.currencyClass = RUB.class;

        moneyNominals[0] = MoneyNominal.NOMINAL_100;
        moneyNominals[1] = MoneyNominal.NOMINAL_500;
        moneyNominals[2] = MoneyNominal.NOMINAL_1000;
        moneyNominals[3] = MoneyNominal.NOMINAL_5000;

        this.cellBox = new CellBoxImpl<T>(moneyNominals);
        this.analyzer = new BanknoteAnalyzer<T>(this.currencyClass, this.moneyNominals);
        Map<Integer, Integer> bundle = new HashMap<>();
        this.algorithm = new AlgorithmImpl();
    }

    @Override
    public List<Banknote<?>> deposit(List<T> listOfBanknotes) {
        List<T> accepted = analyzer.getAnalyze(listOfBanknotes);
        cellBox.push(accepted);
        //return Collections.<T>emptyList();
        return (List<Banknote<?>>) accepted;
    }

    @Override
    public List<? super T> withdraw(int amount) {
        Map<Integer,Integer> bundle = new TreeMap<>();
        Arrays.stream(moneyNominals).forEach(e -> bundle.put((Integer) e.getNominalValue(),0));
        Map<Integer,Integer> bundle2 = algorithm.getBanknotesQuantity(amount, bundle, cellBox.getStorageInfo());
        List<? super T> banknotes = cellBox.pop(bundle2);
        return banknotes;
    }

    @Override
    public void getBalanceATM() {
        cellBox.printInfo(currencyClass);
    }
}
