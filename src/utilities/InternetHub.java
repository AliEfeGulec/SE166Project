package utilities;

public class InternetHub extends Utilities{
    public static char symbol = 'T';

    public InternetHub(int row, int col){
        super(row, col);
    }
    @Override
    public char getSymbol(){
        return symbol;
    }
    @Override
    public String getUtilityType(){
        return UtilityType.internet;
    }
}
