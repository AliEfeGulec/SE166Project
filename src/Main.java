import exceptions.InvalidMapException;
import io.MapLoader;
import simulation.City;
import simulation.Simulation;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java Main <map_file> <ticks>");
            return;
        }

        int ticks = parseTicks(args[1]);
        if (ticks == -1) {
            return;
        }

        MapLoader loader = new MapLoader();

        try {
            City city = loader.load(args[0]);
            new Simulation(city).run(ticks);
        } catch (IOException e) {
            System.out.println("Could not read map file : "+e.getMessage());
        } catch (InvalidMapException e){
            System.out.println("Invalid map file: " + e.getMessage());
        }

        }

        private static int parseTicks(String raw){
            try {
                int ticks = Integer.parseInt(raw);
                if(ticks < 0){
                    System.out.println("Ticks must be a positive integer" + raw);
                    return -1;
                }
                return ticks;

            } catch (NumberFormatException e) {
                System.out.println("Invalid tick count : " + raw);
                return -1;
            }
        }

    }

