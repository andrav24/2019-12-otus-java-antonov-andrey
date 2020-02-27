package dev.andrav.atm;

import java.util.List;

public interface CellBox {
    int getCellAmount();
    void print();
    void push(List<?> list);
    //<T> List<T> pop();
}
