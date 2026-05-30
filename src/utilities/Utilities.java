package utilities;

import cells.Cell;

public abstract class Utilities extends Cell {
    public static int capacity = 100;

    public Utilities(int row, int col){
        super(row, col);
    }
    public int getCapacity(){
        return capacity;
    }
    public abstract String getUtilityType();
}
