import java.util.ArrayList;
import java.util.List;

public class Map {
    int width; // number of locations in x direction
    int height; // number of locations in y direction

    List<Location> locations;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.locations = new ArrayList<>();
    }

    public void addLocation(Location loc) {
        this.locations.add(loc);
    }
}
