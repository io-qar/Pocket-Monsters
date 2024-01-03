package service.commands.game;

import entity.Player;
import service.commands.Command;

public class Pokemons extends Command {
    private Player player;

    public Pokemons(Player player) {
        super("pokemons", "Display your Pokémon.", false);
        this.player = player;
    }

    /**
     * Executes the pokemons command
     */
    @Override
    public void execute() {
        player.displayPokemons();
    }
}
