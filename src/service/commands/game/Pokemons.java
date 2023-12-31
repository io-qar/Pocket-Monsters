package service.commands.game;

import entity.Player;
import service.commands.Command;

public class Pokemons extends Command {
    private Player player;

    public Pokemons(Player player) {
        super("pokemons", "Display your pokemon.", false);
        this.player = player;
    }

    @Override
    public void execute() {
        player.displayPokemons();
    }
}
