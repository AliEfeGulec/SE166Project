package services;

public class PoliceStation extends Services {
    public static final char symbol = 'F';
    public static final int radius = 5;

    public PoliceStation(int row,int col){
        super(row,col,radius);
    }

    @Override
    public char getSymbol(){
        return symbol;
    }

    @Override
    public String getServiceType(){
        return ServiceType.security;
    }
}
