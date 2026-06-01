package services;

public class School extends Services{
    public static final char symbol = 'S';
    public static final int radius = 4;

    public School(int row, int col){
        super(row,col,radius);
    }

    @Override
    public char getSymbol(){
        return symbol;
    }

    @Override
    public String getServiceType(){
        return ServiceType.education;
    }
}
