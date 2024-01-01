package entity.location;

public class Location {
    private int y;
    private int x;
    private String name;
    private String description;

    public Location(int y, int x, String name, String description) {
        this.y = y;
        this.x = x;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String lookAround() {
        // return this.getDescription();
        return "Nothing found here... keep exploring!";
    }
}
