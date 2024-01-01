package entity;

import entity.item.Item;
import entity.location.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String name;
    // player's current coordinates
    private int x;
    private int y;
    private Location currentLocation;

    private List<Pokemon> pokemons;
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

    /******* Item related methods **********/

    public void addItem(Item item) {
        this.inventory.add(item);
        System.out.println(item.getName() + " added to inventory!");
    }

    public void removeItem(Item item, boolean displayMessages) {
        this.inventory.remove(item);
        if (displayMessages) System.out.println("Dropped " + item.getName() + " from inventory.");
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

    /******* Pokemon related methods **********/
    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
        System.out.println(pokemon.getName() + " was added to your Pokémon!");
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public Pokemon getActivePokemon() {
        // first Pokémon is active Pokémon. Another option would be to keep a seperate instance variable 'activePokemon' which points to the current active Pokémon in pokemons.
        return pokemons.get(0);
    }

    /**
     * @param newIndex index of new active Pokémon
     * @return new active Pokemon, null if failed.
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
