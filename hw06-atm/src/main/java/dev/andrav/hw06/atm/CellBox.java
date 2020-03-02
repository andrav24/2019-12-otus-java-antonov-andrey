package dev.andrav.hw06.atm;

import java.util.List;
import java.util.Map;

public interface CellBox<T> {
    int getCellAmount();
    Map<Integer, Integer> getStorageInfo();
    void printInfo(Class<?> clazz);
    void push(List<? extends T> list);
    List<T> pop(Map<Integer, Integer> map);
}
