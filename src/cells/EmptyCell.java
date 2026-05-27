package cells;

public class EmptyCell extends Cell{

    public static final char Symbol= 'E';

    public EmptyCell(int row, int col) {
        super(row, col);
    }

    @Override
    public char getSymbol() {
        return Symbol;
    }
}
