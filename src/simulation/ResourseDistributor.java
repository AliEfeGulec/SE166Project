package simulation;

import resources.ResourceType;
import zones.Commercial;
import zones.Housing;
import zones.Industrial;
import zones.Zone;

import java.util.ArrayList;
import java.util.List;

public class ResourseDistributor {

    private int populationPool = 0;
    private int goodsPool = 0;
    private int lifestylePool = 0;


    private void share (int pool,List <Zone> targets, String type,TickLog log){
        if(pool<=0 || targets.isEmpty()) return;
        int each = pool/targets.size();
        if (each<0) return;
        for (Zone z : targets) {
            z.receiveResource(type,each);
            log.line(z + " received " + each + " " + type);
        }


    }


    void distribute(City city, TickLog log) {
        List<Zone> industrialAndcommercial = new ArrayList<>();
        List<Zone> commercial = new ArrayList<>();
        List<Zone> housing = new ArrayList<>();

        for (Zone z : city.getZones()){
            if (z instanceof Industrial || z instanceof Commercial) industrialAndcommercial.add(z);
            if (z instanceof Commercial) commercial.add(z);
            if (z instanceof Housing) housing.add(z);
        }

        share(populationPool,industrialAndcommercial, ResourceType.population,log);
        share(goodsPool,commercial,ResourceType.goods,log);
        share(lifestylePool,housing,ResourceType.lifestyle,log);

    }


    void accumulate(City city) {
        populationPool = 0;
        goodsPool = 0;
        lifestylePool = 0;
        for (Zone z : city.getZones()){
            String produced = z.producedResource();
            int out = z.getOutput();
            if (ResourceType.population.equals(produced)) populationPool+=out;
          else if (ResourceType.goods.equals(produced)) goodsPool+=out;
          else if (ResourceType.lifestyle.equals(produced)) lifestylePool+=out;
        }
    }



    }
