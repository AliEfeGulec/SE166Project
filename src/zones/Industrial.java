package zones;

import resources.ResourceType;
import services.ServiceType;
import utilities.UtilityType;

import java.util.List;
import java.util.Set;

public class Industrial extends Zone {
    public static final char Symbol = 'I';

    public Industrial(int row, int col) {
        super(row, col);
    }

    @Override
    public char getSymbol() {
        return Symbol;
    }

    @Override
    public String displayName() {
        return "Industrial";
    }

    @Override
    public List<String> requiredUtilities() {
        return List.of(UtilityType.electricity,UtilityType.water);

        /*List<String> utilities = new ArrayList<>();
        utilities.add(UtilityType.electricity);
        utilities.add(UtilityType.water);
        return utilities; long version AEG*/
    }

    @Override
    public Set<String> requiredServices() {
        return Set.of(ServiceType.security);

    }

    @Override
    public String producedResource() {
        return ResourceType.goods;
    }

    @Override
    protected int level3Bonus() {
        return resource(ResourceType.population);
    }


}
