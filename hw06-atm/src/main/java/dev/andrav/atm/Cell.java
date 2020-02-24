package dev.andrav.atm;

import java.util.Collection;

public interface Cell {
    int getCellCurrentSize();
    int getCellCapacity();
    void push(Collection<?> pack);
    Object pull();
}
