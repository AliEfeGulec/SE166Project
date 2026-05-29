package zones;

import cells.Cell;
import cells.Connectable;
import cells.ServiceConsumer;
import cells.UtilityConsumer;
import utilities.UtilityType;

import java.util.ArrayList;
import java.util.List;

public abstract class Zone extends Cell implements Connectable, UtilityConsumer, ServiceConsumer {
    private final List<String> utilitiesThisTick = new ArrayList<>();
    private final List<String> servicesThisTick = new ArrayList<>();

    protected Zone(int row, int col) {
        super(row, col);
    }

    public abstract List<String> getRequiredUtilities();
    public abstract List<String> getRequiredServices();

    @Override
    public void supply(String utility){
        utilitiesThisTick.add(utility);
    }

    @Override
    public boolean isSupplied(String utility){
        return utilitiesThisTick.contains(utility);
    }

    @Override
    public void receiveService(String service){
        servicesThisTick.add(service);
    }

    @Override
    public boolean isServed(String service){
        return servicesThisTick.contains(service);
    }

    @Override
    public void resetForTick(){
        utilitiesThisTick.clear();
        servicesThisTick.clear();
    }
    public boolean isFullyOperational(){
        return utilitiesThisTick.containsAll(getRequiredUtilities()) && servicesThisTick.containsAll(getRequiredServices());

    }
}
