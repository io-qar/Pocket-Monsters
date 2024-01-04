package service;

import entity.Map;
import entity.Player;
import entity.Pokemon;
import service.commands.Command;
import service.commands.battle.Cheat;
import service.commands.game.*;

import java.util.HashMap;

public class Game {
    private boolean inProgress = false;
    private UserInput ui = new UserInput();
    private Map map;
    private Player player;

    /**
     * Represents commands which can be typed in the console during the game
     */
    HashMap<String, Command> commands;

    public Game() {
        // create game
        map = new Map(3, 3);
        // spawn player on (x, y) = (0, 0)
        player = new Player(map.getLocation(0, 0));

        commands = new HashMap<>();
        // add commands here!
        addCommand(new Exit(this));
        addCommand(new North(player, map));
        addCommand(new East(player, map));
        addCommand(new South(player, map));
        addCommand(new West(player, map));
        addCommand(new Help(commands, false));
        addCommand(new Look(player, this));
        addCommand(new Take(player));
        addCommand(new Fight(this, player));
        addCommand(new Switch(player));
        addCommand(new Inventory(player));
        addCommand(new Pokemons(player));
        addCommand(new Use(player));
        addCommand(new Drop(player));
    }

    public void start() {
        giveIntroduction();
        inProgress = true;
        while (inProgress) {
            Command cmd = ui.command(this.player, this.commands);
            cmd.execute();
        }
    }

    public void stop(boolean won) {
        if (won) {
            System.out.println("================ CONGRATS, YOU WON! ===============");
        } else {
            System.out.println("==================== GAME OVER ====================");
        }
        inProgress = false;
    }

    private void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    private void giveIntroduction() {
        String name = ui.readLine("Welcome to Pallet Town! My name is Professor Oak. What's yours?", "Please enter a valid name.");
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

        Pokemon starterPokemon = new Pokemon(pokemonName, 12, 2);
        this.player.addPokemon(starterPokemon);
        System.out.println("Great choice! Now go out there and explore the world! \nIf at any point you are unsure what to do, simply call the \"help\" command.");
    }
}
