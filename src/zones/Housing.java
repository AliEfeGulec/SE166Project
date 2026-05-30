package zones;

import resources.ResourceType;
import services.ServiceType;
import utilities.UtilityType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Housing extends Zone{
    public static final char Symbol = 'H';

    public Housing(int row,int col){
        super(row,col);
    }

    @Override
    public char getSymbol() {
        return Symbol;
    }

    @Override
    public String displayName() {
        return "House";
    }

    @Override
    public List<String> requiredUtilities() {
        return List.of(UtilityType.electricity,UtilityType.internet,UtilityType.water);

        /*List<String> utilities = new ArrayList<>();
        utilities.add(UtilityType.electricity);
        utilities.add(UtilityType.internet);
        utilities.add(UtilityType.water);
        return utilities; long version AEG*/
    }

    @Override
    public Set<String> requiredServices() {
        return Set.of(ServiceType.security,ServiceType.health,ServiceType.education);
    }

    @Override
    public String producedResource() {
        return ResourceType.population;
    }

    @Override
    protected int level3Bonus() {
        return resource(ResourceType.lifestyle);
    }
}
