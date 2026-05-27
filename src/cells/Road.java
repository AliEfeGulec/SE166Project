package cells;

public class Road extends Cell /* implements Connectable (henüz yazılmadı/not written yet) */{

    public static final char Symbol = 'R';

    public Road(int row ,int col){
        super(row,col);
    }
    @Override
    public char getSymbol(){
        return Symbol;
    }
}
