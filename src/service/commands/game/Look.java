package service.commands.game;

import entity.Player;
import service.Game;
import service.commands.Command;


public class Look extends Command {
    private Player player;
    private Game game;
    public Look(Player player, Game game) {
        super("look", "Look around in your current location.", false);
        this.player = player;
        this.game = game;
    }

    @Override
    public void execute() {
        System.out.println(player.getCurrentLocation().lookAround());

        /** comment/uncomment this part to not have/have pokemon battles starting automatically upon looking */
        /*if (player.getCurrentLocation().getClass() == PokemonLocation.class) {
            // cast the location to a pokemonLocation
            PokemonLocation currentLoc = (PokemonLocation) player.getCurrentLocation();
            // retrieve the pokemon in current location
            Pokemon pokemon = currentLoc.getPokemon();
            if (pokemon != null) {
                // start a battle between you and the enemy
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
        }*/
    }
}