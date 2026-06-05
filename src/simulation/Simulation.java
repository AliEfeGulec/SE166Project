package simulation;

import zones.Zone;

public class Simulation {

    private City city;
    private ServiceDistributor services = new ServiceDistributor();
    private UtilityDistributor utilities = new UtilityDistributor();
    private  ResourseDistributor resources = new ResourseDistributor();

    public Simulation(City city) {
        this.city = city;
    }

    public void run(int ticks){
        for (int t =1;t<=ticks;t++){
            TickLog log = new TickLog();
            log.line("Tick"+t);

            for (Zone z : city.getZones()){
                z.resetForTick();
            }

            services.distribute(city, log);
            utilities.distribute(city, log);
            resources.distribute(city, log);
            updateZones(log);
            resources.accumulate(city);

            log.flush();

        }
    }
    private void updateZones(TickLog log){
        for (Zone z : city.getZones()){
            int previous = z.update();
            log.line(z+" generated "+z.getOutput()+ " " +z.producedResource());
            if (z.getLevel()>previous) {
                log.line(z+" levels up from "+ previous+ " to " + z.getLevel());
            } else if (z.getLevel()<previous) {
                log.line(z+" levels down from "+ previous+ " to " + z.getLevel());
            }
        }
    }
}
