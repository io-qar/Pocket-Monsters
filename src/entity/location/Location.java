package entity.location;

public class Location {
    private int x;
    private int y;
    private String name;
    private String description;

    public Location(int x, int y, String name, String description) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
