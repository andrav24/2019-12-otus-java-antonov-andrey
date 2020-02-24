package dev.andrav.atm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;

public abstract class AbstractCell implements Cell {

    protected int cellCurrentSize;
    protected int cellCapacity;
    protected Collection<?> cell;

    public AbstractCell() {
    }

    @Override
    public int getCellCurrentSize() {
        return 0;
    }

    @Override
    public int getCellCapacity() {
        return 0;
    }

    @Override
    public void push(Collection<?> pack) {

    }

    @Override
    public Collection<?> pull() {
        return null;
    }
}
