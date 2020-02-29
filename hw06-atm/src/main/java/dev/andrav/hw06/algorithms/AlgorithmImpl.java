package dev.andrav.hw06.algorithms;

import java.util.Collections;
import java.util.Map;
import java.util.TreeSet;

public class AlgorithmImpl implements Algorithm {

    public Map<Integer, Integer> getBanknotesQuantity(
            int amount, Map<Integer, Integer> bundle, Map<Integer, Integer> storageInfo) {

        int minKey = Collections.min(bundle.keySet());
        if (amount % minKey > 0) {
            return bundle;
        }

        for (Integer key : new TreeSet<>(bundle.keySet()).descendingSet()) {
            if (amount >= key) {
                int storageAmount = storageInfo.get(key);
                int banknoteQuantity = amount / key;

                if (banknoteQuantity > storageAmount) {
                    banknoteQuantity = storageAmount;
                }
                bundle.put(key, banknoteQuantity);
                amount = amount - key * banknoteQuantity;
            }
        }

        return bundle;
    }
}
