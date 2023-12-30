package entity;

import entity.location.Location;
import service.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int x;
    private int y;
    private Location currentLocation;
    private Pokemon currentPokemon;
    private Map playerMap;

    private UserInput ui = new UserInput();

    private List<Pokemon> pokemons;
    private List<Item> items;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.playerMap = new Map(2, 3);
        this.currentPokemon = null;
        this.currentLocation = playerMap.getLocation(x, y);
        this.pokemons = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String providedName) {
        this.name = providedName;
    }

    public void move(int deltaX, int deltaY) {
        int maxX = playerMap.getWidth() - 1;
        int maxY = playerMap.getHeight() - 1;
        int newX = x + deltaX;
        int newY = y + deltaY;
        if (0 <= newX && newX <= maxX && 0 <= newY && newY <= maxY) {
            // update location and show its description
            x = newX;
            y = newY;
            currentLocation = playerMap.getLocation(x, y);
            System.out.println(currentLocation.getDescription());
        } else {
            System.out.println("You ran into a wall...");
        }
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName() == itemName) return item;
        }
        return null;
    }

    public Pokemon getPokemon(String pokemonName) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName() == pokemonName) return pokemon;
        }
        return null;
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("You don't have any items in your inventory.");
            return;
        }
        for (Item item : items) {
            System.out.println("|\t" + item);
        }
        return;
    }

    public void displayPokemons() {
        if (pokemons.isEmpty()) {
            System.out.println("You don't have any pokemons.");
            return;
        }
        System.out.println("You have these pokemons:");
        for (Pokemon pokemon : pokemons) {
            System.out.println("|\t" + pokemon);
        }
        return;
    }

    public void changeCurrentPokemon() {
        if (getPokemons().isEmpty()) {
            System.out.println("You don't have any pokemon");
            return;
        }
        displayPokemons();
        String choice = ui.readWord("Enter a name of your pokemon from the inventory:", "It must be a single word");

        Pokemon newCurrentPokemon = getPokemon(choice);
        if (newCurrentPokemon != null) {
            currentPokemon = newCurrentPokemon;
        } else System.out.println("There is no such pokemon in your inventory");
        return;
    }
}
