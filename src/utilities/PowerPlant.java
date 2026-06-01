package utilities;

public class PowerPlant extends Utilities{
    public static final char symbol = 'P';

    public PowerPlant(int row, int col) {
        super(row, col);
    }

    @Override
    public char getSymbol(){
        return symbol;
    }

    @Override
    public String getUtilityType(){
        return UtilityType.electricity;
    }
}
