package entity;

import entity.location.PokemonLocation;
import java.util.ArrayList;
import java.util.List;

import entity.location.Location;

public class Map {
    int width; // number of locations in x direction (columns)
    int height; // number of locations in y direction (rows)

    List<List<Location>> locations;

    public Map(int height, int width) {
        this.width = width;
        this.height = height;
        this.locations = new ArrayList<>();

        // create locations and put them in 1D array
        ArrayList<Location> locationsArray = new ArrayList<>();

        Location home = new Location(0, 0, "Home", "You entered Home.");
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 20, 2);
        Location bulbasaurLoc = new PokemonLocation(1, 0, "Home", "Encountered a wild bulbasaur!", bulbasaur);
        Location forest = new Location(0, 1, "Forest", "You entered the Forest.");
        Location road = new Location(1, 1, "Road", "You are on the Road.");
        locationsArray.add(home);
        locationsArray.add(bulbasaurLoc);
        locationsArray.add(forest);
        locationsArray.add(road);


        // convert 1D array of locations to 2D array
        for (int row = 0; row < height; row++) {
            List<Location> newRow = new ArrayList<>();
            for (int col = 0; col < width; col++) {
                newRow.add(locationsArray.get((row * width) + col));
            }
            locations.add(newRow);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<List<Location>> getLocations() {
        return locations;
    }
}
