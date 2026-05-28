package zones;

import cells.Cell;
import cells.Connectable;
import cells.ServiceConsumer;
import utilities.UtilityType;

import java.util.ArrayList;

public abstract class Zone extends Cell implements Connectable, UtilityType, ServiceConsumer {
    private final ArrayList<String> utilitiesThisTick = new ArrayList<>();
    private final ArrayList<String> servicesThisTick = new ArrayList<>();

    protected Zone(int row, int col) {
        super(row, col);
    }

    public abstract ArrayList<String> getRequiredUtilities();
    public abstract ArrayList<String> getRequiredServices();

}
