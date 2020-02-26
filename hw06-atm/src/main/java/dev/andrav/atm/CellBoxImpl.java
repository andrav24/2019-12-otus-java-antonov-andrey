package dev.andrav.atm;

import dev.andrav.atm.currency.Banknote;
import dev.andrav.atm.currency.MoneyNominal;
import dev.andrav.atm.currency.MyCurrency;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CellBoxImpl implements CellBox {

    private Map<Integer, Cell<Banknote<?>>> storage = new TreeMap<>();
    private Map<Integer, Long> info = new TreeMap<>();
    private int cellAmount;

    public CellBoxImpl(MoneyNominal... cellNominal) {
        Set.of(cellNominal).forEach(e -> storage.put((Integer) e.getNominalValue(), new CellImpl<>()));
        cellAmount = storage.size();
    }

    public <T extends MyCurrency> void push(List<Banknote<T>> banknotes) {
        banknotes.forEach(e -> storage.get(e.getBanknoteValue()).push(e));
    }

    public <T extends MyCurrency> List<Banknote<T>> pop() {
        return null;
    }

    @Override
    public int getCellAmount() {
        return cellAmount;
    }

    public void print() {
        System.out.println(storage.size());
        storage.forEach((key,value) ->
                System.out.println(
                                "Cell " + key +
                                ":\tCapacity: " + storage.get(key).getCellCapacity() +
                                "\tCurrent size: " + storage.get(key).getCellCurrentSize()));
        System.out.println("Cell nominals: ");
        storage.keySet().forEach(System.out::println);
    }
}
