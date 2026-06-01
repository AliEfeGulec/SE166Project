package utilities;

public class WaterPumpingStation extends Utilities{
    public static final char symbol = 'W';

    public WaterPumpingStation(int row, int col) {
        super(row, col);
    }

    @Override
    public char getSymbol(){
        return symbol;
    }

    @Override
    public String getUtilityType(){
        return UtilityType.water;
    }
}
