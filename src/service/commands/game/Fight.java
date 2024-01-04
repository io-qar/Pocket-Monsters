package service.commands.game;

import entity.Player;
import entity.Pokemon;
import entity.location.GymLocation;
import entity.location.PokemonLocation;
import service.Battle;
import service.Game;
import service.commands.Command;

public class Fight extends Command {
    private Player player;
    private Game game;

    public Fight(Game game, Player player) {
        super("fight", "Fight an opponent using 'fight [opponent name]'", true);
        this.player = player;
        this.game = game;
    }

    /**
     * Executes the fight command
     */
    @Override
    public void execute() {
        if (player.getCurrentLocation().getClass() == GymLocation.class) {
            // cast the location to a gymLocation
            GymLocation currentLoc = (GymLocation) player.getCurrentLocation();
            // retrieve the pokemon in current location
            Pokemon pokemon = currentLoc.getPokemon();
            if (pokemon == null || !argument.equalsIgnoreCase(currentLoc.getGymTrainer())) {
                System.out.println("There is no \"" + argument + "\" here...");
            } else {
                // start a battle between you and the gym trainer's pokemon
                Battle battle = new Battle(player, pokemon, true);
                battle.start();
                // After a battle, if the enemy pokemon has fainted, player has won the game!
                if (pokemon.hasFainted()) {
                    game.stop(true);
                }
                // After a battle, if all the players' pokemon have fainted, it's game over
                if (!player.hasPokemonsAlive()) {
                    game.stop(false);
                }
             }
        } else if (player.getCurrentLocation().getClass() == PokemonLocation.class) {
            // cast the location to a pokemonLocation
            PokemonLocation currentLoc = (PokemonLocation) player.getCurrentLocation();
            // retrieve the pokemon in current location
            Pokemon pokemon = currentLoc.getPokemon();
            if (pokemon == null || !argument.equalsIgnoreCase(pokemon.getName())) {
                System.out.println("There is no \"" + argument + "\" here...");
            } else {
                // start a battle between you and the enemy pokemon
                Battle battle = new Battle(player, pokemon, false);
                battle.start();
                // After a battle, if the enemy pokemon has fainted, remove it from this location
                if (pokemon.hasFainted()) {
                    currentLoc.removePokemon();
                }
                // After a battle, if all the players' pokemon have fainted, it's game over
                if (!player.hasPokemonsAlive()) {
                    game.stop(false);
                }
            }
        } else {
            System.out.println("There is no \"" + argument + "\" here...");
        }
    }
}
