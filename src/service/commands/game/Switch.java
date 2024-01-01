package service.commands.game;

import entity.Player;
import entity.Pokemon;
import service.Battle;
import service.UserInput;
import service.commands.Command;

public class Switch extends Command {
    private UserInput ui = new UserInput();
    private Player player;
    private Battle battle = null; // if null, we are in game mode, else we are in battle mode

    /**
     * switch in game mode
     */
    public Switch(Player player) {
        super("switch", "Switch your active Pokémon.", false);
        this.player = player;
        this.battle = null;
    }

    /**
     * switch in battle mode
     */
    public Switch(Player player, Battle battle) {
        super("switch", "Switch your active Pokémon.", false);
        this.player = player;
        this.battle = battle;
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
            Pokemon newPokemon = null;
            do {
                newPokemonChoice = ui.readConstrainedInteger("Which Pokémon would you like to switch to? Pick a number.", "Please choose a number between " + 1 + " and " + numberOfPokemons,1, numberOfPokemons);
                newPokemon = player.switchActivePokemon(newPokemonChoice - 1);
            } while (newPokemon == null);
            if (battle != null) {
                // if in battle mode, swap own pokemon in battle to new active pokemon
                battle.setOwnPokemon(newPokemon);
            }
        }
    }
}
