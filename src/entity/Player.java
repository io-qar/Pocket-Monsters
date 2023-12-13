package entity;

import entity.Location.Location;

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
        //this.currentLocation = ...
    }

    public String getName() {
        return name;
    }

    public void move(int deltaX, int deltaY, Map map) {
        int maxX = map.getWidth() - 1;
        int maxY = map.getHeight() - 1;
        int newX = x + deltaX;
        int newY = y + deltaY;
        if (0 <= newX && newX <= maxX && 0 <= newY && newY <= maxY) {
            // update location and show its description
            x = newX;
            y = newY;
            currentLocation = map.getLocations().get(y).get(x);
            System.out.println(currentLocation.getDescription());
        } else {
            System.out.println("Can't leave Pallet Town!");
        }
    }



}
