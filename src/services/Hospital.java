package services;

public class Hospital extends Services{
    public static final char symbol = 'D';
    public static final int radius = 3;

    public Hospital(int row, int col) {
        super(row,col,radius);
    }

    @Override
    public char getSymbol(){
        return symbol;
    }

    @Override
    public String getServiceType(){
        return ServiceType.health;
    }
}
