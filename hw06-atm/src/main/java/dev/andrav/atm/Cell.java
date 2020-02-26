package dev.andrav.atm;

import java.rmi.NotBoundException;
import java.util.List;

public interface Cell<T> {
    int getCellCurrentSize();
    int getCellCapacity();
    boolean push(T unit);
    T pop();
}
