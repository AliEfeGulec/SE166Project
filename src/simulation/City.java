package simulation;

import cells.Cell;
import zones.Zone;
import services.Services;
import utilities.Utilities;


import java.util.ArrayList;
import java.util.List;

public class City {
    private final int rows;
    private final int cols;
    private final Cell[][] grid;

    private final List<Zone> zones = new ArrayList<>();
    private final List <Utilities> utilities = new ArrayList<>();
    private final List<Services> services = new ArrayList<>();

    public City(Cell[][] grid) {
        this.rows = grid.length;
        this.cols = rows == 0 ? 0 : grid[0].length;
        this.grid = grid;
        index();
    }
    public int getRows() {
        return rows; }
    public int getCols() {
        return cols;
    }
    public Cell getCell(int r, int c) {
        return grid[r][c];
    }
    public boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
    public List<Zone> getZones() {
        return zones;
    }
    public List<Utilities> getProviders(){
        return utilities;
    }
    public List<Services> getServices(){
        return services;
    }

    private void index() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid[r][c];
                if (cell instanceof Zone) {
                    zones.add((Zone) cell);
                } else if (cell instanceof Utilities) {
                    utilities.add((Utilities) cell);
                } else if (cell instanceof Services) {
                    services.add((Services) cell);
                }
            }
        }
    }



}
