package services;

import cells.Cell;

public abstract class Services extends Cell {
    private int radius;

    public Services(int row,int col,int radius){
        super(row, col);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
    public abstract String getServiceType();
}
