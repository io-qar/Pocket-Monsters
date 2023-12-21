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
    // switch <name of pokemon>
    super("fight", "...", true);

    commands = new HashMap<>();
    this.player = player;
    
    //TODO: check player's pokemons
    // if (this.player.)

    addCommand(new Run());
    addCommand(new Attack());
    addCommand(new Use(/* */));
    addCommand(new Switch(/* */)); // TODO: return current pokemon
  }

  private void addCommand(Command command) {
    this.commands.put(command.getName(), command);
  }

  @Override
  public void execute() {
    if (player.getCurrentLocation().getClass() == PokemonLocation.class) {
            // cast the location to an itemLocation
            PokemonLocation currentLoc = (PokemonLocation) player.getCurrentLocation();
            // retrieve the item in current location
            Pokemon pokemon = currentLoc.getPokemon();
            if (pokemon == null || !argument.equalsIgnoreCase(pokemon.getName())) {
                System.out.println("There is no \"" + argument + "\" here...");
            }
            // else {
            //      currentLoc.removeItem();
            //     player.addItem(pokemon);
            //     System.out.println(pokemon.getName() + " added to inventory!");
            // }
        } else {
            System.out.println("There is no \"" + argument + "\" here...");
        }




    boolean inProgress = true;
        while (inProgress) {
            Command cmd = ui.command(this.player, this.commands);
            cmd.execute();
        }
  }
}
