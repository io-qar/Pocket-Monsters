package service.commands.game;

import entity.Player;
import entity.Pokemon;
import entity.location.PokemonLocation;
import service.Battle;
import service.Game;
import service.commands.Command;

public class Fight extends Command {
    private Player player;
    private Game game;

    public Fight(Game game, Player player) {
        //three commands:
        // run
        // attack
        // use pokeball/potion
        // switch <name of pokemon>
        super("fight", "Fight a Pokémon using 'fight [Pokémon_name]'", true);
        this.player = player;
        this.game = game;
    }

    @Override
    public void execute() {
        if (player.getCurrentLocation().getClass() == PokemonLocation.class) {
            // cast the location to a pokemonLocation
            PokemonLocation currentLoc = (PokemonLocation) player.getCurrentLocation();
            // retrieve the pokemon in current location
            Pokemon pokemon = currentLoc.getPokemon();
            if (pokemon == null || !argument.equalsIgnoreCase(pokemon.getName())) {
                System.out.println("There is no \"" + argument + "\" here...");
            } else {
                // start a battle between you and the enemy
                Battle battle = new Battle(player, pokemon);
                battle.start();
                // After a battle, if the enemy pokemon has fainted, remove it from this location
                if (pokemon.hasFainted()) {
                    currentLoc.removePokemon();
                }
                // After a battle, if all the players' pokemon have fainted, it's game over
                if (!player.hasPokemonsAlive()) {
                    game.stop();
                }
             }
        } else {
            System.out.println("There is no \"" + argument + "\" here...");
        }
    }
}
