package service.commands;

import entity.Player;
import entity.location.PokemonLocation;

public class Look extends Command {
    private Player player;

    public Look(Player player) {
        super("look", "Look around in your current location.", false);
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println(player.getCurrentLocation().lookAround());
        if (player.getCurrentLocation().getClass() == PokemonLocation.class) {
            PokemonLocation pokemonLocation = (PokemonLocation) player.getCurrentLocation();
            if (pokemonLocation.getPokemon() != null) {
                Fight fightmode = new Fight(player);
                fightmode.execute();
            }
        }
    }
}