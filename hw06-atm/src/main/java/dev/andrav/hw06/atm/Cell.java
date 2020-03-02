package dev.andrav.hw06.atm;

public interface Cell<T> {
    int getCellCurrentSize();
    int getCellCapacity();
    boolean push(T unit);
    T pop();
}
