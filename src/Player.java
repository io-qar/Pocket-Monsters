public class Player {
    private final String name;
    // player's current coordinates
    private int x;
    private int y;
    private Location currentLocation;

    public Player(String name) {

        this.name = name;
        this.x = 0;
        this.y = 0;
    }

    public String getName() {
        return name;
    }

    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }



}
