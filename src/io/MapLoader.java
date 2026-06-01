package io;
import cells.Cell;
import cells.EmptyCell;
import cells.Road;
import exceptions.InvalidMapException;
import services.PoliceStation;
import utilities.InternetHub;
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
    }
    
}
