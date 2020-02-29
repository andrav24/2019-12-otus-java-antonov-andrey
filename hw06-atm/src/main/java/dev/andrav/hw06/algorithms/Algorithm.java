package dev.andrav.hw06.algorithms;

import java.util.Map;

public interface Algorithm {
    Map<Integer, Integer> getBanknotesQuantity(int amount, Map<Integer, Integer> bundle, Map<Integer, Integer> storageInfo);
}
