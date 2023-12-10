public class Location {
    private int x;
    private int y;
    private String description;

    public Location(int x, int y, String description) {
        this.x = x;
        this.y = y;
        this.description = description;
    }
    public String showDescription() {
        return this.description;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
