package entity.location;

public class Location {
    private String name;
    private String description;

    public Location(String name, String description) {
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
        return "Nothing interesting found here... keep exploring!\n\n" + this.getDescription();
    }
}
