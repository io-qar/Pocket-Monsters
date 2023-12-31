package service.commands.game;

import entity.Player;
import service.UserInput;
import service.commands.Command;

public class Switch extends Command {
    private UserInput ui = new UserInput();
    private Player player;
    public Switch(Player player) {
        super("switch", "Switch your active Pokémon.", false);
        this.player = player;
    }

    @Override
    public void execute() {
        int numberOfPokemons = player.getPokemons().size();
        if (numberOfPokemons == 1) {
            System.out.println("You only have 1 Pokémon!");
        } else {
            player.displayPokemons();
            // let user pick a number between 1 and (nr. of Pokemons)
            int newPokemonChoice;
            do {
                newPokemonChoice = ui.readConstrainedInteger("Which Pokémon would you like to switch to? Pick a number.", "Please choose a number between " + 1 + " and " + numberOfPokemons,1, numberOfPokemons);
            } while (!player.switchActivePokemon(newPokemonChoice));
        }
    }
}
