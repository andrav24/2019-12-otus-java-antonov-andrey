package dev.andrav.atm;

import java.util.ArrayList;
import java.util.List;

public class CellImpl<T> implements Cell<T> {

    private int cellCurrentSize;
    private int cellCapacity;
    private List<T> cellStorage;

    public CellImpl() {
        this.cellCapacity = Integer.MAX_VALUE;
        this.cellCurrentSize = 0;
        this.cellStorage = new ArrayList<>();
    }

    @Override
    public int getCellCurrentSize() {
        return this.cellCurrentSize;
    }

    @Override
    public int getCellCapacity() {
        return this.cellCapacity;
    }

    @Override
    public boolean push(T banknote) {
        try {
            cellStorage.add(banknote);
            cellCurrentSize++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public T pop() {
        return cellStorage.remove(--cellCurrentSize);
    }
}
