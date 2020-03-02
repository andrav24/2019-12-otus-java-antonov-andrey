package dev.andrav.hw06.utils;

import dev.andrav.hw06.currency.Banknote;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Utils {
    public static void printListOfBanknotesInfo(List<Banknote<?>> listBanknotes) {
        long sum = 0;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (Banknote<?> banknote : listBanknotes) {
            sum += banknote.getBanknoteValue();
            Integer value = count.get(banknote.getBanknoteValue());
            count.put(banknote.getBanknoteValue(), (value == null) ? 1 : value + 1);
        }
        for (Map.Entry m : count.entrySet())
            System.out.println("Nominal " + m.getKey() +  " is " + m.getValue() + " unit");

        if (sum == 0) {
            System.out.println("Sorry, the required amount cannot be issued.");
        }
        System.out.println("Total sum is " + sum);
    }

}
