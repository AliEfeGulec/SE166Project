package simulation;

import services.Services;
import zones.Zone;

public class ServiceDistributor {

   public void distribute(City city, TickLog log ) {
        for (Services service : city.getServices()) {
            String Service = service.getServiceType();
            for (Zone zone : city.getZones()) {
                if (!zone.requiredServices().contains(Service)) {
                    continue;
                }
                if (service.covers(zone.getRow(),zone.getCol())){
                    zone.receiveService(Service);
                    log.line(zone + " received " + Service + " service");
                }
            }
        }
    }
}
