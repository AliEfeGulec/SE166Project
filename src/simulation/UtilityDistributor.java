package simulation;

import cells.Cell;
import cells.Connectable;
import utilities.Utilities;
import zones.Zone;

import java.util.ArrayDeque;
import java.util.Queue;

public class UtilityDistributor {

    private static int[] DR = { -1, 1, 0, 0};
    private static int[] DC = { 0, 0, -1, 1};

    void distribute(City city,TickLog log ) {
    for (Utilities utilities : city.getProviders()){
        propagate(utilities, city, log);
    }
    }

    private void propagate(Utilities provider, City city, TickLog log) {
        String type = provider.getUtilityType();
        int remaining = provider.getCapacity();

        boolean[][] visited = new boolean[city.getRows()][city.getCols()];
        Queue<int[]> queue = new ArrayDeque<>();

        // seed from the provider's connectable neighbours
        enqueueNeighbours(provider.getRow(), provider.getCol(), city, visited, queue);

        while (!queue.isEmpty() && remaining-- > 0) {
            int[] next = queue.poll();
            int r = next[0], c = next[1];
            Cell cell = city.getCell(r, c);

            if (cell instanceof Zone ){
                Zone zone = (Zone) cell;
                if (zone.requiredUtilities().contains(type)) {
                    int want = zone.getDemand() - zoneAlreadyHas(zone, type);
                    if (want > 0) {
                        int give = Math.min(want, remaining);
                        zone.receiveUtility(type, give);
                        remaining -= give;
                        log.line(zone+ " received "+give+" "+type);
                    }
                }
            }
            enqueueNeighbours(r, c, city, visited, queue);
        }

    }

    private int zoneAlreadyHas(Zone zone, String type) {
        return zone.received(type);
    }

    private void enqueueNeighbours(int r, int c, City city, boolean[][] visited, Queue<int[]> queue) {
        for (int d = 0 ; d < 4; d++){
            int nr = r + DR[d], nc = c + DC[d];
            if (city.inBounds(nr, nc) && !visited[nr][nc]
             && city.getCell(nr, nc) instanceof Connectable) {
                visited[nr][nc] = true;
                queue.add(new int[] { nr, nc });
            }
        }
    }


    }
