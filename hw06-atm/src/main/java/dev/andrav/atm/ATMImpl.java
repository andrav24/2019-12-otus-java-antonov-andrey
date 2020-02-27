package dev.andrav.atm;

import dev.andrav.atm.currency.*;
import java.util.List;

public class ATMImpl implements ATM {

    private Class<? extends MyCurrency> currencyClass;
    private CellBox cellBox;
    private BanknoteAnalyzer<Banknote<?>> analyzer;

    @Override
    public void init() {
        this.currencyClass = RUB.class;
        this.analyzer = new BanknoteAnalyzer(this.currencyClass);
        this.cellBox = new CellBoxImpl(
                MoneyNominal.NOMINAL_100,
                MoneyNominal.NOMINAL_500,
                MoneyNominal.NOMINAL_1000,
                MoneyNominal.NOMINAL_5000
        );
    }

    @Override
    public <T extends Banknote<?>> void deposit(List<T> cash) {


        List<T> accepted = (List<T>) analyzer.getAnalyze((List<Banknote<?>>) cash);
        cellBox.addBanknotes((List<Banknote<?>>) accepted);
        cellBox.print();
        //return Collections.<T>emptyList();
    }

    @Override
    public List<Banknote<?>> withdraw(int amount) {
        return null;
    }

    @Override
    public void getBalanceATM() {
        cellBox.print();
    }

}
