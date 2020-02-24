package dev.andrav.atm;

import java.util.ArrayList;
import java.util.Collection;

public class CellImpl extends AbstractCell {

    private static int MAX_CELL_CAPACITY = 2500;
    private int cellNominalValue;

    public CellImpl(int cellNominalValue) {
        super();
        this.cellNominalValue = cellNominalValue;
        this.cellCapacity = MAX_CELL_CAPACITY;
        this.cellCurrentSize = 0;
    }
}
