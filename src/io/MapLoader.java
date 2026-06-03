package io;
import cells.Cell;
import cells.EmptyCell;
import cells.Road;
import exceptions.InvalidMapException;
import services.Hospital;
import services.PoliceStation;
import services.School;
import simulation.City;
import utilities.InternetHub;
import utilities.PowerPlant;
import utilities.WaterPumpingStation;
import zones.Commercial;
import zones.Housing;
import zones.Industrial;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapLoader {

    private final Map<Character, Buildable> factories =
            new HashMap<>();

    public MapLoader() {
        factories.put(EmptyCell.Symbol, (row, col) -> new EmptyCell(row, col));
        factories.put(Road.Symbol, (row, col) -> new Road(row, col));
        factories.put(Housing.Symbol, (row, col) -> new Housing(row, col));
        factories.put(Industrial.Symbol, (row, col) -> new Industrial(row, col));
        factories.put(Commercial.Symbol, (row, col) -> new Commercial(row, col));
        factories.put(PowerPlant.symbol, (row, col) -> new PowerPlant(row,col));
        factories.put(WaterPumpingStation.symbol, (row, col) ->  new WaterPumpingStation(row,col));
        factories.put(InternetHub.symbol, (row, col) -> new InternetHub(row,col));
        factories.put(PoliceStation.symbol, (row, col) -> new PoliceStation(row,col));
        factories.put(Hospital.symbol, (row, col) -> new Hospital(row,col));
        factories.put(School.symbol, (row, col) -> new School(row,col));
    }
    public City load(String mapPath) throws IOException, InvalidMapException {
       Path path = Paths.get(mapPath);
       List<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        }

        if (lines.isEmpty()) {
            throw new InvalidMapException("Map file is empty:" + mapPath);
        }

        int rows = lines.size();
        int cols = lines.get(0).length();
        Cell[][] grid = new Cell[rows][cols];


        for (int r = 0; r < rows; r++) {
            String line = lines.get(r);
            if (line.length() != cols) {
                throw new InvalidMapException("Row " + (r + 1) + " width " + line.length() + " != row 1 width " + cols);
            }

            for (int c = 0; c < cols; c++) {
                char symbol = line.charAt(c);
                Buildable factory = factories.get(symbol);
                if (factory == null) {
                    throw new InvalidMapException("Unknown symbol '" + symbol + "' at (" + r + "," + c + ")");
                }

                grid[r][c] = factory.build(r, c);
            }

        }
        return new City(grid);
    }
}
