import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        Location home = new Location(0, 0, "You entered home.");
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 20, 2);
        Location bulbasaurLoc = new PokemonLocation(0, 1, "Encountered a wild bulbasaur!", bulbasaur);
        Location forest = new Location(1, 0, "You entered the forest!");
        Location road = new Location(1, 1, "You are on the road.");
        locationsArray.add(home);
        locationsArray.add(bulbasaurLoc);
        locationsArray.add(forest);
        locationsArray.add(road);


        // convert 1D array of locations to 2D array
        for (int row = 0; row < height; row++) {
            List<Location> newRow = new ArrayList<>();
            for (int col = 0; col < width; col++) {
                newRow.add(locationsArray.get((row * col) + col));
            }
            locations.add(newRow);
        }
    }
}
