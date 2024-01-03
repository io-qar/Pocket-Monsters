package entity.item;

import java.util.List;

import entity.Player;
import entity.Pokemon;
import service.UserInput;

/**
 * Represents an item that resurrects a fainted Pokémon and restores its maximum health.
 */
public class Revive extends Item {
  private UserInput ui = new UserInput();

  public Revive(String name) {
    super(name);
  }

  public boolean use(Player player) {
    List<Pokemon> pokemons = player.getPokemons();
    int numberOfPokemons = pokemons.size();
    int countNotRevivable = 0;

    for (Pokemon p : pokemons) {
      if (!p.hasFainted()) countNotRevivable++;
    }
    if (countNotRevivable == numberOfPokemons) {
      System.out.println("All your Pokémon are alive and kicking! Try again later.");
      return false;
    }

    player.displayPokemons();
    // let user pick a number between 1 and (nr. of Pokemons)
    int newPokemonChoice = ui.readConstrainedInteger("Which Pokémon would you like to revive? Pick a number.", "Please select a number between " + 1 + " and " + numberOfPokemons, 1, numberOfPokemons);

    Pokemon selectedPokemon = pokemons.get(newPokemonChoice - 1);
    if (selectedPokemon.hasFainted()) {
        int pokemonMaxHealth = selectedPokemon.getMAXHEALTH();
        selectedPokemon.heal(pokemonMaxHealth);
        // remove revive from inventory after use
        player.removeItem(this, false);
        return true;
    }
    System.out.println("You can only revive a fainted Pokémon.");
    return false;
  }
}
