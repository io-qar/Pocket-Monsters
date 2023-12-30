package service.commands;

import java.util.HashMap;

import entity.Item;
import entity.Map;
import entity.Player;
import entity.Pokemon;
import entity.location.ItemLocation;
import entity.location.PokemonLocation;
import service.Game;
import service.UserInput;

public class Fight extends Command {
    HashMap<String, Command> commands;
    private UserInput ui = new UserInput();
    private Player player;
    private Pokemon currPokemon;

    public Fight(Player player) {
        //three commands:
        // run
        // attack
        // use pokeball/potion
        super("fight", "enter fight mode", false);

        this.player = player;
        commands = new HashMap<>();

        addCommand(new Attack());
        addCommand(new Use());
        addCommand(new Switch(player));
    }

    private void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    @Override
    public void execute() {
        if (player.getCurrentLocation().getClass() == PokemonLocation.class) {
            // cast the location to an itemLocation
            PokemonLocation currentLoc = (PokemonLocation) player.getCurrentLocation();
            // retrieve the pokemon in current location
            Pokemon pokemon = currentLoc.getPokemon();
            int choice = ui.readConstrainedInteger("You entered the fight with " + pokemon.getName() + ". What are you gonna do?\n1. Run away;\n2. Attack the pokemon;\n3. Use a pokeball.\n", "Please enter a number between 1 and 3.", 1, 3);
            switch (choice) {
                case 1:
                    boolean outFlag = false;
                    while (!outFlag) {
                        // TODO problem with error handling
                        String direction = ui.readWord("Enter the direction (East, North, South or West) you want to run away:", "The direction you entered is incorrect! Try again:");
                        switch (direction) {
                        case "east":
                            East eastDir = new East(player);
                            eastDir.execute();
                            outFlag = true;
                            break;
                        case "north":
                            North northDir = new North(player);
                            northDir.execute();
                            outFlag = true;
                            break;
                        case "south":
                            South southDir = new South(player);
                            southDir.execute();
                            outFlag = true;
                            break;
                        case "west":
                            West westDir = new West(player);
                            westDir.execute();
                            outFlag = true;
                            break;
                        default:
                            System.out.println("");
                            break;
                        }
                    }
                    break;
                case 2:
                    fight();
                    break;
                case 3:
                    break;
            }
        }
    }

    private void fight() {
        String choice = ui.readWord("Do you want to change your current pokemon? y/n", "The pokemon you've chosen doesn't exist!");
        if (choice == "y") {
            player.changeCurrentPokemon();
        } else if (choice != "n") {
            // fight itself
        }
    }
}
