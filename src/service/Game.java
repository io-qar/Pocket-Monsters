package service;

import entity.Player;
import entity.Map;
import entity.Pokemon;
import service.commands.*;

import java.util.HashMap;

public class Game {
    private boolean inProgress = false;
    private UserInput ui = new UserInput();
    private Map map;
    private Player player;
    HashMap<String, Command> commands;

    public Game() {
        // create game
        // could ask user for size of map. could randomize locations...
        this.map = new Map(2, 2);
        // this.commands = new ArrayList<>();
        commands = new HashMap<>();
        // add commands here!
        addCommand(new North());
        addCommand(new Exit());
        addCommand(new East());
        addCommand(new South());
        addCommand(new West());
        addCommand(new Help());
    }

    public void start(Game game) {
        giveIntroduction();
        inProgress = true;
        while (inProgress) {
            Command cmd = ui.command(this.player, this.commands);
            if (cmd != null) cmd.execute(this.player, this.map, game, this.commands);

            // if player has 0 pokemons -> inProgress = false
            // if player chooses exit -> inProgress = false
        }
    }

    public void stop() {
        inProgress = false;
    }

    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    public void giveIntroduction() {
        String name = ui.string("Welcome to Pallet Town! My name is Professor Oak. What's yours?", "Please enter a valid name.");
        this.player = new Player(name);
        System.out.printf("Hi %s!\n", name);

        int choice = ui.constrainedInteger("To begin your adventure you will need at least one Pokémon. Please choose one of the following Pokémon:\n1) Bulbasaur\n2) Charmander\n3) Squirtle", "Please enter a number between 1 and 3.", 1, 3);

        String pokemonName = "";
        switch (choice) {
            case 1:
                pokemonName = "Bulbasaur";
                break;
            case 2:
                pokemonName = "Charmander";
                break;
            case 3:
                pokemonName = "Squirtle";
                break;
        }

        System.out.printf("You picked %s.\n", pokemonName);
        Pokemon starterPokemon = new Pokemon(pokemonName, 20, 2);
        this.player.addPokemon(starterPokemon);

        System.out.println("Great choice! Now go out there and explore the world! \nIf at any point you are unsure what to do, simply call the \"help\" command.");
    }
}
