package service;

import entity.Player;
import entity.Pokemon;
import service.commands.*;

import java.util.HashMap;

public class Game {
    private boolean inProgress = false;
    private UserInput ui = new UserInput();
    private Player player;
    HashMap<String, Command> commands;

    public Game() {
        // could ask user for size of map. could randomize locations...
        player = new Player(0, 0);
        commands = new HashMap<>();

        addCommand(new Exit(this));
        addCommand(new North(player));
        addCommand(new East(player));
        addCommand(new South(player));
        addCommand(new West(player));
        addCommand(new Help(commands));
        addCommand(new Look(player));
        addCommand(new Take(player));
    }

    public void start() {
        giveIntroduction();
        inProgress = true;
        while (inProgress) {
            Command cmd = ui.command(this.player, this.commands);
            cmd.execute();
        }
    }

    public void stop() {
        inProgress = false;
    }

    private void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    public void giveIntroduction() {
        String name = ui.readWord("Welcome to Pallet Town! My name is Professor Oak. What's yours?", "Please enter a valid name.");
        this.player.setName(name);
        System.out.printf("Hi %s!\n", name);

        int choice = ui.readConstrainedInteger("To begin your adventure you will need at least one Pokémon. Please choose one of the following Pokémon:\n1) Bulbasaur\n2) Charmander\n3) Squirtle", "Please enter a number between 1 and 3.", 1, 3);

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
