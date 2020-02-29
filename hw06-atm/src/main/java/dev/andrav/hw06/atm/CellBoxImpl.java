package dev.andrav.hw06.atm;

import dev.andrav.hw06.currency.Banknote;
import dev.andrav.hw06.currency.MoneyNominal;
import dev.andrav.hw06.currency.MyCurrency;
import java.util.*;

public class CellBoxImpl<T extends Banknote<? extends MyCurrency>> implements CellBox<T> {

    private Map<Integer, Cell<T>> storage = new TreeMap<>();
    private Map<Integer, Long> info = new TreeMap<>();
    private int cellAmount;

    public CellBoxImpl(MoneyNominal... cellNominal) {
        Set.of(cellNominal).forEach(e -> storage.put((Integer) e.getNominalValue(), new CellImpl<>()));
        cellAmount = storage.size();
    }

    @Override
    public void push(List<? extends T> banknotes) {
        banknotes.forEach(e -> storage.get((e).getBanknoteValue()).push(e));
    }

    @Override
    public List<T> pop(Map<Integer, Integer> bundle) {
        List<T> banknotes = new ArrayList<>();
        for (Integer bundleKey : new TreeSet<>(bundle.keySet())) {
            int banknoteQuantity = bundle.get(bundleKey);
            if (banknoteQuantity != 0) {
                for (int i = 0; i < banknoteQuantity; i++) {
                    banknotes.add(((T) storage.get(bundleKey).pop()));
                }
            }
        }
        return banknotes;
    }

    @Override
    public int getCellAmount() {
        return cellAmount;
    }

    public long getBalance() {
        long total = 0;
        for (Integer key : storage.keySet()) {
            total += key * storage.get(key).getCellCurrentSize();
        }
        return total;
    }

    public Map<Integer, Integer> getStorageInfo() {
        Map<Integer, Integer> storageInfo = new HashMap<>();
        for (Integer key : storage.keySet()) {
            storageInfo.put(key, storage.get(key).getCellCurrentSize());
        }
        return storageInfo;
    }

    public void printInfo(Class<?> currencyClass) {
        System.out.println("Balance info: ");
        storage.forEach((key, value) ->
                System.out.println(String.format("%-10s %-20s %-30s %-20s %-20s",
                        "Cell ",
                        "Nominal: " + key + " " + currencyClass.getSimpleName(),
                        "Capacity: " + storage.get(key).getCellCapacity(),
                        "Current size: " + storage.get(key).getCellCurrentSize(),
                        "Total: " + key * storage.get(key).getCellCurrentSize() + " " + currencyClass.getSimpleName())));

        System.out.println("============================");
        System.out.println("Total balance: " + getBalance() + " " + currencyClass.getSimpleName());
    }
}
