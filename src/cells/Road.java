package cells;

public class Road extends Cell implements Connectable{

    public static final char Symbol = 'R';

    public Road(int row ,int col){
        super(row,col);
    }
    @Override
    public char getSymbol(){
        return Symbol;
    }
}
