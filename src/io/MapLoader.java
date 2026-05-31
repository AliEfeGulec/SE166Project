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
        factories.put(EmptyCell.SYMBOL, (row, col) -> new EmptyCell(row, col));
        factories.put(Road.SYMBOL, (row, col) -> new Road(row, col));
        factories.put(Housing.SYMBOL, (row, col) -> new Housing(row, col));
        factories.put(Industrial.SYMBOL, (row, col) -> new Industrial(row, col));
        factories.put(Commercial.SYMBOL, (row, col) -> new Commercial(row, col));
        factories.put(InternetHub.SYMBOL, (row, col) -> new InternetHub(row, col));
        factories.put(PoliceStation.SYMBOL, (row, col) -> new PoliceStation(row, col));}
    
}
