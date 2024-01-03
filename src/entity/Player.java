package entity;

import entity.item.Item;
import entity.location.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a current player entity
 */
public class Player {
    private String name;

    /**
     * X coordinate
     */
    private int x;

    /**
     * Y coordinate
     */
    private int y;

    /**
     * A name of a location where the player is now
     */
    private Location currentLocation;

    /**
     * A list of pokemons owned by the player
     */
    private List<Pokemon> pokemons;

    /**
     * A list of items owned by the player
     */
    private List<Item> inventory;

    public Player(Location startLocation) {
        this.x = 0;
        this.y = 0;
        this.currentLocation = startLocation;
        this.pokemons = new ArrayList<>();
        this.inventory = new ArrayList<>();
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
            currentLocation = map.getLocation(y, x);
            System.out.println(currentLocation.getDescription());
        } else {
            System.out.println("You ran into a wall...");
        }
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    /**
     * Add an {@link Item item} to the inventory
     * @param item An item to be added to the inventory
     */
    public void addItem(Item item) {
        this.inventory.add(item);
        System.out.println(item.getName() + " was added to inventory!");
    }

    /**
     * Remove an item from the invetory
     * @param item An item to be removed from the inventory
     * @param displayMessages A message to be displayed about the dropped item
     */
    public void removeItem(Item item, boolean displayMessages) {
        this.inventory.remove(item);
        if (displayMessages) System.out.println(item.getName() + " has been dropped from your inventory.");
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        }
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + 1 + ") " + inventory.get(i));
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    /**
     * Adds a {@link Pokemon} to the {@link #pokemons list of pokemons}
     * @param pokemon
     */
    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
        System.out.println(pokemon.getName() + " was added to your Pokémon!");
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    /**
     * A main pokemon of the player.
     * @return The first one by default. Another option would be to keep a seperate instance  variable 'activePokemon' which points to the current active Pokémon in pokemons.
     */
    public Pokemon getActivePokemon() {
        return pokemons.get(0);
    }

    /**
     * Switches the active pokemon with another one.
     * @param newIndex An index of new active Pokémon in the {@link #pokemons list of the pokemons}
     * @return A new active Pokemon, {@code null} if failed.
     */
    public Pokemon switchActivePokemon(int newIndex) {
        if (newIndex < 0 || newIndex > pokemons.size() - 1) {
            System.out.println("Index out of range");
            return null;
        }
        if (pokemons.get(newIndex).hasFainted()) {
            System.out.println("Cannot switch to a fainted Pokémon!");
            return null;
        }
        Collections.swap(pokemons, 0, newIndex);
        System.out.println("Switched to " + getActivePokemon().getName() + "!");
        return getActivePokemon();
    }

    public void displayPokemons() {
        for (int i = 0; i < pokemons.size(); i++) {
            if (i == 0) {
                System.out.println(i + 1 + ") " + pokemons.get(i) + " <-- active");
            } else {
                System.out.println(i + 1 + ") " + pokemons.get(i));
            }
        }
    }

    public boolean hasPokemonsAlive() {
        for (Pokemon p : pokemons) {
            if (!p.hasFainted()) {
                return true;
            }
        }
        return false;
    }
}
