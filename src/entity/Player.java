package entity;

import entity.location.ItemLocation;
import entity.location.Location;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    // player's current coordinates
    private int x;
    private int y;
    private Location currentLocation;

    private List<Pokemon> pokemons;
    private List<Item> items;

    public Player(Location startLocation) {
        this.x = 0;
        this.y = 0;
        this.currentLocation = startLocation;
        this.pokemons = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String providedName) {
        this.name = providedName;
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
            System.out.println("You ran into a wall...");
        }
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
    public void addItem(Item item) {
        this.items.add(item);
    }

}
