package zones;

import cells.Cell;
import cells.Connectable;
import cells.ServiceConsumer;
import cells.UtilityConsumer;
import utilities.UtilityType;

import java.util.*;

public abstract class Zone extends Cell implements Connectable {
    private int level = 0;
    private int output = 0;
    private int demand = 1;

    public int getLevel() {
        return level;
    }

    public int getOutput() {
        return output;
    }

    public int getDemand() {
        return demand;
    }

    private final Map<String,Integer> utilities = new HashMap<>();
    private final List<String> services = new ArrayList<>();
    private final Map<String,Integer> resources = new HashMap<>();


    protected Zone(int row, int col) {
        super(row, col);
    }

    public abstract String displayName();

    @Override
    public String toString(){
        return displayName()+" at ("+getRow()+","+getCol()+")";
    }

    public abstract List<String> requiredUtilities();
    public abstract Set<String> requiredServices();
    public abstract String producedResource();
    protected abstract int level3Bonus();

    public void receiveUtility(String type,int amount){
        utilities.merge(type,amount,Integer::sum);

        /*if(utilities.containsKey(type)){
            int old = utilities.get(type);
            utilities.put(type,old+amount);
        }else{
            utilities.put(type,amount);
        } long method AEG*/
    }
    public void receiveService(String service){
        if(!services.contains(service)){
            services.add(service);
        }
    }
    public void receiveResource(String type,int amount){
        resources.merge(type,amount,Integer::sum);

        /*if(resources.containsKey(type)){
            int old = resources.get(type);
            resources.put(type,old+amount);
        }else{
            resources.put(type,amount);
        } long method AEG*/
    }

    @Override
    public void resetForTick(){
        utilities.clear();
        services.clear();
        resources.clear();
    }

    protected int utility(String type){
        return utilities.getOrDefault(type,0);

        /*Integer amount = utilities.get(type);

        if(amount==null){
            return 0;
        }else {
            return amount;
        } long method AEG*/
    }

    public int received (String type){
        return utility(type);
    }

    protected int resource(String type){
        return resources.getOrDefault(type,0);
        /*Integer amount = resources.get(type);

        if(amount==null){
            return 0;
        }else {
            return amount;
        } long method AEG*/
    }
    protected boolean hasService(String s){
        return services.contains(s);
    }

    protected boolean hasAllUtilities(){
        for(String u :requiredUtilities()){
            if(utility(u)<=0){
                return false;
            }
        }
        return true;
    }

    protected int minUtility(){
        if(!hasAllUtilities()){
            return 0;
        }
        int m = Integer.MAX_VALUE;
        for(String u : requiredUtilities()){
            m=Math.min(m , utility(u));
        }
        return m == Integer.MAX_VALUE ? 0 : m;
    }

    private int computeTargetLevel(){
        if(!hasAllUtilities()){
            return 0;
        }
        if(!services.containsAll(requiredServices())){
            return 1;
        }
        return level3Bonus() > 0 ? 3 : 2;
    }

    private int computeOutput(){
        int m = minUtility();
        switch (level){
            case 0 :
                return 0;
            case 1 :
                return m;
            case 2 :
                return 2*m;
            default:
                return 2*m +level3Bonus();
        }
    }

    public int update(){
        int previous = level;
        int target = computeTargetLevel();

        if(target == 0){
            level = 0;
        }else if(target > previous){
            level = previous +1;
        }else if(target < previous){
            level = previous -1;
        }
        output = computeOutput();
        demand = Math.max(output,1);
        return previous;
    }
}